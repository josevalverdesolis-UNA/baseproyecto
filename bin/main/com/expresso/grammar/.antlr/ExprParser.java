// Generated from c:/Dev/Paradigmas/Expresso/bin/main/com/expresso/grammar/Expr.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, ID=13, NEWLINE=14, LINECOMMENT=15, BLOCKCOMMENT=16, 
		INT=17, WS=18, FLOAT=19, LBRACK=20, RBRACK=21, COMMA=22, QUESTION=23, 
		COLON=24;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_elements = 2, RULE_comment = 3, RULE_expr = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "elements", "comment", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'let'", "'='", "'print'", "'('", "')'", "'**'", "'!**'", "'-'", 
			"'*'", "'/'", "'+'", "'->'", null, null, null, null, null, null, null, 
			"'['", "']'", "','", "'?'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ID", "NEWLINE", "LINECOMMENT", "BLOCKCOMMENT", "INT", "WS", "FLOAT", 
			"LBRACK", "RBRACK", "COMMA", "QUESTION", "COLON"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ExprParser.EOF, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1827098L) != 0)) {
				{
				{
				setState(10);
				stat();
				}
				}
				setState(15);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(16);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlankContext extends StatContext {
		public TerminalNode NEWLINE() { return getToken(ExprParser.NEWLINE, 0); }
		public BlankContext(StatContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CommentStatementContext extends StatContext {
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ExprParser.NEWLINE, 0); }
		public CommentStatementContext(StatContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintStatementContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ExprParser.NEWLINE, 0); }
		public PrintStatementContext(StatContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetStatementContext extends StatContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ExprParser.NEWLINE, 0); }
		public LetStatementContext(StatContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintExprContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ExprParser.NEWLINE, 0); }
		public PrintExprContext(StatContext ctx) { copyFrom(ctx); }
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new LetStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				match(T__0);
				setState(19);
				match(ID);
				setState(20);
				match(T__1);
				setState(21);
				expr(0);
				setState(22);
				match(NEWLINE);
				}
				break;
			case T__2:
				_localctx = new PrintStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(24);
				match(T__2);
				setState(25);
				match(T__3);
				setState(26);
				expr(0);
				setState(27);
				match(T__4);
				setState(28);
				match(NEWLINE);
				}
				break;
			case T__3:
			case T__7:
			case ID:
			case INT:
			case FLOAT:
			case LBRACK:
				_localctx = new PrintExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				expr(0);
				setState(31);
				match(NEWLINE);
				}
				break;
			case LINECOMMENT:
			case BLOCKCOMMENT:
				_localctx = new CommentStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(33);
				comment();
				setState(34);
				match(NEWLINE);
				}
				break;
			case NEWLINE:
				_localctx = new BlankContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(36);
				match(NEWLINE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElementsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExprParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprParser.COMMA, i);
		}
		public ElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elements; }
	}

	public final ElementsContext elements() throws RecognitionException {
		ElementsContext _localctx = new ElementsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			expr(0);
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(40);
				match(COMMA);
				setState(41);
				expr(0);
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommentContext extends ParserRuleContext {
		public TerminalNode LINECOMMENT() { return getToken(ExprParser.LINECOMMENT, 0); }
		public TerminalNode BLOCKCOMMENT() { return getToken(ExprParser.BLOCKCOMMENT, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_comment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_la = _input.LA(1);
			if ( !(_la==LINECOMMENT || _la==BLOCKCOMMENT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Lambda1ParamContext extends ExprContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Lambda1ParamContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ExprContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public VariableContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulDivContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TernaryContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode QUESTION() { return getToken(ExprParser.QUESTION, 0); }
		public TerminalNode COLON() { return getToken(ExprParser.COLON, 0); }
		public TernaryContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PowSqrtContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PowSqrtContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryMinusContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryMinusContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatContext extends ExprContext {
		public TerminalNode FLOAT() { return getToken(ExprParser.FLOAT, 0); }
		public FloatContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCallContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExprParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprParser.COMMA, i);
		}
		public FuncCallContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Lambda0ParamsContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Lambda0ParamsContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListsContext extends ExprContext {
		public TerminalNode LBRACK() { return getToken(ExprParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(ExprParser.RBRACK, 0); }
		public ElementsContext elements() {
			return getRuleContext(ElementsContext.class,0);
		}
		public ListsContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Lambda2ParamsContext extends ExprContext {
		public List<TerminalNode> ID() { return getTokens(ExprParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ExprParser.ID, i);
		}
		public TerminalNode COMMA() { return getToken(ExprParser.COMMA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Lambda2ParamsContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryMinusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(50);
				match(T__7);
				setState(51);
				expr(13);
				}
				break;
			case 2:
				{
				_localctx = new Lambda0ParamsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
				match(T__3);
				setState(53);
				match(T__4);
				setState(54);
				match(T__11);
				setState(55);
				expr(9);
				}
				break;
			case 3:
				{
				_localctx = new Lambda1ParamContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				match(ID);
				setState(57);
				match(T__11);
				setState(58);
				expr(8);
				}
				break;
			case 4:
				{
				_localctx = new Lambda2ParamsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59);
				match(T__3);
				setState(60);
				match(ID);
				setState(61);
				match(COMMA);
				setState(62);
				match(ID);
				setState(63);
				match(T__4);
				setState(64);
				match(T__11);
				setState(65);
				expr(7);
				}
				break;
			case 5:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(66);
				match(INT);
				}
				break;
			case 6:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(67);
				match(FLOAT);
				}
				break;
			case 7:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				match(ID);
				}
				break;
			case 8:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69);
				match(T__3);
				setState(70);
				expr(0);
				setState(71);
				match(T__4);
				}
				break;
			case 9:
				{
				_localctx = new ListsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73);
				match(LBRACK);
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1712400L) != 0)) {
					{
					setState(74);
					elements();
					}
				}

				setState(77);
				match(RBRACK);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(110);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(108);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new PowSqrtContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(80);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(81);
						((PowSqrtContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==T__6) ) {
							((PowSqrtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(82);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(83);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(84);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__8 || _la==T__9) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(85);
						expr(13);
						}
						break;
					case 3:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(86);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(87);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__7 || _la==T__10) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(88);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new TernaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(89);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(90);
						match(QUESTION);
						setState(91);
						expr(0);
						setState(92);
						match(COLON);
						setState(93);
						expr(10);
						}
						break;
					case 5:
						{
						_localctx = new FuncCallContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(95);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(96);
						match(T__3);
						setState(105);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1712400L) != 0)) {
							{
							setState(97);
							expr(0);
							setState(102);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(98);
								match(COMMA);
								setState(99);
								expr(0);
								}
								}
								setState(104);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(107);
						match(T__4);
						}
						break;
					}
					} 
				}
				setState(112);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0018r\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0005\u0000\f\b\u0000\n\u0000\f\u0000\u000f\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001&\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002+\b\u0002\n\u0002\f\u0002.\t\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004L\b\u0004\u0001\u0004"+
		"\u0003\u0004O\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004e\b\u0004"+
		"\n\u0004\f\u0004h\t\u0004\u0003\u0004j\b\u0004\u0001\u0004\u0005\u0004"+
		"m\b\u0004\n\u0004\f\u0004p\t\u0004\u0001\u0004\u0000\u0001\b\u0005\u0000"+
		"\u0002\u0004\u0006\b\u0000\u0004\u0001\u0000\u000f\u0010\u0001\u0000\u0006"+
		"\u0007\u0001\u0000\t\n\u0002\u0000\b\b\u000b\u000b\u0082\u0000\r\u0001"+
		"\u0000\u0000\u0000\u0002%\u0001\u0000\u0000\u0000\u0004\'\u0001\u0000"+
		"\u0000\u0000\u0006/\u0001\u0000\u0000\u0000\bN\u0001\u0000\u0000\u0000"+
		"\n\f\u0003\u0002\u0001\u0000\u000b\n\u0001\u0000\u0000\u0000\f\u000f\u0001"+
		"\u0000\u0000\u0000\r\u000b\u0001\u0000\u0000\u0000\r\u000e\u0001\u0000"+
		"\u0000\u0000\u000e\u0010\u0001\u0000\u0000\u0000\u000f\r\u0001\u0000\u0000"+
		"\u0000\u0010\u0011\u0005\u0000\u0000\u0001\u0011\u0001\u0001\u0000\u0000"+
		"\u0000\u0012\u0013\u0005\u0001\u0000\u0000\u0013\u0014\u0005\r\u0000\u0000"+
		"\u0014\u0015\u0005\u0002\u0000\u0000\u0015\u0016\u0003\b\u0004\u0000\u0016"+
		"\u0017\u0005\u000e\u0000\u0000\u0017&\u0001\u0000\u0000\u0000\u0018\u0019"+
		"\u0005\u0003\u0000\u0000\u0019\u001a\u0005\u0004\u0000\u0000\u001a\u001b"+
		"\u0003\b\u0004\u0000\u001b\u001c\u0005\u0005\u0000\u0000\u001c\u001d\u0005"+
		"\u000e\u0000\u0000\u001d&\u0001\u0000\u0000\u0000\u001e\u001f\u0003\b"+
		"\u0004\u0000\u001f \u0005\u000e\u0000\u0000 &\u0001\u0000\u0000\u0000"+
		"!\"\u0003\u0006\u0003\u0000\"#\u0005\u000e\u0000\u0000#&\u0001\u0000\u0000"+
		"\u0000$&\u0005\u000e\u0000\u0000%\u0012\u0001\u0000\u0000\u0000%\u0018"+
		"\u0001\u0000\u0000\u0000%\u001e\u0001\u0000\u0000\u0000%!\u0001\u0000"+
		"\u0000\u0000%$\u0001\u0000\u0000\u0000&\u0003\u0001\u0000\u0000\u0000"+
		"\',\u0003\b\u0004\u0000()\u0005\u0016\u0000\u0000)+\u0003\b\u0004\u0000"+
		"*(\u0001\u0000\u0000\u0000+.\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000"+
		"\u0000,-\u0001\u0000\u0000\u0000-\u0005\u0001\u0000\u0000\u0000.,\u0001"+
		"\u0000\u0000\u0000/0\u0007\u0000\u0000\u00000\u0007\u0001\u0000\u0000"+
		"\u000012\u0006\u0004\uffff\uffff\u000023\u0005\b\u0000\u00003O\u0003\b"+
		"\u0004\r45\u0005\u0004\u0000\u000056\u0005\u0005\u0000\u000067\u0005\f"+
		"\u0000\u00007O\u0003\b\u0004\t89\u0005\r\u0000\u00009:\u0005\f\u0000\u0000"+
		":O\u0003\b\u0004\b;<\u0005\u0004\u0000\u0000<=\u0005\r\u0000\u0000=>\u0005"+
		"\u0016\u0000\u0000>?\u0005\r\u0000\u0000?@\u0005\u0005\u0000\u0000@A\u0005"+
		"\f\u0000\u0000AO\u0003\b\u0004\u0007BO\u0005\u0011\u0000\u0000CO\u0005"+
		"\u0013\u0000\u0000DO\u0005\r\u0000\u0000EF\u0005\u0004\u0000\u0000FG\u0003"+
		"\b\u0004\u0000GH\u0005\u0005\u0000\u0000HO\u0001\u0000\u0000\u0000IK\u0005"+
		"\u0014\u0000\u0000JL\u0003\u0004\u0002\u0000KJ\u0001\u0000\u0000\u0000"+
		"KL\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MO\u0005\u0015\u0000"+
		"\u0000N1\u0001\u0000\u0000\u0000N4\u0001\u0000\u0000\u0000N8\u0001\u0000"+
		"\u0000\u0000N;\u0001\u0000\u0000\u0000NB\u0001\u0000\u0000\u0000NC\u0001"+
		"\u0000\u0000\u0000ND\u0001\u0000\u0000\u0000NE\u0001\u0000\u0000\u0000"+
		"NI\u0001\u0000\u0000\u0000On\u0001\u0000\u0000\u0000PQ\n\u000e\u0000\u0000"+
		"QR\u0007\u0001\u0000\u0000Rm\u0003\b\u0004\u000eST\n\f\u0000\u0000TU\u0007"+
		"\u0002\u0000\u0000Um\u0003\b\u0004\rVW\n\u000b\u0000\u0000WX\u0007\u0003"+
		"\u0000\u0000Xm\u0003\b\u0004\fYZ\n\n\u0000\u0000Z[\u0005\u0017\u0000\u0000"+
		"[\\\u0003\b\u0004\u0000\\]\u0005\u0018\u0000\u0000]^\u0003\b\u0004\n^"+
		"m\u0001\u0000\u0000\u0000_`\n\u0006\u0000\u0000`i\u0005\u0004\u0000\u0000"+
		"af\u0003\b\u0004\u0000bc\u0005\u0016\u0000\u0000ce\u0003\b\u0004\u0000"+
		"db\u0001\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000"+
		"\u0000fg\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001\u0000"+
		"\u0000\u0000ia\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jk\u0001"+
		"\u0000\u0000\u0000km\u0005\u0005\u0000\u0000lP\u0001\u0000\u0000\u0000"+
		"lS\u0001\u0000\u0000\u0000lV\u0001\u0000\u0000\u0000lY\u0001\u0000\u0000"+
		"\u0000l_\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000nl\u0001\u0000"+
		"\u0000\u0000no\u0001\u0000\u0000\u0000o\t\u0001\u0000\u0000\u0000pn\u0001"+
		"\u0000\u0000\u0000\t\r%,KNfiln";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}