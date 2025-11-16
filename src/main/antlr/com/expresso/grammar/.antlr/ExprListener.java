// Generated from c:/Dev/Paradigmas/Expresso/src/main/antlr/com/expresso/grammar/Expr.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ExprParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ExprParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LetStatement}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterLetStatement(ExprParser.LetStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LetStatement}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitLetStatement(ExprParser.LetStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Fun}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterFun(ExprParser.FunContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Fun}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitFun(ExprParser.FunContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DataDeclaration}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDataDeclaration(ExprParser.DataDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DataDeclaration}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDataDeclaration(ExprParser.DataDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintStatement}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(ExprParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintStatement}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(ExprParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintExpr}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(ExprParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintExpr}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(ExprParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Blank}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlank(ExprParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Blank}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlank(ExprParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#data}.
	 * @param ctx the parse tree
	 */
	void enterData(ExprParser.DataContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#data}.
	 * @param ctx the parse tree
	 */
	void exitData(ExprParser.DataContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#constructors}.
	 * @param ctx the parse tree
	 */
	void enterConstructors(ExprParser.ConstructorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#constructors}.
	 * @param ctx the parse tree
	 */
	void exitConstructors(ExprParser.ConstructorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(ExprParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(ExprParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(ExprParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(ExprParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(ExprParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(ExprParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#elements}.
	 * @param ctx the parse tree
	 */
	void enterElements(ExprParser.ElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#elements}.
	 * @param ctx the parse tree
	 */
	void exitElements(ExprParser.ElementsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Cast}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCast(ExprParser.CastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Cast}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCast(ExprParser.CastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(ExprParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(ExprParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(ExprParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(ExprParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(ExprParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(ExprParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Ternary}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTernary(ExprParser.TernaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Ternary}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTernary(ExprParser.TernaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(ExprParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(ExprParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Num}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNum(ExprParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Num}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNum(ExprParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PowSqrt}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPowSqrt(ExprParser.PowSqrtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PowSqrt}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPowSqrt(ExprParser.PowSqrtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelational(ExprParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelational(ExprParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryMinus}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinus(ExprParser.UnaryMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryMinus}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinus(ExprParser.UnaryMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Instantiator}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInstantiator(ExprParser.InstantiatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Instantiator}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInstantiator(ExprParser.InstantiatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(ExprParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(ExprParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOr}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOr(ExprParser.LogicalOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOr}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOr(ExprParser.LogicalOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Match}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMatch(ExprParser.MatchContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Match}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMatch(ExprParser.MatchContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalNot}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalNot(ExprParser.LogicalNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalNot}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalNot(ExprParser.LogicalNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncCall}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(ExprParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncCall}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(ExprParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LambdaParams}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParams(ExprParser.LambdaParamsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LambdaParams}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParams(ExprParser.LambdaParamsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBool(ExprParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBool(ExprParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Lists}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLists(ExprParser.ListsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lists}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLists(ExprParser.ListsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalAnd}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAnd(ExprParser.LogicalAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalAnd}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAnd(ExprParser.LogicalAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Lambda}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLambda(ExprParser.LambdaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lambda}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLambda(ExprParser.LambdaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code None}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNone(ExprParser.NoneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code None}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNone(ExprParser.NoneContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#match_rule}.
	 * @param ctx the parse tree
	 */
	void enterMatch_rule(ExprParser.Match_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#match_rule}.
	 * @param ctx the parse tree
	 */
	void exitMatch_rule(ExprParser.Match_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuard(ExprParser.GuardContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuard(ExprParser.GuardContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(ExprParser.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(ExprParser.PatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#data_pattern}.
	 * @param ctx the parse tree
	 */
	void enterData_pattern(ExprParser.Data_patternContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#data_pattern}.
	 * @param ctx the parse tree
	 */
	void exitData_pattern(ExprParser.Data_patternContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#pattern_params}.
	 * @param ctx the parse tree
	 */
	void enterPattern_params(ExprParser.Pattern_paramsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#pattern_params}.
	 * @param ctx the parse tree
	 */
	void exitPattern_params(ExprParser.Pattern_paramsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NoneConstant}
	 * labeled alternative in {@link ExprParser#native_pattern}.
	 * @param ctx the parse tree
	 */
	void enterNoneConstant(ExprParser.NoneConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NoneConstant}
	 * labeled alternative in {@link ExprParser#native_pattern}.
	 * @param ctx the parse tree
	 */
	void exitNoneConstant(ExprParser.NoneConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolConstant}
	 * labeled alternative in {@link ExprParser#native_pattern}.
	 * @param ctx the parse tree
	 */
	void enterBoolConstant(ExprParser.BoolConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolConstant}
	 * labeled alternative in {@link ExprParser#native_pattern}.
	 * @param ctx the parse tree
	 */
	void exitBoolConstant(ExprParser.BoolConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringConstant}
	 * labeled alternative in {@link ExprParser#native_pattern}.
	 * @param ctx the parse tree
	 */
	void enterStringConstant(ExprParser.StringConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringConstant}
	 * labeled alternative in {@link ExprParser#native_pattern}.
	 * @param ctx the parse tree
	 */
	void exitStringConstant(ExprParser.StringConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumericConstant}
	 * labeled alternative in {@link ExprParser#native_pattern}.
	 * @param ctx the parse tree
	 */
	void enterNumericConstant(ExprParser.NumericConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumericConstant}
	 * labeled alternative in {@link ExprParser#native_pattern}.
	 * @param ctx the parse tree
	 */
	void exitNumericConstant(ExprParser.NumericConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariablePattern}
	 * labeled alternative in {@link ExprParser#native_pattern}.
	 * @param ctx the parse tree
	 */
	void enterVariablePattern(ExprParser.VariablePatternContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariablePattern}
	 * labeled alternative in {@link ExprParser#native_pattern}.
	 * @param ctx the parse tree
	 */
	void exitVariablePattern(ExprParser.VariablePatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(ExprParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(ExprParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#constructor_call}.
	 * @param ctx the parse tree
	 */
	void enterConstructor_call(ExprParser.Constructor_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#constructor_call}.
	 * @param ctx the parse tree
	 */
	void exitConstructor_call(ExprParser.Constructor_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#atomic}.
	 * @param ctx the parse tree
	 */
	void enterAtomic(ExprParser.AtomicContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#atomic}.
	 * @param ctx the parse tree
	 */
	void exitAtomic(ExprParser.AtomicContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#tuple}.
	 * @param ctx the parse tree
	 */
	void enterTuple(ExprParser.TupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#tuple}.
	 * @param ctx the parse tree
	 */
	void exitTuple(ExprParser.TupleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomArrowType}
	 * labeled alternative in {@link ExprParser#type}.
	 * @param ctx the parse tree
	 */
	void enterAtomArrowType(ExprParser.AtomArrowTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomArrowType}
	 * labeled alternative in {@link ExprParser#type}.
	 * @param ctx the parse tree
	 */
	void exitAtomArrowType(ExprParser.AtomArrowTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TupleArrowType}
	 * labeled alternative in {@link ExprParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTupleArrowType(ExprParser.TupleArrowTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TupleArrowType}
	 * labeled alternative in {@link ExprParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTupleArrowType(ExprParser.TupleArrowTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenArrowType}
	 * labeled alternative in {@link ExprParser#type}.
	 * @param ctx the parse tree
	 */
	void enterParenArrowType(ExprParser.ParenArrowTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenArrowType}
	 * labeled alternative in {@link ExprParser#type}.
	 * @param ctx the parse tree
	 */
	void exitParenArrowType(ExprParser.ParenArrowTypeContext ctx);
}