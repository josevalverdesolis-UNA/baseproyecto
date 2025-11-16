// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.visitors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import com.expresso.ast.Argument;
import com.expresso.ast.ArrowNode;
import com.expresso.ast.AtomicNode;
import com.expresso.ast.BinaryOp;
import com.expresso.ast.BooleanNode;
import com.expresso.ast.CastNode;
import com.expresso.ast.Constructor;
import com.expresso.ast.DataDeclaration;
import com.expresso.ast.DataPattern;
import com.expresso.ast.FunNode;
import com.expresso.ast.FuncCall;
import com.expresso.ast.InstantiatorNode;
import com.expresso.ast.Lambda;
import com.expresso.ast.LetStatement;
import com.expresso.ast.ListNode;
import com.expresso.ast.MatchExpression;
import com.expresso.ast.MatchRule;
import com.expresso.ast.NativePattern;
import com.expresso.ast.Node;
import com.expresso.ast.NoneNode;
import com.expresso.ast.Num;
import com.expresso.ast.Pattern;
import com.expresso.ast.PrintStatement;
import com.expresso.ast.Program;
import com.expresso.ast.StringNode;
import com.expresso.ast.TernaryExpression;
import com.expresso.ast.TupleNode;
import com.expresso.ast.TypeNode;
import com.expresso.ast.TypeVar;
import com.expresso.ast.UnaryOp;
import com.expresso.ast.Variable;
import com.expresso.features.Feature;
import com.expresso.features.HelperLibrary;
import com.expresso.grammar.ExprLexer;
import com.expresso.typer.Env;
import com.expresso.typer.Typer;

/**
 * This class is responsible for transpiling the custom AST nodes into Java
 * code.
 * It generates a complete Java class with necessary imports, helper methods,
 * and a main method.
 */
public class AstTranspiler {
    // --------------------------------------------------------------
    // Variables
    // --------------------------------------------------------------
    private final String className;
    private final Set<Feature> features;
    private final CommonTokenStream tokens;
    private int indentLevel = 0;
    // private final Map<String, String> variableTypes = new HashMap<>();
    private final Typer typer;
    private final Env globalEnv;
    private final Map<String, ConstructorInfo> constructorInfos = new HashMap<>();
    private final Set<String> userTypes = new HashSet<>();
    private int patternVarCounter = 0;

    // --------------------------------------------------------------
    // Constructor
    // --------------------------------------------------------------
    public AstTranspiler(String className, Set<Feature> features, CommonTokenStream tokens) {
        this(className, features, tokens, null);
    }

    public AstTranspiler(String className, Set<Feature> features, CommonTokenStream tokens, Typer existingTyper) {
        this.className = Character.toUpperCase(className.charAt(0)) + className.substring(1);
        this.features = features;
        this.tokens = tokens;

        if (existingTyper != null) {
            this.typer = existingTyper;
            this.globalEnv = existingTyper.getEnv();
        } else {
            // Create new typer / environment
            this.globalEnv = new Env(null);
            this.typer = new Typer(globalEnv);
        }
    }

    // --------------------------------------------------------------
    // Getters
    // --------------------------------------------------------------
    public Env getGlobalEnv() {
        return globalEnv;
    }

    // --------------------------------------------------------------
    // Methods
    // --------------------------------------------------------------
    public String transpile(Node node, Env env) {
        return switch (node) {
            // Program
            case Program(var statements) -> generateJavaClass(statements);

            // Print Statement
            case PrintStatement(var expr) -> {
                features.add(Feature.PRINT);

                yield "print(" + transpile(expr, env) + ");";
            }

            // Led Statements
            case LetStatement(var name, var declaredType, var expr) -> {
                // Special handling for InstantiatorNode - use Object type
                String typeName;
                TypeNode resolvedType = null;
                if (declaredType != null) {
                    TypeNode appliedDeclared = typer != null ? typer.apply(declaredType) : declaredType;
                    env.define(name, appliedDeclared);
                    resolvedType = appliedDeclared;
                    typeName = typeNodeToJava(appliedDeclared);
                } else if (expr instanceof InstantiatorNode) {
                    typeName = "Object"; // Use Object for data type instances
                    env.define(name, new AtomicNode("Any"));
                } else {
                    TypeNode type = typer.infer(expr, env);
                    type = typer.apply(type);
                    env.define(name, type);
                     resolvedType = type;
                    typeName = typeNodeToJava(type);
                }

                String exprCode = transpile(expr, env);

                FunctionalDescriptor lambdaDescriptor =
                        resolvedType instanceof ArrowNode arrow ? describeFunctionalInterface(arrow) : null;

                if (expr instanceof Lambda && exprCode != null) {
                    String methodName = lambdaDescriptor != null ? lambdaDescriptor.invocationMethod() : "apply";
                    String invocationToken = name + "." + methodName + "(";

                    if (exprCode.contains(invocationToken)) {
                        features.add(Feature.ATOMIC);
                        String refName = "__" + name + "Ref";
                        String replacedLambda = exprCode.replace(invocationToken,
                                refName + ".get()." + methodName + "(");

                        yield "AtomicReference<" + typeName + "> " + refName + " = new AtomicReference<>();\n"
                                + refName + ".set(" + replacedLambda + ");\n"
                                + typeName + " " + name + " = " + refName + ".get();";
                    }
                }

                yield typeName + " " + name + " = " + exprCode + ";";
            }

            // Variables
            case Variable(var name) -> {
                yield name;
            }

            // Lambda
            case Lambda(var params, var body) -> {
                // Create local environment for lambda parameters
                Env localEnv = new Env(env);

                // Get safe parameter names (avoid shadowing)
                List<String> safeParams = safeParamNames(params, env);

                // Define safe parameters in local scope
                for (int i = 0; i < safeParams.size(); i++) {
                    String param = safeParams.get(i);

                    localEnv.define(param, new AtomicNode("any"));
                }

                String paramList = formatLambdaParams(safeParams);

                // Transpile body with renamed variables
                String bodyCode = transpile(body, localEnv);

                yield paramList + " -> " + bodyCode;
            }

            // Function Call
            case FuncCall(var funcNode, var args) -> transpileFuncCall(funcNode, args, env);

            // Num
            case Num(var value) -> {
                if (value == Math.floor(value)) {
                    yield String.valueOf(value.intValue());
                } else {
                    yield String.valueOf(value); // Mantener decimal
                }
            }

            // String
            case StringNode(var value) -> value;

            // Binary Operations
            case BinaryOp(var operator, var left, var right) -> transpileBinaryOp(operator, left, right, env);

            // Unary Operations
            case UnaryOp(var operator, var expr) -> operator + transpile(expr, env);

            // Ternary Expression
            case TernaryExpression(var condition, var trueBranch, var falseBranch) -> {
                String c = transpile(condition, env);
                String t = transpile(trueBranch, env);
                String f = transpile(falseBranch, env);

                // Ask the typer for the condition type to decide codegen
                TypeNode condType = typer.apply(typer.infer(condition, env));
                boolean isBooleanCond = (condType instanceof AtomicNode an)
                        && ("boolean".equals(an.name()) || "Boolean".equals(an.name()));

                String condCode = isBooleanCond ? c : "(" + c + " != 0)";
                yield "(" + condCode + " ? " + t + " : " + f + ")";
            }

            // List
            case ListNode(var elements) -> {
                if (elements.isEmpty())
                    yield "new Object[]{}";

                String elems = elements.stream().map(e -> transpile(e, env)).collect(Collectors.joining(", "));

                yield "new Object[]{" + elems + "}";
            }

            // Data Declaration (sealed interface + records)
            case DataDeclaration(var typeName, var constructors) -> {
                features.add(Feature.DATA_TYPES);
                yield transpileDataDeclaration(typeName, constructors);
            }

            // Instantiator (^Constructor)
            case InstantiatorNode(var constructorName, var args) -> {
                features.add(Feature.DATA_TYPES);
                if (args.isEmpty()) {
                    yield "new " + constructorName + "()";
                }
                String argsCode = args.stream()
                        .map(arg -> transpile(arg, env))
                        .collect(Collectors.joining(", "));
                yield "new " + constructorName + "(" + argsCode + ")";
            }

            // Match Expression (pattern matching)
            case MatchExpression(var expression, var rules) -> {
                features.add(Feature.PATTERN_MATCHING);
                yield transpileMatchExpression(expression, rules, env);
            }

            // Boolean Node
            case BooleanNode(var value) -> String.valueOf(value);

            // None Node
            case NoneNode _ -> "null";

            // Cast Node
            case CastNode(var expr, var targetType) -> {
                String exprCode = transpile(expr, env);
                String javaType = typeNodeToJava(targetType);
                yield "((" + javaType + ")" + exprCode + ")";
            }

            // Fun Node (function declaration)
            case FunNode(var name, var params, var returnType, var body) -> {
                features.add(Feature.FUNCTIONAL);
                Env localEnv = new Env(env);
                List<TypeNode> paramTypes = new ArrayList<>();
                List<String> paramNames = new ArrayList<>();

                for (var arg : params) {
                    TypeNode t = arg.type() != null ? arg.type() : new AtomicNode("any");
                    String pname = arg.name() != null ? arg.name() : ("p" + (paramNames.size() + 1));
                    localEnv.define(pname, t);
                    paramTypes.add(t);
                    paramNames.add(pname);
                }

                TypeNode bindingType = env.find(name);
                if (bindingType != null && typer != null) {
                    bindingType = typer.apply(bindingType);
                }

                FunctionalDescriptor funDescriptor = bindingType instanceof ArrowNode arrow
                        ? describeFunctionalInterface(arrow)
                        : null;

                String javaFuncType;
                if (funDescriptor != null) {
                    javaFuncType = funDescriptor.renderType();
                } else {
                    switch (paramNames.size()) {
                        case 0 -> {
                            String ret = returnType != null ? typeNodeToJava(returnType) : "Object";
                            javaFuncType = "Supplier<" + ret + ">";
                        }
                        case 1 -> {
                            String in = typeNodeToJava(paramTypes.get(0));
                            String ret = returnType != null ? typeNodeToJava(returnType) : "Object";
                            javaFuncType = "Function<" + in + ", " + ret + ">";
                        }
                        case 2 -> {
                            String in1 = typeNodeToJava(paramTypes.get(0));
                            String in2 = typeNodeToJava(paramTypes.get(1));
                            String ret = returnType != null ? typeNodeToJava(returnType) : "Object";
                            javaFuncType = "BiFunction<" + in1 + ", " + in2 + ", " + ret + ">";
                        }
                        default -> {
                            String ret = returnType != null ? typeNodeToJava(returnType) : "Object";
                            javaFuncType = "Function<Object[], " + ret + ">";
                        }
                    }
                }

                String lambdaParams = formatLambdaParams(paramNames);
                String bodyCode = transpile(body, localEnv);

                String invocationMethod = funDescriptor != null ? funDescriptor.invocationMethod() : "apply";
                String invocationToken = name + "." + invocationMethod + "(";

                // Detect recursion: body references the function name followed by '.apply('
                // (for non 0-param functions)
                boolean recursive = bodyCode.contains(invocationToken);

                if (recursive) {
                    // Mark atomic feature for import
                    features.add(Feature.ATOMIC);
                    // Replace self calls with reference getter
                    String refName = "__" + name + "Ref";
                    String replacedBody = bodyCode.replace(invocationToken,
                            refName + ".get()." + invocationMethod + "(");
                    StringBuilder rec = new StringBuilder();
                    rec.append(javaFuncType)
                            .append(" ")
                            .append(name)
                            .append(";\n")
                            .append("AtomicReference<")
                            .append(javaFuncType)
                            .append("> ")
                            .append(refName)
                            .append(" = new AtomicReference<>();\n")
                            .append(refName)
                            .append(".set(")
                            .append(lambdaParams)
                            .append(" -> ")
                            .append(replacedBody)
                            .append(");\n")
                            .append(name)
                            .append(" = ")
                            .append(refName)
                            .append(".get();");
                    yield rec.toString();
                }

                yield javaFuncType + " " + name + " = " + lambdaParams + " -> " + bodyCode + ";";
            }

            // Default case for unknown nodes
            default -> throw new RuntimeException("Unsupported node: " + node);
        };
    }

    // --------------------------------------------------------------
    // Abstracted Methods from Transpile
    // --------------------------------------------------------------
    private String formatLambdaParams(List<String> params) {
        return switch (params.size()) {
            case 0 -> "()";
            case 1 -> "(" + params.get(0) + ")";
            default -> "(" + String.join(", ", params) + ")";
        };
    }

    private String transpileFuncCall(Node funcNode, List<Node> args, Env env) {
        String funcCode = transpile(funcNode, env);
        List<String> argList = args.stream().map(arg -> transpile(arg, env)).collect(Collectors.toList());
        String joinedArgs = String.join(", ", argList);

        if (typer != null) {
            TypeNode funcType = typer.apply(typer.infer(funcNode, env));

            if (funcType instanceof ArrowNode arrow) {
                FunctionalDescriptor descriptor = describeFunctionalInterface(arrow);
                String methodName = descriptor.invocationMethod();

                if (descriptor.parameterCount() == 0) {
                    return funcCode + "." + methodName + "()";
                }

                String argsCode;
                if (descriptor.expectsArrayArgument()) {
                    String contents = joinedArgs.isBlank() ? "" : joinedArgs;
                    argsCode = "new Object[]{" + contents + "}";
                } else {
                    argsCode = joinedArgs;
                }

                String invocation = funcCode + "." + methodName + "(" + argsCode + ")";

                if (descriptor.returnType() != null
                        && !"Object".equals(descriptor.returnType())
                        && ("apply".equals(methodName) || "get".equals(methodName))) {
                    invocation = "((" + descriptor.returnType() + ")(" + invocation + "))";
                }

                return invocation;
            }
        }

        return funcCode + "(" + joinedArgs + ")";
    }

    private String transpileBinaryOp(String operator, Node left, Node right, Env env) {
        String l = transpile(left, env);
        String r = transpile(right, env);

        return switch (operator) {
            case "**" -> {
                features.add(Feature.POW);
                yield "pow(" + l + ", " + r + ")";
            }
            case "!**" -> {
                features.add(Feature.POW);
                yield "pow(" + l + ", (1.0 / " + r + "))";
            }
            default -> l + " " + operator + " " + r;
        };
    }

    // --------------------------------------------------------------
    // This method generates the full Java class code
    // --------------------------------------------------------------
    private String generateJavaClass(List<Node> statements) {
        StringBuilder sb = new StringBuilder();

        // Separate data declarations from other statements
        List<Node> dataDeclarations = new ArrayList<>();
        List<Node> otherStatements = new ArrayList<>();

        for (Node stmt : statements) {
            if (stmt instanceof DataDeclaration) {
                dataDeclarations.add(stmt);
            } else {
                otherStatements.add(stmt);
            }
        }

        // 1) Transpile data declarations first (they go at class level)
        List<String> transpiledDataDecls = dataDeclarations.stream()
                .map(e -> transpile(e, globalEnv))
                .collect(Collectors.toList());

        // 2) Transpile other statements (they go inside main method)
        List<String> transpiledStatements = otherStatements.stream()
                .map(e -> transpile(e, globalEnv))
                .collect(Collectors.toList());

        // 3) Generate imports after features are known
        String imports = HelperLibrary.generateImports(features);

        if (!imports.isEmpty())
            sb.append(imports).append("\n\n");

        // 4) Class header
        sb.append("public class ").append(className).append(" {\n");
        indentLevel++;

        // 5) Add data declarations at class level
        for (String dataDecl : transpiledDataDecls) {
            for (String line : dataDecl.split("\n")) {
                if (!line.isBlank()) {
                    sb.append(indent()).append(line).append("\n");
                }
            }
        }

        if (!transpiledDataDecls.isEmpty()) {
            sb.append("\n");
        }

        // 6) Helper methods: pow, print, etc.
        String helpers = HelperLibrary.generateHelpers(features);

        for (String helper : helpers.split("\n")) {
            if (!helper.isBlank())
                sb.append(indent()).append(helper).append("\n");
        }

        // 7) Main method with body lines
        sb.append(indent()).append("public static void main(String... args) {\n"); // Main method
        indentLevel++;

        // 8) Insert statements
        for (String statement : transpiledStatements) {
            sb.append(indent()).append(statement).append("\n");
        }

        // 9) Insert comments at the end of the main method
        String allComments = getAllComments();

        if (!allComments.isEmpty()) {
            sb.append("\n").append(indent()).append("//---------------------------------------\n").append(indent())
                    .append("// Comments \n").append(indent()).append("//---------------------------------------\n");
            for (String line : allComments.split("\n")) {
                sb.append(indent()).append(line).append("\n");
            }
        }

        indentLevel--;
        sb.append(indent()).append("}\n");

        indentLevel--;
        sb.append("}\n");

        return sb.toString();
    }

    // --------------------------------------------------------------
    // Auxiliary Methods
    // --------------------------------------------------------------
    private String typeNodeToJava(TypeNode typeNode) {
        if (typeNode == null) {
            return "Object";
        }
        if (typer != null) {
            typeNode = typer.apply(typeNode);
        }
        if (typeNode instanceof TupleNode) {
            return "Object[]";
        }
        if (typeNode instanceof AtomicNode atomic) {
            return switch (atomic.name()) {
                case "Int", "int" -> "Integer";
                case "Float", "float" -> "Double";
                case "String", "string" -> "String";
                case "Boolean", "boolean" -> "Boolean";
                case "Any", "any" -> "Object";
                case "Void", "void" -> "Void";
                default -> userTypes.contains(atomic.name()) ? atomic.name() : "Object";
            };
        }
        if (typeNode instanceof TypeVar) {
            return "Object";
        }
        if (typeNode instanceof ArrowNode arrow) {
            return describeFunctionalInterface(arrow).renderType();
        }
        return "Object";
    }

    private String indent() {
        return "\t".repeat(indentLevel);
    }

    // Get all comments from the token stream
    private String getAllComments() {
        StringBuilder comments = new StringBuilder();

        for (Token token : tokens.getTokens()) {
            if (isComment(token)) {
                comments.append(token.getText());
                if (!token.getText().endsWith("\n")) {
                    comments.append("\n");
                }
            }
        }

        return comments.toString().trim();
    }

    // Check if a token is a comment
    private boolean isComment(Token token) {
        return token.getType() == ExprLexer.LINECOMMENT || token.getType() == ExprLexer.BLOCKCOMMENT;
    }

    private List<String> safeParamNames(List<Argument> params, Env env) {
        return params.stream().map(arg -> arg.name() != null ? arg.name() : "_p")
                .reduce(
                        new ArrayList<>(),
                        (acc, baseName) -> {
                            String newName = baseName;
                            int counter = 0;
                            while (env.has(newName) || acc.contains(newName)) {
                                counter++;
                                newName = baseName + counter;
                            }
                            acc.add(newName);
                            return acc;
                        },
                        (acc1, acc2) -> {
                            acc1.addAll(acc2);
                            return acc1;
                        });
    }

    // --------------------------------------------------------------
    // Data Declaration and Pattern Matching Helpers
    // --------------------------------------------------------------

    /**
     * Transpiles a data declaration to Java sealed interface + records
     * Example: data nat = { Zero, S(n:nat) }
     * Generates:
     * sealed interface nat permits Zero, S {}
     * record Zero() implements nat {}
     * record S(nat n) implements nat {}
     */
    private String transpileDataDeclaration(String typeName, List<Constructor> constructors) {
        StringBuilder sb = new StringBuilder();

        userTypes.add(typeName);

        // Generate sealed interface
        String constructorNames = constructors.stream()
                .map(Constructor::name)
                .collect(Collectors.joining(", "));

        sb.append("sealed interface ").append(typeName)
                .append(" permits ").append(constructorNames).append(" {}\n");

        // Generate record for each constructor
        for (Constructor constructor : constructors) {
            sb.append(indent());
            sb.append("record ").append(constructor.name());

            // Generate constructor parameters
            if (constructor.arguments().isEmpty()) {
                sb.append("()");
            } else {
                String params = constructor.arguments().stream()
                        .map(arg -> {
                            String javaType = typeNodeToJava(arg.type());
                            return javaType + " " + (arg.name() != null ? arg.name() : "_");
                        })
                        .collect(Collectors.joining(", "));
                sb.append("(").append(params).append(")");
            }

            sb.append(" implements ").append(typeName).append(" {}\n");

            constructorInfos.put(constructor.name(), new ConstructorInfo(typeName, List.copyOf(constructor.arguments())));
        }

        return sb.toString();
    }

    /**
     * Transpiles a match expression to Java switch with pattern matching
     * Example: match x with Zero -> 0 | S(n) -> n
     * Generates: switch(x) { case Zero z -> 0; case S s -> s.n(); }
     */
    private String transpileMatchExpression(Node expression, List<MatchRule> rules, Env env) {
        StringBuilder sb = new StringBuilder();
        String exprCode = transpile(expression, env);
        TypeNode matchedType = typer.apply(typer.infer(expression, env));

        sb.append("switch(").append(exprCode).append(") {\n");
        indentLevel++;

        for (MatchRule rule : rules) {
            Env ruleEnv = new Env(env);
            registerPatternVariables(rule.pattern(), matchedType, ruleEnv);

            sb.append(indent()).append("case ");
            String patternCode = transpilePattern(rule.pattern());
            sb.append(patternCode);

            if (rule.guard() != null) {
                sb.append(" when ").append(transpile(rule.guard(), ruleEnv));
            }

            String resultCode = transpile(rule.expression(), ruleEnv);
            sb.append(" -> ").append(resultCode).append(";\n");
        }

        sb.append(indent()).append("default -> throw new IllegalArgumentException(\"Unexpected value\");\n");

        indentLevel--;
        sb.append(indent()).append("}");

        return sb.toString();
    }

    /**
     * Transpiles a pattern for use in switch case
     */
    private String transpilePattern(Pattern pattern) {
        return switch (pattern) {
            case DataPattern(var constructorName, var params) -> {
                if (!constructorInfos.containsKey(constructorName)) {
                    yield renderVariableName(constructorName);
                }
                if (params.isEmpty()) {
                    yield constructorName + "()";
                }
                yield constructorName + "(" + params.stream().map(this::renderPatternComponent)
                        .collect(Collectors.joining(", ")) + ")";
            }
            case NativePattern(var type, var value) -> {
                yield switch (type) {
                    case NONE -> "null";
                    case BOOLEAN -> String.valueOf(value);
                    case STRING -> value.toString();
                    case NUMERIC -> String.valueOf(value);
                    case VARIABLE -> renderVariableName(value.toString());
                };
            }
            default -> throw new RuntimeException("Unknown pattern type: " + pattern);
        };
    }

    private String renderPatternComponent(DataPattern pattern) {
        if (constructorInfos.containsKey(pattern.constructorName())) {
            return transpilePattern(pattern);
        }
        return renderVariableName(pattern.constructorName());
    }

    private String renderVariableName(String original) {
        if ("_".equals(original)) {
            return "var " + freshPatternName();
        }
        return "var " + original;
    }

    private String freshPatternName() {
        return "__ignored" + (patternVarCounter++);
    }

    private void registerPatternVariables(Pattern pattern, TypeNode matchedType, Env env) {
        if (pattern instanceof DataPattern dp) {
            registerDataPatternVariables(dp, matchedType, env);
        } else if (pattern instanceof NativePattern np) {
            registerNativePatternVariables(np, matchedType, env);
        }
    }

    private void registerDataPatternVariables(DataPattern pattern, TypeNode matchedType, Env env) {
        ConstructorInfo info = constructorInfos.get(pattern.constructorName());
        if (info == null) {
            if (!"_".equals(pattern.constructorName())) {
                env.define(pattern.constructorName(), matchedType != null ? matchedType : new AtomicNode("any"));
            }
            return;
        }

        List<Argument> args = info.arguments();
        if (pattern.params().size() != args.size()) {
            throw new RuntimeException("Pattern arity mismatch for constructor '" + pattern.constructorName() + "'");
        }

        for (int i = 0; i < args.size(); i++) {
            Argument arg = args.get(i);
            TypeNode nextType = arg.type() != null ? arg.type() : new AtomicNode("any");
            registerPatternVariables(pattern.params().get(i), nextType, env);
        }
    }

    private void registerNativePatternVariables(NativePattern pattern, TypeNode matchedType, Env env) {
        if (pattern.type() == NativePattern.PatternType.VARIABLE) {
            String name = pattern.value().toString();
            if (!"_".equals(name)) {
                env.define(name, matchedType != null ? matchedType : new AtomicNode("any"));
            }
        }
    }

    private FunctionalDescriptor describeFunctionalInterface(ArrowNode arrow) {
        TypeNode normalizedInput = typer != null ? typer.apply(arrow.inputType()) : arrow.inputType();
        TypeNode normalizedReturn = typer != null ? typer.apply(arrow.returnType()) : arrow.returnType();

        List<TypeNode> params = extractParamTypes(normalizedInput);
        List<String> paramJava = params.stream().map(this::typeNodeToJava).collect(Collectors.toList());
        String returnJava = typeNodeToJava(normalizedReturn);

        if (params.isEmpty()) {
            if (isVoidType(normalizedReturn)) {
                return new FunctionalDescriptor("Runnable", List.of(), "run", 0, false, null);
            }
            return new FunctionalDescriptor("Supplier", List.of(returnJava), "get", 0, false, returnJava);
        }

        if (params.size() == 1) {
            String in = paramJava.get(0);
            if (isVoidType(normalizedReturn)) {
                return new FunctionalDescriptor("Consumer", List.of(in), "accept", 1, false, null);
            }
            if (isBooleanType(normalizedReturn)) {
                return new FunctionalDescriptor("Predicate", List.of(in), "test", 1, false, null);
            }
            if (areSameTypes(params.get(0), normalizedReturn)) {
                return new FunctionalDescriptor("UnaryOperator", List.of(in), "apply", 1, false, in);
            }
            return new FunctionalDescriptor("Function", List.of(in, returnJava), "apply", 1, false, returnJava);
        }

        if (params.size() == 2) {
            String in1 = paramJava.get(0);
            String in2 = paramJava.get(1);
            if (isVoidType(normalizedReturn)) {
                return new FunctionalDescriptor("BiConsumer", List.of(in1, in2), "accept", 2, false, null);
            }
            if (isBooleanType(normalizedReturn)) {
                return new FunctionalDescriptor("BiPredicate", List.of(in1, in2), "test", 2, false, null);
            }
            if (areSameTypes(params.get(0), params.get(1)) && areSameTypes(params.get(0), normalizedReturn)) {
                return new FunctionalDescriptor("BinaryOperator", List.of(in1), "apply", 2, false, in1);
            }
            return new FunctionalDescriptor("BiFunction", List.of(in1, in2, returnJava), "apply", 2, false, returnJava);
        }

        return new FunctionalDescriptor("Function", List.of("Object[]", returnJava), "apply", params.size(), true,
                returnJava);
    }

    private List<TypeNode> extractParamTypes(TypeNode inputType) {
        TypeNode applied = typer != null ? typer.apply(inputType) : inputType;
        if (applied instanceof TupleNode tuple) {
            return tuple.elements();
        }
        if (applied instanceof AtomicNode atomic && "void".equalsIgnoreCase(atomic.name())) {
            return List.of();
        }
        return List.of(applied);
    }

    private boolean isVoidType(TypeNode type) {
        if (type == null) {
            return false;
        }
        TypeNode applied = typer != null ? typer.apply(type) : type;
        return applied instanceof AtomicNode atomic && "void".equalsIgnoreCase(atomic.name());
    }

    private boolean isBooleanType(TypeNode type) {
        if (type == null) {
            return false;
        }
        TypeNode applied = typer != null ? typer.apply(type) : type;
        return applied instanceof AtomicNode atomic && "boolean".equalsIgnoreCase(atomic.name());
    }

    private boolean areSameTypes(TypeNode left, TypeNode right) {
        if (left == null || right == null) {
            return false;
        }
        TypeNode normalizedLeft = typer != null ? typer.apply(left) : left;
        TypeNode normalizedRight = typer != null ? typer.apply(right) : right;
        return normalizedLeft.equals(normalizedRight);
    }

    private record FunctionalDescriptor(String interfaceName, List<String> typeArguments,
            String invocationMethod, int parameterCount, boolean expectsArrayArgument, String returnType) {
        String renderType() {
            if (typeArguments == null || typeArguments.isEmpty()) {
                return interfaceName;
            }
            return interfaceName + "<" + String.join(", ", typeArguments) + ">";
        }
    }

    private record ConstructorInfo(String typeName, List<Argument> arguments) {
    }
}
