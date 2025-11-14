// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.typer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.expresso.ast.Argument;
import com.expresso.ast.ArrowNode;
import com.expresso.ast.AtomicNode;
import com.expresso.ast.BinaryOp;
import com.expresso.ast.BooleanNode;
import com.expresso.ast.CastNode;
import com.expresso.ast.Constructor;
import com.expresso.ast.DataDeclaration;
import com.expresso.ast.FunNode;
import com.expresso.ast.FuncCall;
import com.expresso.ast.InstantiatorNode;
import com.expresso.ast.Lambda;
import com.expresso.ast.LetStatement;
import com.expresso.ast.Node;
import com.expresso.ast.NoneNode;
import com.expresso.ast.Num;
import com.expresso.ast.PrintStatement;
import com.expresso.ast.Program;
import com.expresso.ast.StringNode;
import com.expresso.ast.TernaryExpression;
import com.expresso.ast.TupleNode;
import com.expresso.ast.TypeNode;
import com.expresso.ast.TypeVar;
import com.expresso.ast.Variable;

// Typer class for type inference
// Goes through the AST and infers types for nodes
public class Typer {

    private final Env globalEnv;
    // Minimal symbol tables for the typer
    private final Set<String> primitiveTypes = Set.of("any", "void", "int", "float", "string", "boolean");
    private final Set<String> userTypes = new HashSet<>(); // data type names
    private final Map<String, ConstructorSig> constructors = new HashMap<>(); // ctor name -> signature

    private record ConstructorSig(String dataType, List<TypeNode> paramTypes) {
    }

    // --------------------------------------------------------------
    // Unification
    // --------------------------------------------------------------
    private int tvCounter = 0;
    // Substitution mapping from type variable name to a concrete type
    private final Map<String, TypeNode> subst = new HashMap<>();

    // Typer with the provided global environment.
    public Typer(Env globalEnv) {
        this.globalEnv = globalEnv;

        // Predefine basic types and functions
        ArrowNode intBinOp = new ArrowNode(
                new TupleNode(List.of(new AtomicNode("int"), new AtomicNode("int"))),
                new AtomicNode("int"));
        globalEnv.define("+", intBinOp);
        globalEnv.define("-", intBinOp);
        globalEnv.define("*", intBinOp);
        globalEnv.define("/", intBinOp);
        globalEnv.define("**", intBinOp);
        globalEnv.define("!**", intBinOp);
    }

    // Get the global environment
    public Env getEnv() {
        return globalEnv;
    }

    public TypeNode infer(Node node) {
        return infer(node, globalEnv);
    }

    // Infer/validate the type of a node in the given environment. On error, throws
    // RuntimeException
    public TypeNode infer(Node node, Env env) {
        return switch (node) {
            // Program → Visit all statements
            case Program(var statements) -> {
                TypeNode lastType = new AtomicNode("void");
                for (Node stmt : statements) {
                    lastType = infer(stmt, env);
                }
                yield lastType;
            }

            // Number → Int
            case Num pNumber -> {
                Objects.requireNonNull(pNumber);
                yield new AtomicNode("int");
            }

            // Strings → String
            case StringNode pString -> {
                Objects.requireNonNull(pString);
                yield new AtomicNode("string");
            }

            // Booleans → Boolean
            case BooleanNode pBoolean -> {
                Objects.requireNonNull(pBoolean);
                yield new AtomicNode("boolean");
            }

            // None → Void
            case NoneNode() -> new AtomicNode("void");

            // Cast → validate target type
            case CastNode(var expr, var targetType) -> {
                // Infer the expression type (para validar que existe)
                infer(expr, env);
                // Validate if target type exists
                assertTypeExists(targetType);
                // Return the target type
                yield targetType;
            }

            // Variables
            case Variable(var name) -> {
                TypeNode t = env.find(name);
                if (t == null)
                    throw new RuntimeException("Undefined variable: " + name);
                yield t;
            }

            // LetStatement → Infer the type
            case LetStatement(var name, var declaredType, var expr) -> {
                // Check if already defined in env (let/fun) or as data/constructor
                if (env.has(name)) {
                    throw new RuntimeException("Identifier redefined: " + name);
                }
                if (userTypes.contains(name) || constructors.containsKey(name)) {
                    throw new RuntimeException("Identifier redefined: " + name);
                }

                // Handle explicitly declared type first (including lambdas)
                if (declaredType != null) {
                    assertTypeExists(declaredType);

                    if (expr instanceof Lambda) {
                        env.define(name, declaredType);
                        TypeNode inferred = infer(expr, env);
                        unify(inferred, declaredType);
                        TypeNode finalType = apply(declaredType);
                        env.define(name, finalType);
                        yield finalType;
                    }

                    TypeNode inferred = infer(expr, env);
                    unify(inferred, declaredType);
                    TypeNode finalType = apply(declaredType);
                    env.define(name, finalType);
                    yield finalType;
                }

                // Support recursive lambdas by pre-registering their signature
                if (expr instanceof Lambda lambdaExpr) {
                    TypeNode assumedType = assumeLambdaSignature(lambdaExpr);
                    env.define(name, assumedType);
                    TypeNode inferred = infer(expr, env);
                    unify(assumedType, inferred);
                    TypeNode finalType = apply(assumedType);
                    env.define(name, finalType);
                    yield finalType;
                }

                // Infer type and add to environment for non-function bindings
                TypeNode type = apply(infer(expr, env));
                env.define(name, type);
                yield type;
            }

            // FunNode → Function declaration (supports recursion)
            case FunNode(var name, var params, var declaredReturnType, var body) -> {
                // Check if already defined in env (let/fun) or as data/constructor
                if (env.has(name)) {
                    throw new RuntimeException("Identifier redefined: " + name);
                }
                if (userTypes.contains(name) || constructors.containsKey(name)) {
                    throw new RuntimeException("Identifier redefined: " + name);
                }

                // Validate declared return type exists (if present)
                if (declaredReturnType != null) {
                    assertTypeExists(declaredReturnType);
                }

                // Create parameter types from declared params
                List<TypeNode> paramTypes = new ArrayList<>();
                List<String> paramNames = new ArrayList<>();
                for (var a : params) {
                    TypeNode pt = a.type() != null ? a.type() : new AtomicNode("any");
                    if (a.type() != null) assertTypeExists(pt);
                    paramTypes.add(pt);
                    String pname = a.name() != null ? a.name() : ("p" + (paramNames.size() + 1));
                    paramNames.add(pname);
                }

                // Determine return type (declared or fresh for inference)
                TypeNode provisionalReturn = declaredReturnType != null ? declaredReturnType : fresh();

                // Create function arrow type
                TypeNode inputType = paramTypes.size() == 1
                        ? paramTypes.get(0)
                        : new TupleNode(paramTypes);
                ArrowNode funcType = new ArrowNode(inputType, provisionalReturn);

                // Register function BEFORE processing body (for recursion)
                env.define(name, funcType);

                // Create local environment
                Env localEnv = new Env(env);
                for (int i = 0; i < paramNames.size(); i++) {
                    localEnv.define(paramNames.get(i), paramTypes.get(i));
                }

                // Infer the body type
                TypeNode bodyType = infer(body, localEnv);

                if (declaredReturnType != null) {
                    unify(bodyType, declaredReturnType);
                } else {
                    unify(provisionalReturn, bodyType);
                }

                TypeNode finalType = apply(funcType);
                env.define(name, finalType);
                yield finalType;
            }

            // DataDeclaration → Register data type
            case DataDeclaration(var typeName, var ctors) -> {
                // Check in all envioremnts because data name must be diferento to let, fun,
                // constructors
                if (env.has(typeName) || userTypes.contains(typeName) || constructors.containsKey(typeName)) {
                    throw new RuntimeException("Identifier redefined: " + typeName);
                }
                userTypes.add(typeName);

                for (Constructor c : ctors) {
                    String cname = c.name();
                    // Check in all enviroments
                    if (env.has(cname) || userTypes.contains(cname) || constructors.containsKey(cname)) {
                        throw new RuntimeException("Identifier redefined: " + cname);
                    }
                    // Check if exist constructor argument types
                    List<TypeNode> paramTypes = new ArrayList<>();
                    for (Argument a : c.arguments()) {
                        if (a.type() != null) {
                            assertTypeExists(a.type());
                            paramTypes.add(a.type());
                        }
                    }
                    constructors.put(cname, new ConstructorSig(typeName, paramTypes));
                }

                yield new AtomicNode(typeName);
            }

            // InstantiatorNode
            case InstantiatorNode(var ctorName, var args) -> {
                ConstructorSig sig = constructors.get(ctorName);
                if (sig == null) {
                    throw new RuntimeException("Undefined constructor: " + ctorName);
                }
                if (sig.paramTypes().size() != args.size()) {
                    throw new RuntimeException("Arity mismatch for constructor '" + ctorName + "': expected "
                            + sig.paramTypes().size() + ", got " + args.size());
                }
                // Infer args to check type
                for (Node arg : args) {
                    infer(arg, env);
                }
                // Resulting type is the data type
                yield new AtomicNode(sig.dataType());
            }

            // PrintStatement
            case PrintStatement(var expression) -> {
                infer(expression, env);
                yield new AtomicNode("void");
            }

            // Binary Operations
            case BinaryOp(var op, var left, var right) -> {
                Objects.requireNonNull(op);
                TypeNode lt = infer(left, env);
                TypeNode rt = infer(right, env);
                // String concatenation
                if ("+".equals(op) && (isAtomic(lt, "string") || isAtomic(rt, "string"))) {
                    yield new AtomicNode("string");
                }

                // Relational operators -> boolean result, numeric operands
                if (isRelational(op)) {
                    unify(lt, new AtomicNode("int"));
                    unify(rt, new AtomicNode("int"));
                    yield new AtomicNode("boolean");
                }

                // Logical operators -> boolean operands & result
                if (isLogical(op)) {
                    unify(lt, new AtomicNode("boolean"));
                    unify(rt, new AtomicNode("boolean"));
                    yield new AtomicNode("boolean");
                }

                TypeNode opType = env.find(op);
                if (opType == null) {
                    unify(lt, new AtomicNode("int"));
                    unify(rt, new AtomicNode("int"));
                    yield new AtomicNode("int");
                }
                TypeNode appliedOpType = apply(opType);
                if (appliedOpType instanceof ArrowNode arrow) {
                    TypeNode argsType = new TupleNode(List.of(apply(lt), apply(rt)));
                    unify(arrow.inputType(), argsType);
                    yield apply(arrow.returnType());
                }
                throw new RuntimeException("Operator '" + op + "' is not a function");
            }

            // Lambda
            case Lambda(var params, var body) -> {
                Env local = new Env(env); // Create a new box (local environment)

                List<TypeNode> paramTypes = new ArrayList<>();
                for (String p : params) {
                    TypeNode t = fresh();
                    local.define(p, t);
                    paramTypes.add(t);
                }

                TypeNode returnType = infer(body, local);
                TypeNode inputType = paramTypes.size() == 1 ? paramTypes.get(0) : new TupleNode(paramTypes);

                yield new ArrowNode(inputType, returnType);
            }

            // FuncCall
            case FuncCall(var func, var args) -> {
                TypeNode funcType = apply(infer(func, env));
                List<TypeNode> argTypes = new ArrayList<>();
                for (Node a : args) {
                    argTypes.add(apply(infer(a, env)));
                }

                if (funcType instanceof ArrowNode arrow) {
                    TypeNode actualInput = argTypes.size() == 1 ? argTypes.get(0) : new TupleNode(argTypes);
                    unify(arrow.inputType(), actualInput);
                    yield apply(arrow.returnType());
                }

                throw new RuntimeException("Error on function call: " + funcType);
            }

            // Ternary Expression
            case TernaryExpression(var condition, var trueBranch, var falseBranch) -> {
                TypeNode condType = apply(infer(condition, env));
                // Allow condition to be int OR boolean per spec exception
                // If it's a type variable, try to unify with int
                if (condType instanceof TypeVar) {
                    unify(condType, new AtomicNode("int"));
                    condType = apply(condType);
                }
                if (!isAtomic(condType, "int") && !isAtomic(condType, "boolean")) {
                    throw new RuntimeException(
                            "Ternary condition must be int or boolean, got: " + typeToSurface(condType));
                }

                TypeNode trueType = infer(trueBranch, env);
                TypeNode falseType = infer(falseBranch, env);

                // Unify both branches to a common type
                unify(trueType, falseType);
                yield apply(trueType);
            }

            default -> new AtomicNode("any");
        };
    }

    // --------------------------------------------------------------
    // Helpers
    // --------------------------------------------------------------
    private TypeNode assumeLambdaSignature(Lambda lambdaExpr) {
        List<TypeNode> paramTypes = new ArrayList<>();
        for (int i = 0; i < lambdaExpr.parameters().size(); i++) {
            paramTypes.add(fresh());
        }

        TypeNode inputType = switch (paramTypes.size()) {
            case 0 -> new TupleNode(List.<TypeNode>of());
            case 1 -> paramTypes.get(0);
            default -> new TupleNode(paramTypes);
        };

        TypeNode returnType = fresh();
        return new ArrowNode(inputType, returnType);
    }

    private void assertTypeExists(TypeNode t) {
        if (!typeExists(t)) {
            throw new RuntimeException("Undefined type: " + typeToSurface(t));
        }
    }

    // Recursively checks that all atomic types.
    private boolean typeExists(TypeNode t) {
        return switch (t) {
            case AtomicNode a -> primitiveTypes.contains(a.name()) || userTypes.contains(a.name());
            case TupleNode tuple -> tuple.elements().stream().allMatch(this::typeExists);
            case ArrowNode arrow -> typeExists(arrow.inputType()) && typeExists(arrow.returnType());
            default -> true;
        };
    }

    private String typeToSurface(TypeNode t) {
        return switch (t) {
            case AtomicNode a -> a.name();
            case TupleNode tuple -> "(" + tuple.elements().stream().map(this::typeToSurface)
                    .reduce((a, b) -> a + ", " + b).orElse("") + ")";
            case ArrowNode arrow -> typeToSurface(arrow.inputType()) + " -> " + typeToSurface(arrow.returnType());
            case TypeVar tv -> tv.name();
            default -> "~";
        };
    }

    // Unification
    private TypeNode fresh() {
        return new TypeVar("t" + (tvCounter++));
    }

    public TypeNode apply(TypeNode t) {
        return applyRec(t);
    }

    private TypeNode applyRec(TypeNode t) {
        if (t instanceof TypeVar tv) {
            TypeNode sub = subst.get(tv.name());
            if (sub == null)
                return tv;
            return applyRec(sub);
        }
        if (t instanceof AtomicNode) {
            return t;
        }
        if (t instanceof TupleNode tuple) {
            List<TypeNode> els = new ArrayList<>();
            for (TypeNode e : tuple.elements()) {
                els.add(applyRec(e));
            }
            return new TupleNode(els);
        }
        if (t instanceof ArrowNode arrow) {
            return new ArrowNode(applyRec(arrow.inputType()), applyRec(arrow.returnType()));
        }
        return t;
    }

    private void unify(TypeNode a, TypeNode b) {
        TypeNode ta = apply(a);
        TypeNode tb = apply(b);

        if (ta == tb || ta.equals(tb))
            return;

        // Any wildcard
        if (isAny(ta))
            return; // Any with anything yields the other; no binding needed
        if (isAny(tb))
            return;

        if (ta instanceof TypeVar tva) {
            bind(tva, tb);
            return;
        }
        if (tb instanceof TypeVar tvb) {
            bind(tvb, ta);
            return;
        }
        if (ta instanceof AtomicNode aa && tb instanceof AtomicNode ab) {
            if (!aa.name().equals(ab.name())) {
                throw new RuntimeException("Type mismatch: " + typeToSurface(ta) + " vs " + typeToSurface(tb));
            }
            return;
        }
        if (ta instanceof TupleNode at && tb instanceof TupleNode bt) {
            if (at.elements().size() != bt.elements().size()) {
                throw new RuntimeException("Tuple mismatch: " + typeToSurface(ta) + " vs " + typeToSurface(tb));
            }
            for (int i = 0; i < at.elements().size(); i++) {
                unify(at.elements().get(i), bt.elements().get(i));
            }
            return;
        }
        if (ta instanceof ArrowNode af && tb instanceof ArrowNode bf) {
            unify(af.inputType(), bf.inputType());
            unify(af.returnType(), bf.returnType());
            return;
        }

        throw new RuntimeException("Cannot unify: " + typeToSurface(ta) + " with " + typeToSurface(tb));
    }

    private void bind(TypeVar v, TypeNode t) {
        if (occurs(v, t)) {
            throw new RuntimeException("Check failed: " + v.name() + " in " + typeToSurface(t));
        }
        subst.put(v.name(), t);
    }

    private boolean occurs(TypeVar v, TypeNode t) {
        TypeNode tt = apply(t);
        if (tt instanceof TypeVar tv) {
            return tv.name().equals(v.name());
        }
        if (tt instanceof TupleNode tuple) {
            for (TypeNode e : tuple.elements()) {
                if (occurs(v, e))
                    return true;
            }
            return false;
        }
        if (tt instanceof ArrowNode arrow) {
            return occurs(v, arrow.inputType()) || occurs(v, arrow.returnType());
        }
        return false;
    }

    private boolean isAny(TypeNode t) {
        return (t instanceof AtomicNode a) && (a.name().equals("Any") || a.name().equals("any"));
    }

    private boolean isRelational(String op) {
        return Set.of("<", "<=", ">", ">=", "==", "!=").contains(op);
    }

    private boolean isLogical(String op) {
        return Set.of("&&", "||").contains(op);
    }

    private boolean isAtomic(TypeNode t, String name) {
        return t instanceof AtomicNode a && a.name().equals(name);
    }
}
