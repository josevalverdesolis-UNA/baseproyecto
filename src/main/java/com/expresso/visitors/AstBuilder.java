// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.visitors;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.tree.ParseTree;

import com.expresso.ast.Argument;
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
import com.expresso.ast.TypeNode;
import com.expresso.ast.UnaryOp;
import com.expresso.ast.Variable;
import com.expresso.grammar.ExprBaseVisitor;
import com.expresso.grammar.ExprParser;

/**
 * AstBuilder is responsible for converting ANTLR ParseTree to custom AST nodes.
 * This class only handles the tree transformation, not file I/O or complete
 * parsing operations.
 * What it does: Visits parse tree nodes and constructs corresponding AST nodes.
 * How it works: Extends ExprBaseVisitor and overrides visit methods for
 * relevant grammar rules.
 * Each visit method processes its context and returns an AST Node.
 */
public class AstBuilder extends ExprBaseVisitor<Node> {
    private final TypeAstBuilder typeBuilder = new TypeAstBuilder();

    @Override
    public Program visitProg(ExprParser.ProgContext ctx) {
        List<Node> statements = ctx.stat().stream()
                .map(this::visit)
                .filter(stmt -> stmt != null)
                .collect(Collectors.toList());

        return new Program(statements);
    }

    @Override
    public Node visitPrintExpr(ExprParser.PrintExprContext ctx) {
        return visit(ctx.expr());
    }

    // To discuss: Should we return a special Pass node instead of null?
    // For now, we return null for blank statements.
    @Override
    public Node visitBlank(ExprParser.BlankContext ctx) {
        return null; // Simplified: null instead of PASS
    }

    @Override
    public Num visitNum(ExprParser.NumContext ctx) {
        String text = ctx.getText();
        double value = Double.parseDouble(text);
        return new Num(value);
    }

    @Override
    public StringNode visitString(ExprParser.StringContext ctx) {
        String text = ctx.getText();
        return new StringNode(text);
    }

    @Override
    public BooleanNode visitBool(ExprParser.BoolContext ctx) {
        return new BooleanNode(Boolean.parseBoolean(ctx.getText()));
    }

    @Override
    public NoneNode visitNone(ExprParser.NoneContext ctx) {
        return new NoneNode();
    }

    @Override
    public BinaryOp visitMulDiv(ExprParser.MulDivContext ctx) {
        Node left = visit(ctx.expr(0));
        Node right = visit(ctx.expr(1));
        String operator = ctx.op.getText();

        return new BinaryOp(operator, left, right);
    }

    @Override
    public BinaryOp visitPowSqrt(ExprParser.PowSqrtContext ctx) {
        Node left = visit(ctx.expr(0));
        Node right = visit(ctx.expr(1));
        String operator = ctx.op.getText();

        return new BinaryOp(operator, left, right);
    }

    @Override
    public BinaryOp visitAddSub(ExprParser.AddSubContext ctx) {
        Node left = visit(ctx.expr(0));
        Node right = visit(ctx.expr(1));
        String operator = ctx.op.getText();

        return new BinaryOp(operator, left, right);
    }

    @Override
    public BinaryOp visitRelational(ExprParser.RelationalContext ctx) {
        Node left = visit(ctx.expr(0));
        Node right = visit(ctx.expr(1));
        String operator = ctx.op.getText();

        return new BinaryOp(operator, left, right);
    }

    @Override
    public BinaryOp visitLogicalAnd(ExprParser.LogicalAndContext ctx) {
        Node left = visit(ctx.expr(0));
        Node right = visit(ctx.expr(1));

        return new BinaryOp("&&", left, right);
    }

    @Override
    public BinaryOp visitLogicalOr(ExprParser.LogicalOrContext ctx) {
        Node left = visit(ctx.expr(0));
        Node right = visit(ctx.expr(1));

        return new BinaryOp("||", left, right);
    }

    @Override
    public UnaryOp visitLogicalNot(ExprParser.LogicalNotContext ctx) {
        Node expression = visit(ctx.expr());
        return new UnaryOp("!", expression);
    }

    @Override
    public CastNode visitCast(ExprParser.CastContext ctx) {
        Node expression = visit(ctx.expr());
        TypeNode targetType = typeBuilder.visit(ctx.type());

        return new CastNode(expression, targetType);
    }

    @Override
    public TernaryExpression visitTernary(ExprParser.TernaryContext ctx) {
        // Maps parser alternative '?:' (#Ternary) to AST node TernaryExpression.
        // No Java emission or booleanization (cond != 0) here; handled by the
        // transpiler/evaluator.
        Node condition = visit(ctx.expr(0));
        Node trueBranch = visit(ctx.expr(1));
        Node falseBranch = visit(ctx.expr(2));
        return new TernaryExpression(condition, trueBranch, falseBranch);
    }

    @Override
    public UnaryOp visitUnaryMinus(ExprParser.UnaryMinusContext ctx) {
        Node expression = visit(ctx.expr());
        return new UnaryOp("-", expression);
    }

    @Override
    public Node visitParens(ExprParser.ParensContext ctx) {
        return visit(ctx.expr()); // Parentheses disappear in AST
    }

    @Override
    public Node visitPureExpr(ExprParser.PureExprContext ctx) {
        if (ctx == null) {
            return null;
        }

        List<ExprParser.ExprContext> exprChildren = ctx.expr() == null ? List.of() : ctx.expr();

        if (ctx.ARROW() != null && !exprChildren.isEmpty()) {
            if (ctx.arguments() != null || ctx.getChildCount() > 0 && "(".equals(ctx.getChild(0).getText())) {
                List<String> params = extractParameterNames(ctx.arguments());
                Node body = visit(exprChildren.get(0));
                return new Lambda(params, body);
            }
            if (ctx.ID() != null) {
                Node body = visit(exprChildren.get(0));
                return new Lambda(List.of(ctx.ID().getText()), body);
            }
        }

        if (isUnaryPrefix(ctx, "-")) {
            return new UnaryOp("-", visit(ctx.pureExpr(0)));
        }
        if (isUnaryPrefix(ctx, "!")) {
            return new UnaryOp("!", visit(ctx.pureExpr(0)));
        }

        if (ctx.constructor_call() != null && startsWithToken(ctx, "^")) {
            return buildInstantiatorNode(ctx.constructor_call());
        }

        if (ctx.MATCH() != null || ctx.match_rule() != null && !ctx.match_rule().isEmpty()) {
            Node expression = visit(ctx.pureExpr(0));
            List<MatchRule> rules = ctx.match_rule().stream()
                    .map(this::buildMatchRule)
                    .collect(Collectors.toList());

            return new MatchExpression(expression, rules);
        }

        if (ctx.QUESTION() != null) {
            return new TernaryExpression(
                    visit(ctx.pureExpr(0)),
                    visit(ctx.pureExpr(1)),
                    visit(ctx.pureExpr(2)));
        }

        if (isFunctionCall(ctx)) {
            Node funcExpr = visit(ctx.pureExpr(0));
            List<Node> args = exprChildren.stream().map(this::visit).collect(Collectors.toList());
            return new FuncCall(funcExpr, args);
        }

        if (ctx.op != null) {
            Node left = visit(ctx.pureExpr(0));
            Node right = visit(ctx.pureExpr(1));
            return new BinaryOp(ctx.op.getText(), left, right);
        }

        if (isParenthesizedPureExpr(ctx)) {
            return visit(ctx.pureExpr(0));
        }

        if (ctx.LBRACK() != null) {
            if (ctx.elements() != null) {
                return new ListNode(processElements(ctx.elements()));
            }
            return new ListNode(Collections.emptyList());
        }

        if (ctx.INT() != null) {
            return new Num(Double.parseDouble(ctx.INT().getText()));
        }
        if (ctx.FLOAT() != null) {
            return new Num(Double.parseDouble(ctx.FLOAT().getText()));
        }
        if (ctx.BOOLEAN() != null) {
            return new BooleanNode(Boolean.parseBoolean(ctx.BOOLEAN().getText()));
        }
        if (ctx.STRING() != null) {
            return new StringNode(ctx.STRING().getText());
        }
        if (ctx.NONE() != null) {
            return new NoneNode();
        }
        if (ctx.ID() != null) {
            return new Variable(ctx.ID().getText());
        }

        throw new IllegalStateException("Unsupported pure expression: " + ctx.getText());
    }

    @Override
    public ListNode visitLists(ExprParser.ListsContext ctx) {
        if (ctx.elements() != null) {
            List<Node> elements = processElements(ctx.elements());
            return new ListNode(elements);
        } else {
            return new ListNode(Collections.emptyList());
        }
    }

    @Override
    public LetStatement visitLetStatement(ExprParser.LetStatementContext ctx) {
        String varName = ctx.ID().getText();
        Node expression = visit(ctx.expr());
        TypeNode declaredType = null;
        if (ctx.getTokens(com.expresso.grammar.ExprParser.COLON).size() > 0) {
            var tctx = ctx.getRuleContext(com.expresso.grammar.ExprParser.TypeContext.class, 0);
            if (tctx != null) {
                declaredType = typeBuilder.visit(tctx);
            }
        }

        return new LetStatement(varName, declaredType, expression);
    }

    @Override
    public PrintStatement visitPrintStatement(ExprParser.PrintStatementContext ctx) {
        Node expression = visit(ctx.expr());

        return new PrintStatement(expression);
    }

    // -----------------------------------------------------------------------------------
    // Lambda Expressions
    // -----------------------------------------------------------------------------------
    @Override
    public Lambda visitLambdaParams(ExprParser.LambdaParamsContext ctx) {
        List<String> paramNames = extractParameterNames(ctx.arguments());
        Node body = visit(ctx.expr());

        return new Lambda(paramNames, body);
    }

    @Override
    public Lambda visitLambda(ExprParser.LambdaContext ctx) {
        String paramName = ctx.ID().getText();
        if (ctx.type() != null) {
            // Typed single-parameter lambdas are parsed, but the explicit type annotation
            // is currently ignored by the AST layer (typing happens later in the pipeline).
        }
        Node body = visit(ctx.expr());

        return new Lambda(List.of(paramName), body);
    }
    
    // -----------------------------------------------------------------------------------

    @Override
    public FuncCall visitFuncCall(ExprParser.FuncCallContext ctx) {
        Node funcExpr = visit(ctx.expr(0));

        List<Node> args = ctx.expr().size() > 1
                ? ctx.expr().subList(1, ctx.expr().size()).stream()
                        .map(this::visit)
                        .collect(Collectors.toList())
                : List.of();

        return new FuncCall(funcExpr, args);
    }

    @Override
    public Variable visitVariable(ExprParser.VariableContext ctx) {
        String name = ctx.ID().getText();

        return new Variable(name);
    }

    @Override
    public Node visitInstantiator(ExprParser.InstantiatorContext ctx) {
        return buildInstantiatorNode(ctx.constructor_call());
    }

    @Override
    public Node visitFun(ExprParser.FunContext ctx) {
        String functionName = ctx.ID().getText();
        List<Argument> params = Collections.emptyList();
        if (ctx.arguments() != null) {
            params = ctx.arguments().param().stream().map(this::buildArgument).collect(Collectors.toList());
        }
        TypeNode returnType = typeBuilder.visit(ctx.type());
        Node body = visit(ctx.expr());

        return new FunNode(functionName, params, returnType, body);
    }

    // -----------------------------------------------------------------------------------
    // Data Declarations
    // -----------------------------------------------------------------------------------
    @Override
    public DataDeclaration visitDataDeclaration(ExprParser.DataDeclarationContext ctx) {
        String typeName = ctx.data().ID().getText();
        List<Constructor> constructors = ctx.data().constructors().constructor().stream()
                .map(this::buildConstructor)
                .collect(Collectors.toList());

        return new DataDeclaration(typeName, constructors);
    }

    // -----------------------------------------------------------------------------------
    // Match Expressions
    // -----------------------------------------------------------------------------------
    @Override
    public MatchExpression visitMatch(ExprParser.MatchContext ctx) {
        Node expression = visit(ctx.expr());
        List<MatchRule> rules = ctx.match_rule().stream()
                .map(this::buildMatchRule)
                .collect(Collectors.toList());

        return new MatchExpression(expression, rules);
    }

    // ---------------------------
    // Private Helper Methods
    // ---------------------------
    private List<Node> processElements(ExprParser.ElementsContext ctx) {
        return ctx.expr().stream()
                .map(this::visit)
                .collect(Collectors.toList());
    }

    private InstantiatorNode buildInstantiatorNode(ExprParser.Constructor_callContext callCtx) {
        String name = callCtx.ID().getText();
        List<Node> args = (callCtx.params() != null && callCtx.params().expr() != null)
                ? callCtx.params().expr().stream().map(this::visit).collect(Collectors.toList())
                : List.of();

        return new InstantiatorNode(name, args);
    }

    // Extract parameter names from ArgumentsContext
    private List<String> extractParameterNames(ExprParser.ArgumentsContext ctx) {
        if (ctx == null) {
            return Collections.emptyList();
        }

        return ctx.param().stream()
                .map(this::extractParameterName)
                .filter(name -> name != null)
                .collect(Collectors.toList());
    }

    // Extract single parameter name from ParamContext
    private String extractParameterName(ExprParser.ParamContext argCtx) {
        return argCtx.ID() != null ? argCtx.ID().getText() : null;
    }

    // -----------------------------------------------------------------------------------
    // Helper Methods for Data Declarations and Match Expressions
    // -----------------------------------------------------------------------------------
    
    /**
     * Builds a Constructor node from ANTLR context
     */
    private Constructor buildConstructor(ExprParser.ConstructorContext ctx) {
        String name = ctx.ID().getText();
        List<Argument> arguments = Collections.emptyList();

        if (ctx.arguments() != null) {
            arguments = ctx.arguments().param().stream()
                    .map(this::buildArgument)
                    .collect(Collectors.toList());
        }

        return new Constructor(name, arguments);
    }

    /**
     * Builds an Argument node from ANTLR context
     */
    private Argument buildArgument(ExprParser.ParamContext ctx) {
        String name = ctx.ID() != null ? ctx.ID().getText() : null;
        TypeNode type = ctx.type() != null ? typeBuilder.visit(ctx.type()) : null;

        return new Argument(name, type);
    }

    /**
     * Builds a MatchRule node from ANTLR context
     */
    private MatchRule buildMatchRule(ExprParser.Match_ruleContext ctx) {
        Pattern pattern = buildPattern(ctx.pattern());
        Node guard = ctx.guard() != null ? visit(ctx.guard().expr()) : null;
        Node expression = visit(ctx.expr());

        return new MatchRule(pattern, guard, expression);
    }

    /**
     * Builds a Pattern node (DataPattern or NativePattern) from ANTLR context
     */
    private Pattern buildPattern(ExprParser.PatternContext ctx) {
        if (ctx.data_pattern() != null) {
            return buildDataPattern(ctx.data_pattern());
        } else if (ctx.native_pattern() != null) {
            return buildNativePattern(ctx.native_pattern());
        }
        throw new RuntimeException("Unknown pattern type");
    }

    /**
     * Builds a DataPattern node from ANTLR context
     */
    private DataPattern buildDataPattern(ExprParser.Data_patternContext ctx) {
        String constructorName = ctx.ID().getText();
        List<DataPattern> params = Collections.emptyList();

        if (ctx.pattern_params() != null) {
            params = ctx.pattern_params().data_pattern().stream()
                    .map(this::buildDataPattern)
                    .collect(Collectors.toList());
        }

        return new DataPattern(constructorName, params);
    }

    /**
     * Builds a NativePattern node from ANTLR context
     * Uses visitor pattern for each native pattern type
     */
    private NativePattern buildNativePattern(ExprParser.Native_patternContext ctx) {
        // Dispatch to specific visitor method based on pattern type
        if (ctx instanceof ExprParser.NoneConstantContext) {
            return new NativePattern(NativePattern.PatternType.NONE, null);
        } else if (ctx instanceof ExprParser.BoolConstantContext boolCtx) {
            boolean value = Boolean.parseBoolean(boolCtx.BOOLEAN().getText());
            return new NativePattern(NativePattern.PatternType.BOOLEAN, value);
        } else if (ctx instanceof ExprParser.StringConstantContext strCtx) {
            String value = strCtx.STRING().getText();
            return new NativePattern(NativePattern.PatternType.STRING, value);
        } else if (ctx instanceof ExprParser.NumericConstantContext numCtx) {
            String text = numCtx.getText();
            // Check if it's INT or FLOAT based on the text
            if (numCtx.INT() != null) {
                int value = Integer.parseInt(text);
                return new NativePattern(NativePattern.PatternType.NUMERIC, value);
            } else {
                double value = Double.parseDouble(text);
                return new NativePattern(NativePattern.PatternType.NUMERIC, value);
            }
        } else if (ctx instanceof ExprParser.VariablePatternContext varCtx) {
            String varName = varCtx.ID().getText();
            return new NativePattern(NativePattern.PatternType.VARIABLE, varName);
        }
        throw new RuntimeException("Unknown native pattern type");
    }

    private boolean startsWithToken(ExprParser.PureExprContext ctx, String symbol) {
        return ctx.getChildCount() > 0 && symbol.equals(ctx.getChild(0).getText());
    }

    private boolean isUnaryPrefix(ExprParser.PureExprContext ctx, String symbol) {
        return ctx.pureExpr() != null
                && ctx.pureExpr().size() == 1
                && startsWithToken(ctx, symbol);
    }

    private boolean isParenthesizedPureExpr(ExprParser.PureExprContext ctx) {
        return ctx.pureExpr() != null
                && ctx.pureExpr().size() == 1
                && startsWithToken(ctx, "(")
                && ctx.getChild(ctx.getChildCount() - 1).getText().equals(")");
    }

    private boolean isFunctionCall(ExprParser.PureExprContext ctx) {
        if (ctx.pureExpr() == null || ctx.pureExpr().isEmpty()) {
            return false;
        }

        if (ctx.getChildCount() < 3) {
            return false;
        }

        ParseTree secondChild = ctx.getChild(1);
        ParseTree lastChild = ctx.getChild(ctx.getChildCount() - 1);

        return "(".equals(secondChild.getText()) && ")".equals(lastChild.getText());
    }
}
