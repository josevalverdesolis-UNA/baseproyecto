// Generated from c:/Dev/Paradigmas/Expresso/src/main/antlr/com/expresso/grammar/Expr.g4 by ANTLR 4.13.1
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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, DATA=20, FUN=21, LET=22, PRINT=23, IF=24, MATCH=25, 
		WITH=26, ANY=27, VOID=28, INT_TYPE=29, FLOAT_TYPE=30, STRING_TYPE=31, 
		BOOLEAN=32, NONE=33, ID=34, FLOAT=35, INT=36, STRING=37, LBRACE=38, RBRACE=39, 
		LBRACK=40, RBRACK=41, COMMA=42, QUESTION=43, COLON=44, ARROW=45, PIPE=46, 
		WS=47, NEWLINE=48, LINECOMMENT=49, BLOCKCOMMENT=50;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_data = 2, RULE_constructors = 3, RULE_constructor = 4, 
		RULE_arguments = 5, RULE_argument = 6, RULE_elements = 7, RULE_expr = 8, 
		RULE_match_rule = 9, RULE_guard = 10, RULE_pattern = 11, RULE_data_pattern = 12, 
		RULE_pattern_params = 13, RULE_native_pattern = 14, RULE_params = 15, 
		RULE_constructor_call = 16, RULE_atomic = 17, RULE_tuple = 18, RULE_type = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "data", "constructors", "constructor", "arguments", "argument", 
			"elements", "expr", "match_rule", "guard", "pattern", "data_pattern", 
			"pattern_params", "native_pattern", "params", "constructor_call", "atomic", 
			"tuple", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "')'", "'-'", "'!'", "'^'", "'**'", "'!**'", "'*'", 
			"'/'", "'+'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", "'||'", 
			"'data'", "'fun'", "'let'", "'print'", "'if'", "'match'", "'with'", "'any'", 
			"'void'", "'int'", "'float'", "'string'", null, "'none'", null, null, 
			null, null, "'{'", "'}'", "'['", "']'", "','", "'?'", "':'", "'->'", 
			"'|'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "DATA", "FUN", "LET", 
			"PRINT", "IF", "MATCH", "WITH", "ANY", "VOID", "INT_TYPE", "FLOAT_TYPE", 
			"STRING_TYPE", "BOOLEAN", "NONE", "ID", "FLOAT", "INT", "STRING", "LBRACE", 
			"RBRACE", "LBRACK", "RBRACK", "COMMA", "QUESTION", "COLON", "ARROW", 
			"PIPE", "WS", "NEWLINE", "LINECOMMENT", "BLOCKCOMMENT"
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
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 282845120561268L) != 0)) {
				{
				{
				setState(40);
				stat();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
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
	public static class DataDeclarationContext extends StatContext {
		public DataContext data() {
			return getRuleContext(DataContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ExprParser.NEWLINE, 0); }
		public TerminalNode EOF() { return getToken(ExprParser.EOF, 0); }
		public DataDeclarationContext(StatContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintStatementContext extends StatContext {
		public TerminalNode PRINT() { return getToken(ExprParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ExprParser.NEWLINE, 0); }
		public TerminalNode EOF() { return getToken(ExprParser.EOF, 0); }
		public PrintStatementContext(StatContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetStatementContext extends StatContext {
		public TerminalNode LET() { return getToken(ExprParser.LET, 0); }
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ExprParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ExprParser.NEWLINE, 0); }
		public TerminalNode EOF() { return getToken(ExprParser.EOF, 0); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class FunContext extends StatContext {
		public TerminalNode FUN() { return getToken(ExprParser.FUN, 0); }
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ExprParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ExprParser.NEWLINE, 0); }
		public TerminalNode EOF() { return getToken(ExprParser.EOF, 0); }
		public FunContext(StatContext ctx) { copyFrom(ctx); }
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		int _la;
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LET:
				_localctx = new LetStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				match(LET);
				setState(49);
				match(ID);
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(50);
					match(COLON);
					setState(51);
					type();
					}
				}

				setState(54);
				match(T__0);
				setState(55);
				expr(0);
				setState(57);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(56);
					_la = _input.LA(1);
					if ( !(_la==EOF || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				}
				break;
			case FUN:
				_localctx = new FunContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				match(FUN);
				setState(60);
				match(ID);
				setState(61);
				match(T__1);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 21340618756L) != 0)) {
					{
					setState(62);
					arguments();
					}
				}

				setState(65);
				match(T__2);
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(66);
					match(COLON);
					setState(67);
					type();
					}
				}

				setState(70);
				match(T__0);
				setState(71);
				expr(0);
				setState(73);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(72);
					_la = _input.LA(1);
					if ( !(_la==EOF || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				}
				break;
			case DATA:
				_localctx = new DataDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				data();
				setState(77);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(76);
					_la = _input.LA(1);
					if ( !(_la==EOF || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				}
				break;
			case PRINT:
				_localctx = new PrintStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				match(PRINT);
				setState(80);
				match(T__1);
				setState(81);
				expr(0);
				setState(82);
				match(T__2);
				setState(84);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(83);
					_la = _input.LA(1);
					if ( !(_la==EOF || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				}
				break;
			case T__1:
			case T__3:
			case T__4:
			case T__5:
			case MATCH:
			case BOOLEAN:
			case NONE:
			case ID:
			case FLOAT:
			case INT:
			case STRING:
			case LBRACK:
				_localctx = new PrintExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(86);
				expr(0);
				setState(87);
				match(NEWLINE);
				}
				break;
			case NEWLINE:
				_localctx = new BlankContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(89);
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
	public static class DataContext extends ParserRuleContext {
		public TerminalNode DATA() { return getToken(ExprParser.DATA, 0); }
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode LBRACE() { return getToken(ExprParser.LBRACE, 0); }
		public ConstructorsContext constructors() {
			return getRuleContext(ConstructorsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ExprParser.RBRACE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExprParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExprParser.NEWLINE, i);
		}
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(DATA);
			setState(93);
			match(ID);
			setState(94);
			match(T__0);
			setState(95);
			match(LBRACE);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(96);
				match(NEWLINE);
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			constructors();
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(103);
				match(NEWLINE);
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			match(RBRACE);
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
	public static class ConstructorsContext extends ParserRuleContext {
		public List<ConstructorContext> constructor() {
			return getRuleContexts(ConstructorContext.class);
		}
		public ConstructorContext constructor(int i) {
			return getRuleContext(ConstructorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExprParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprParser.COMMA, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExprParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExprParser.NEWLINE, i);
		}
		public ConstructorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructors; }
	}

	public final ConstructorsContext constructors() throws RecognitionException {
		ConstructorsContext _localctx = new ConstructorsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_constructors);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			constructor();
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(112);
				match(COMMA);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(113);
					match(NEWLINE);
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(119);
				constructor();
				}
				}
				setState(124);
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
	public static class ConstructorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(ID);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(126);
				match(T__1);
				setState(127);
				arguments();
				setState(128);
				match(T__2);
				}
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
	public static class ArgumentsContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExprParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			argument();
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(133);
				match(COMMA);
				setState(134);
				argument();
				}
				}
				setState(139);
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
	public static class ArgumentContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode COLON() { return getToken(ExprParser.COLON, 0); }
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(140);
				match(ID);
				setState(141);
				match(COLON);
				}
				break;
			}
			setState(144);
			type();
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
		enterRule(_localctx, 14, RULE_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			expr(0);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(147);
				match(COMMA);
				setState(148);
				expr(0);
				}
				}
				setState(153);
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
	public static class CastContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ExprParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public CastContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class NumContext extends ExprContext {
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(ExprParser.FLOAT, 0); }
		public NumContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class RelationalContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RelationalContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryMinusContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryMinusContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstantiatorContext extends ExprContext {
		public Constructor_callContext constructor_call() {
			return getRuleContext(Constructor_callContext.class,0);
		}
		public InstantiatorContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(ExprParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOrContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LogicalOrContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MatchContext extends ExprContext {
		public TerminalNode MATCH() { return getToken(ExprParser.MATCH, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode WITH() { return getToken(ExprParser.WITH, 0); }
		public List<Match_ruleContext> match_rule() {
			return getRuleContexts(Match_ruleContext.class);
		}
		public Match_ruleContext match_rule(int i) {
			return getRuleContext(Match_ruleContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExprParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExprParser.NEWLINE, i);
		}
		public List<TerminalNode> PIPE() { return getTokens(ExprParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(ExprParser.PIPE, i);
		}
		public MatchContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalNotContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LogicalNotContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class LambdaParamsContext extends ExprContext {
		public TerminalNode ARROW() { return getToken(ExprParser.ARROW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public LambdaParamsContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends ExprContext {
		public TerminalNode BOOLEAN() { return getToken(ExprParser.BOOLEAN, 0); }
		public BoolContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class LogicalAndContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LogicalAndContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LambdaContext extends ExprContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode ARROW() { return getToken(ExprParser.ARROW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LambdaContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NoneContext extends ExprContext {
		public TerminalNode NONE() { return getToken(ExprParser.NONE, 0); }
		public NoneContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryMinusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(155);
				match(T__3);
				setState(156);
				expr(23);
				}
				break;
			case 2:
				{
				_localctx = new LogicalNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157);
				match(T__4);
				setState(158);
				expr(22);
				}
				break;
			case 3:
				{
				_localctx = new InstantiatorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				match(T__5);
				setState(160);
				constructor_call();
				}
				break;
			case 4:
				{
				_localctx = new MatchContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(161);
				match(MATCH);
				setState(162);
				expr(0);
				setState(163);
				match(WITH);
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(164);
					match(NEWLINE);
					}
					}
					setState(169);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(170);
				match_rule();
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(174);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NEWLINE) {
							{
							{
							setState(171);
							match(NEWLINE);
							}
							}
							setState(176);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(177);
						match(PIPE);
						setState(181);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NEWLINE) {
							{
							{
							setState(178);
							match(NEWLINE);
							}
							}
							setState(183);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(184);
						match_rule();
						}
						} 
					}
					setState(189);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				}
				break;
			case 5:
				{
				_localctx = new LambdaParamsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
				match(T__1);
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 21340618756L) != 0)) {
					{
					setState(191);
					arguments();
					}
				}

				setState(194);
				match(T__2);
				setState(195);
				match(ARROW);
				setState(196);
				expr(10);
				}
				break;
			case 6:
				{
				_localctx = new LambdaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				match(ID);
				setState(198);
				match(ARROW);
				setState(199);
				expr(9);
				}
				break;
			case 7:
				{
				_localctx = new NumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200);
				match(INT);
				}
				break;
			case 8:
				{
				_localctx = new NumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				match(FLOAT);
				}
				break;
			case 9:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
				match(BOOLEAN);
				}
				break;
			case 10:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				match(STRING);
				}
				break;
			case 11:
				{
				_localctx = new NoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
				match(NONE);
				}
				break;
			case 12:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205);
				match(ID);
				}
				break;
			case 13:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206);
				match(T__1);
				setState(207);
				expr(0);
				setState(208);
				match(T__2);
				}
				break;
			case 14:
				{
				_localctx = new ListsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210);
				match(LBRACK);
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1370128121972L) != 0)) {
					{
					setState(211);
					elements();
					}
				}

				setState(214);
				match(RBRACK);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(259);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(257);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new PowSqrtContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(217);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(218);
						((PowSqrtContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__7) ) {
							((PowSqrtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(219);
						expr(17);
						}
						break;
					case 2:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(220);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(221);
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
						setState(222);
						expr(17);
						}
						break;
					case 3:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(223);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(224);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__3 || _la==T__10) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(225);
						expr(16);
						}
						break;
					case 4:
						{
						_localctx = new RelationalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(226);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(227);
						((RelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 258048L) != 0)) ) {
							((RelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(228);
						expr(15);
						}
						break;
					case 5:
						{
						_localctx = new LogicalAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(229);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(230);
						((LogicalAndContext)_localctx).op = match(T__17);
						setState(231);
						expr(14);
						}
						break;
					case 6:
						{
						_localctx = new LogicalOrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(232);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(233);
						((LogicalOrContext)_localctx).op = match(T__18);
						setState(234);
						expr(13);
						}
						break;
					case 7:
						{
						_localctx = new TernaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(235);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(236);
						match(QUESTION);
						setState(237);
						expr(0);
						setState(238);
						match(COLON);
						setState(239);
						expr(11);
						}
						break;
					case 8:
						{
						_localctx = new CastContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(241);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(242);
						match(COLON);
						setState(243);
						type();
						}
						break;
					case 9:
						{
						_localctx = new FuncCallContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(244);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(245);
						match(T__1);
						setState(254);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1370128121972L) != 0)) {
							{
							setState(246);
							expr(0);
							setState(251);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(247);
								match(COMMA);
								setState(248);
								expr(0);
								}
								}
								setState(253);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(256);
						match(T__2);
						}
						break;
					}
					} 
				}
				setState(261);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Match_ruleContext extends ParserRuleContext {
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(ExprParser.ARROW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public Match_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match_rule; }
	}

	public final Match_ruleContext match_rule() throws RecognitionException {
		Match_ruleContext _localctx = new Match_ruleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_match_rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			pattern();
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(263);
				guard();
				}
			}

			setState(266);
			match(ARROW);
			setState(267);
			expr(0);
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
	public static class GuardContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(ExprParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public GuardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard; }
	}

	public final GuardContext guard() throws RecognitionException {
		GuardContext _localctx = new GuardContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(IF);
			setState(270);
			expr(0);
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
	public static class PatternContext extends ParserRuleContext {
		public Data_patternContext data_pattern() {
			return getRuleContext(Data_patternContext.class,0);
		}
		public Native_patternContext native_pattern() {
			return getRuleContext(Native_patternContext.class,0);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pattern);
		try {
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				data_pattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				native_pattern();
				}
				break;
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
	public static class Data_patternContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public Pattern_paramsContext pattern_params() {
			return getRuleContext(Pattern_paramsContext.class,0);
		}
		public Data_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_pattern; }
	}

	public final Data_patternContext data_pattern() throws RecognitionException {
		Data_patternContext _localctx = new Data_patternContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_data_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(ID);
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(277);
				match(T__1);
				setState(278);
				pattern_params();
				setState(279);
				match(T__2);
				}
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
	public static class Pattern_paramsContext extends ParserRuleContext {
		public List<Data_patternContext> data_pattern() {
			return getRuleContexts(Data_patternContext.class);
		}
		public Data_patternContext data_pattern(int i) {
			return getRuleContext(Data_patternContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExprParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprParser.COMMA, i);
		}
		public Pattern_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_params; }
	}

	public final Pattern_paramsContext pattern_params() throws RecognitionException {
		Pattern_paramsContext _localctx = new Pattern_paramsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pattern_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			data_pattern();
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(284);
				match(COMMA);
				setState(285);
				data_pattern();
				}
				}
				setState(290);
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
	public static class Native_patternContext extends ParserRuleContext {
		public Native_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_native_pattern; }
	 
		public Native_patternContext() { }
		public void copyFrom(Native_patternContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolConstantContext extends Native_patternContext {
		public TerminalNode BOOLEAN() { return getToken(ExprParser.BOOLEAN, 0); }
		public BoolConstantContext(Native_patternContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariablePatternContext extends Native_patternContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public VariablePatternContext(Native_patternContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NoneConstantContext extends Native_patternContext {
		public TerminalNode NONE() { return getToken(ExprParser.NONE, 0); }
		public NoneConstantContext(Native_patternContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumericConstantContext extends Native_patternContext {
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(ExprParser.FLOAT, 0); }
		public NumericConstantContext(Native_patternContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringConstantContext extends Native_patternContext {
		public TerminalNode STRING() { return getToken(ExprParser.STRING, 0); }
		public StringConstantContext(Native_patternContext ctx) { copyFrom(ctx); }
	}

	public final Native_patternContext native_pattern() throws RecognitionException {
		Native_patternContext _localctx = new Native_patternContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_native_pattern);
		try {
			setState(297);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NONE:
				_localctx = new NoneConstantContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				match(NONE);
				}
				break;
			case BOOLEAN:
				_localctx = new BoolConstantContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				match(BOOLEAN);
				}
				break;
			case STRING:
				_localctx = new StringConstantContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(293);
				match(STRING);
				}
				break;
			case INT:
				_localctx = new NumericConstantContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(294);
				match(INT);
				}
				break;
			case FLOAT:
				_localctx = new NumericConstantContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(295);
				match(FLOAT);
				}
				break;
			case ID:
				_localctx = new VariablePatternContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(296);
				match(ID);
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
	public static class ParamsContext extends ParserRuleContext {
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
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			expr(0);
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(300);
				match(COMMA);
				setState(301);
				expr(0);
				}
				}
				setState(306);
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
	public static class Constructor_callContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Constructor_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor_call; }
	}

	public final Constructor_callContext constructor_call() throws RecognitionException {
		Constructor_callContext _localctx = new Constructor_callContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_constructor_call);
		try {
			setState(313);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(307);
				match(ID);
				setState(308);
				match(T__1);
				setState(309);
				params();
				setState(310);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				match(ID);
				}
				break;
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
	public static class AtomicContext extends ParserRuleContext {
		public TerminalNode ANY() { return getToken(ExprParser.ANY, 0); }
		public TerminalNode VOID() { return getToken(ExprParser.VOID, 0); }
		public TerminalNode INT_TYPE() { return getToken(ExprParser.INT_TYPE, 0); }
		public TerminalNode FLOAT_TYPE() { return getToken(ExprParser.FLOAT_TYPE, 0); }
		public TerminalNode STRING_TYPE() { return getToken(ExprParser.STRING_TYPE, 0); }
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public AtomicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomic; }
	}

	public final AtomicContext atomic() throws RecognitionException {
		AtomicContext _localctx = new AtomicContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_atomic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 21340618752L) != 0)) ) {
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
	public static class TupleContext extends ParserRuleContext {
		public List<AtomicContext> atomic() {
			return getRuleContexts(AtomicContext.class);
		}
		public AtomicContext atomic(int i) {
			return getRuleContext(AtomicContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExprParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprParser.COMMA, i);
		}
		public TupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple; }
	}

	public final TupleContext tuple() throws RecognitionException {
		TupleContext _localctx = new TupleContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_tuple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			match(T__1);
			setState(318);
			atomic();
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(319);
				match(COMMA);
				setState(320);
				atomic();
				}
				}
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(326);
			match(T__2);
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
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TupleArrowTypeContext extends TypeContext {
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(ExprParser.ARROW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TupleArrowTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenArrowTypeContext extends TypeContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode ARROW() { return getToken(ExprParser.ARROW, 0); }
		public ParenArrowTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtomArrowTypeContext extends TypeContext {
		public AtomicContext atomic() {
			return getRuleContext(AtomicContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(ExprParser.ARROW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AtomArrowTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_type);
		try {
			setState(345);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				_localctx = new AtomArrowTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				atomic();
				setState(331);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(329);
					match(ARROW);
					setState(330);
					type();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new TupleArrowTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(333);
				tuple();
				setState(336);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(334);
					match(ARROW);
					setState(335);
					type();
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new ParenArrowTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(338);
				match(T__1);
				setState(339);
				type();
				setState(340);
				match(T__2);
				setState(343);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(341);
					match(ARROW);
					setState(342);
					type();
					}
					break;
				}
				}
				break;
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 17);
		case 1:
			return precpred(_ctx, 16);
		case 2:
			return precpred(_ctx, 15);
		case 3:
			return precpred(_ctx, 14);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 19);
		case 8:
			return precpred(_ctx, 18);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00012\u015c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0005\u0000*\b\u0000\n\u0000\f\u0000"+
		"-\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u00015\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001:\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001@\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"E\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001J\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001N\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001U\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001[\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002b\b\u0002\n\u0002"+
		"\f\u0002e\t\u0002\u0001\u0002\u0001\u0002\u0005\u0002i\b\u0002\n\u0002"+
		"\f\u0002l\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u0003s\b\u0003\n\u0003\f\u0003v\t\u0003\u0001\u0003\u0005"+
		"\u0003y\b\u0003\n\u0003\f\u0003|\t\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0083\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u0005\u0088\b\u0005\n\u0005\f\u0005\u008b\t\u0005"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u008f\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0096\b\u0007\n\u0007"+
		"\f\u0007\u0099\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00a6\b\b\n\b\f\b\u00a9"+
		"\t\b\u0001\b\u0001\b\u0005\b\u00ad\b\b\n\b\f\b\u00b0\t\b\u0001\b\u0001"+
		"\b\u0005\b\u00b4\b\b\n\b\f\b\u00b7\t\b\u0001\b\u0005\b\u00ba\b\b\n\b\f"+
		"\b\u00bd\t\b\u0001\b\u0001\b\u0003\b\u00c1\b\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00d5\b\b\u0001"+
		"\b\u0003\b\u00d8\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00fa"+
		"\b\b\n\b\f\b\u00fd\t\b\u0003\b\u00ff\b\b\u0001\b\u0005\b\u0102\b\b\n\b"+
		"\f\b\u0105\t\b\u0001\t\u0001\t\u0003\t\u0109\b\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0003\u000b\u0113\b"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u011a\b\f\u0001"+
		"\r\u0001\r\u0001\r\u0005\r\u011f\b\r\n\r\f\r\u0122\t\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u012a"+
		"\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u012f\b\u000f"+
		"\n\u000f\f\u000f\u0132\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u013a\b\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0142"+
		"\b\u0012\n\u0012\f\u0012\u0145\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u014c\b\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u0151\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u0158\b\u0013\u0003\u0013\u015a\b"+
		"\u0013\u0001\u0013\u0000\u0001\u0010\u0014\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000\u0006"+
		"\u0001\u000100\u0001\u0000\u0007\b\u0001\u0000\t\n\u0002\u0000\u0004\u0004"+
		"\u000b\u000b\u0001\u0000\f\u0011\u0002\u0000\u001b\u001f\"\"\u018b\u0000"+
		"+\u0001\u0000\u0000\u0000\u0002Z\u0001\u0000\u0000\u0000\u0004\\\u0001"+
		"\u0000\u0000\u0000\u0006o\u0001\u0000\u0000\u0000\b}\u0001\u0000\u0000"+
		"\u0000\n\u0084\u0001\u0000\u0000\u0000\f\u008e\u0001\u0000\u0000\u0000"+
		"\u000e\u0092\u0001\u0000\u0000\u0000\u0010\u00d7\u0001\u0000\u0000\u0000"+
		"\u0012\u0106\u0001\u0000\u0000\u0000\u0014\u010d\u0001\u0000\u0000\u0000"+
		"\u0016\u0112\u0001\u0000\u0000\u0000\u0018\u0114\u0001\u0000\u0000\u0000"+
		"\u001a\u011b\u0001\u0000\u0000\u0000\u001c\u0129\u0001\u0000\u0000\u0000"+
		"\u001e\u012b\u0001\u0000\u0000\u0000 \u0139\u0001\u0000\u0000\u0000\""+
		"\u013b\u0001\u0000\u0000\u0000$\u013d\u0001\u0000\u0000\u0000&\u0159\u0001"+
		"\u0000\u0000\u0000(*\u0003\u0002\u0001\u0000)(\u0001\u0000\u0000\u0000"+
		"*-\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000"+
		"\u0000,.\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000./\u0005\u0000"+
		"\u0000\u0001/\u0001\u0001\u0000\u0000\u000001\u0005\u0016\u0000\u0000"+
		"14\u0005\"\u0000\u000023\u0005,\u0000\u000035\u0003&\u0013\u000042\u0001"+
		"\u0000\u0000\u000045\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u0000"+
		"67\u0005\u0001\u0000\u000079\u0003\u0010\b\u00008:\u0007\u0000\u0000\u0000"+
		"98\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:[\u0001\u0000\u0000"+
		"\u0000;<\u0005\u0015\u0000\u0000<=\u0005\"\u0000\u0000=?\u0005\u0002\u0000"+
		"\u0000>@\u0003\n\u0005\u0000?>\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000"+
		"\u0000@A\u0001\u0000\u0000\u0000AD\u0005\u0003\u0000\u0000BC\u0005,\u0000"+
		"\u0000CE\u0003&\u0013\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000FG\u0005\u0001\u0000\u0000GI\u0003\u0010"+
		"\b\u0000HJ\u0007\u0000\u0000\u0000IH\u0001\u0000\u0000\u0000IJ\u0001\u0000"+
		"\u0000\u0000J[\u0001\u0000\u0000\u0000KM\u0003\u0004\u0002\u0000LN\u0007"+
		"\u0000\u0000\u0000ML\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000"+
		"N[\u0001\u0000\u0000\u0000OP\u0005\u0017\u0000\u0000PQ\u0005\u0002\u0000"+
		"\u0000QR\u0003\u0010\b\u0000RT\u0005\u0003\u0000\u0000SU\u0007\u0000\u0000"+
		"\u0000TS\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000U[\u0001\u0000"+
		"\u0000\u0000VW\u0003\u0010\b\u0000WX\u00050\u0000\u0000X[\u0001\u0000"+
		"\u0000\u0000Y[\u00050\u0000\u0000Z0\u0001\u0000\u0000\u0000Z;\u0001\u0000"+
		"\u0000\u0000ZK\u0001\u0000\u0000\u0000ZO\u0001\u0000\u0000\u0000ZV\u0001"+
		"\u0000\u0000\u0000ZY\u0001\u0000\u0000\u0000[\u0003\u0001\u0000\u0000"+
		"\u0000\\]\u0005\u0014\u0000\u0000]^\u0005\"\u0000\u0000^_\u0005\u0001"+
		"\u0000\u0000_c\u0005&\u0000\u0000`b\u00050\u0000\u0000a`\u0001\u0000\u0000"+
		"\u0000be\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000"+
		"\u0000\u0000df\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000fj\u0003"+
		"\u0006\u0003\u0000gi\u00050\u0000\u0000hg\u0001\u0000\u0000\u0000il\u0001"+
		"\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000"+
		"km\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mn\u0005\'\u0000\u0000"+
		"n\u0005\u0001\u0000\u0000\u0000oz\u0003\b\u0004\u0000pt\u0005*\u0000\u0000"+
		"qs\u00050\u0000\u0000rq\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000"+
		"tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uw\u0001\u0000\u0000"+
		"\u0000vt\u0001\u0000\u0000\u0000wy\u0003\b\u0004\u0000xp\u0001\u0000\u0000"+
		"\u0000y|\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000"+
		"\u0000\u0000{\u0007\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000"+
		"}\u0082\u0005\"\u0000\u0000~\u007f\u0005\u0002\u0000\u0000\u007f\u0080"+
		"\u0003\n\u0005\u0000\u0080\u0081\u0005\u0003\u0000\u0000\u0081\u0083\u0001"+
		"\u0000\u0000\u0000\u0082~\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000"+
		"\u0000\u0000\u0083\t\u0001\u0000\u0000\u0000\u0084\u0089\u0003\f\u0006"+
		"\u0000\u0085\u0086\u0005*\u0000\u0000\u0086\u0088\u0003\f\u0006\u0000"+
		"\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u008b\u0001\u0000\u0000\u0000"+
		"\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000"+
		"\u008a\u000b\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000"+
		"\u008c\u008d\u0005\"\u0000\u0000\u008d\u008f\u0005,\u0000\u0000\u008e"+
		"\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0001\u0000\u0000\u0000\u0090\u0091\u0003&\u0013\u0000\u0091\r"+
		"\u0001\u0000\u0000\u0000\u0092\u0097\u0003\u0010\b\u0000\u0093\u0094\u0005"+
		"*\u0000\u0000\u0094\u0096\u0003\u0010\b\u0000\u0095\u0093\u0001\u0000"+
		"\u0000\u0000\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000"+
		"\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u000f\u0001\u0000"+
		"\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u009b\u0006\b\uffff"+
		"\uffff\u0000\u009b\u009c\u0005\u0004\u0000\u0000\u009c\u00d8\u0003\u0010"+
		"\b\u0017\u009d\u009e\u0005\u0005\u0000\u0000\u009e\u00d8\u0003\u0010\b"+
		"\u0016\u009f\u00a0\u0005\u0006\u0000\u0000\u00a0\u00d8\u0003 \u0010\u0000"+
		"\u00a1\u00a2\u0005\u0019\u0000\u0000\u00a2\u00a3\u0003\u0010\b\u0000\u00a3"+
		"\u00a7\u0005\u001a\u0000\u0000\u00a4\u00a6\u00050\u0000\u0000\u00a5\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001\u0000\u0000\u0000\u00a7\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00aa"+
		"\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00aa\u00bb"+
		"\u0003\u0012\t\u0000\u00ab\u00ad\u00050\u0000\u0000\u00ac\u00ab\u0001"+
		"\u0000\u0000\u0000\u00ad\u00b0\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001"+
		"\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b1\u00b5\u0005"+
		".\u0000\u0000\u00b2\u00b4\u00050\u0000\u0000\u00b3\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b7\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b8\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b8\u00ba\u0003\u0012\t\u0000"+
		"\u00b9\u00ae\u0001\u0000\u0000\u0000\u00ba\u00bd\u0001\u0000\u0000\u0000"+
		"\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000"+
		"\u00bc\u00d8\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000"+
		"\u00be\u00c0\u0005\u0002\u0000\u0000\u00bf\u00c1\u0003\n\u0005\u0000\u00c0"+
		"\u00bf\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005\u0003\u0000\u0000\u00c3"+
		"\u00c4\u0005-\u0000\u0000\u00c4\u00d8\u0003\u0010\b\n\u00c5\u00c6\u0005"+
		"\"\u0000\u0000\u00c6\u00c7\u0005-\u0000\u0000\u00c7\u00d8\u0003\u0010"+
		"\b\t\u00c8\u00d8\u0005$\u0000\u0000\u00c9\u00d8\u0005#\u0000\u0000\u00ca"+
		"\u00d8\u0005 \u0000\u0000\u00cb\u00d8\u0005%\u0000\u0000\u00cc\u00d8\u0005"+
		"!\u0000\u0000\u00cd\u00d8\u0005\"\u0000\u0000\u00ce\u00cf\u0005\u0002"+
		"\u0000\u0000\u00cf\u00d0\u0003\u0010\b\u0000\u00d0\u00d1\u0005\u0003\u0000"+
		"\u0000\u00d1\u00d8\u0001\u0000\u0000\u0000\u00d2\u00d4\u0005(\u0000\u0000"+
		"\u00d3\u00d5\u0003\u000e\u0007\u0000\u00d4\u00d3\u0001\u0000\u0000\u0000"+
		"\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d8\u0005)\u0000\u0000\u00d7\u009a\u0001\u0000\u0000\u0000\u00d7"+
		"\u009d\u0001\u0000\u0000\u0000\u00d7\u009f\u0001\u0000\u0000\u0000\u00d7"+
		"\u00a1\u0001\u0000\u0000\u0000\u00d7\u00be\u0001\u0000\u0000\u0000\u00d7"+
		"\u00c5\u0001\u0000\u0000\u0000\u00d7\u00c8\u0001\u0000\u0000\u0000\u00d7"+
		"\u00c9\u0001\u0000\u0000\u0000\u00d7\u00ca\u0001\u0000\u0000\u0000\u00d7"+
		"\u00cb\u0001\u0000\u0000\u0000\u00d7\u00cc\u0001\u0000\u0000\u0000\u00d7"+
		"\u00cd\u0001\u0000\u0000\u0000\u00d7\u00ce\u0001\u0000\u0000\u0000\u00d7"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d8\u0103\u0001\u0000\u0000\u0000\u00d9"+
		"\u00da\n\u0011\u0000\u0000\u00da\u00db\u0007\u0001\u0000\u0000\u00db\u0102"+
		"\u0003\u0010\b\u0011\u00dc\u00dd\n\u0010\u0000\u0000\u00dd\u00de\u0007"+
		"\u0002\u0000\u0000\u00de\u0102\u0003\u0010\b\u0011\u00df\u00e0\n\u000f"+
		"\u0000\u0000\u00e0\u00e1\u0007\u0003\u0000\u0000\u00e1\u0102\u0003\u0010"+
		"\b\u0010\u00e2\u00e3\n\u000e\u0000\u0000\u00e3\u00e4\u0007\u0004\u0000"+
		"\u0000\u00e4\u0102\u0003\u0010\b\u000f\u00e5\u00e6\n\r\u0000\u0000\u00e6"+
		"\u00e7\u0005\u0012\u0000\u0000\u00e7\u0102\u0003\u0010\b\u000e\u00e8\u00e9"+
		"\n\f\u0000\u0000\u00e9\u00ea\u0005\u0013\u0000\u0000\u00ea\u0102\u0003"+
		"\u0010\b\r\u00eb\u00ec\n\u000b\u0000\u0000\u00ec\u00ed\u0005+\u0000\u0000"+
		"\u00ed\u00ee\u0003\u0010\b\u0000\u00ee\u00ef\u0005,\u0000\u0000\u00ef"+
		"\u00f0\u0003\u0010\b\u000b\u00f0\u0102\u0001\u0000\u0000\u0000\u00f1\u00f2"+
		"\n\u0013\u0000\u0000\u00f2\u00f3\u0005,\u0000\u0000\u00f3\u0102\u0003"+
		"&\u0013\u0000\u00f4\u00f5\n\u0012\u0000\u0000\u00f5\u00fe\u0005\u0002"+
		"\u0000\u0000\u00f6\u00fb\u0003\u0010\b\u0000\u00f7\u00f8\u0005*\u0000"+
		"\u0000\u00f8\u00fa\u0003\u0010\b\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fd\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000"+
		"\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00ff\u0001\u0000\u0000\u0000"+
		"\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fe\u00f6\u0001\u0000\u0000\u0000"+
		"\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000\u0000"+
		"\u0100\u0102\u0005\u0003\u0000\u0000\u0101\u00d9\u0001\u0000\u0000\u0000"+
		"\u0101\u00dc\u0001\u0000\u0000\u0000\u0101\u00df\u0001\u0000\u0000\u0000"+
		"\u0101\u00e2\u0001\u0000\u0000\u0000\u0101\u00e5\u0001\u0000\u0000\u0000"+
		"\u0101\u00e8\u0001\u0000\u0000\u0000\u0101\u00eb\u0001\u0000\u0000\u0000"+
		"\u0101\u00f1\u0001\u0000\u0000\u0000\u0101\u00f4\u0001\u0000\u0000\u0000"+
		"\u0102\u0105\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000"+
		"\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0011\u0001\u0000\u0000\u0000"+
		"\u0105\u0103\u0001\u0000\u0000\u0000\u0106\u0108\u0003\u0016\u000b\u0000"+
		"\u0107\u0109\u0003\u0014\n\u0000\u0108\u0107\u0001\u0000\u0000\u0000\u0108"+
		"\u0109\u0001\u0000\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a"+
		"\u010b\u0005-\u0000\u0000\u010b\u010c\u0003\u0010\b\u0000\u010c\u0013"+
		"\u0001\u0000\u0000\u0000\u010d\u010e\u0005\u0018\u0000\u0000\u010e\u010f"+
		"\u0003\u0010\b\u0000\u010f\u0015\u0001\u0000\u0000\u0000\u0110\u0113\u0003"+
		"\u0018\f\u0000\u0111\u0113\u0003\u001c\u000e\u0000\u0112\u0110\u0001\u0000"+
		"\u0000\u0000\u0112\u0111\u0001\u0000\u0000\u0000\u0113\u0017\u0001\u0000"+
		"\u0000\u0000\u0114\u0119\u0005\"\u0000\u0000\u0115\u0116\u0005\u0002\u0000"+
		"\u0000\u0116\u0117\u0003\u001a\r\u0000\u0117\u0118\u0005\u0003\u0000\u0000"+
		"\u0118\u011a\u0001\u0000\u0000\u0000\u0119\u0115\u0001\u0000\u0000\u0000"+
		"\u0119\u011a\u0001\u0000\u0000\u0000\u011a\u0019\u0001\u0000\u0000\u0000"+
		"\u011b\u0120\u0003\u0018\f\u0000\u011c\u011d\u0005*\u0000\u0000\u011d"+
		"\u011f\u0003\u0018\f\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011f\u0122"+
		"\u0001\u0000\u0000\u0000\u0120\u011e\u0001\u0000\u0000\u0000\u0120\u0121"+
		"\u0001\u0000\u0000\u0000\u0121\u001b\u0001\u0000\u0000\u0000\u0122\u0120"+
		"\u0001\u0000\u0000\u0000\u0123\u012a\u0005!\u0000\u0000\u0124\u012a\u0005"+
		" \u0000\u0000\u0125\u012a\u0005%\u0000\u0000\u0126\u012a\u0005$\u0000"+
		"\u0000\u0127\u012a\u0005#\u0000\u0000\u0128\u012a\u0005\"\u0000\u0000"+
		"\u0129\u0123\u0001\u0000\u0000\u0000\u0129\u0124\u0001\u0000\u0000\u0000"+
		"\u0129\u0125\u0001\u0000\u0000\u0000\u0129\u0126\u0001\u0000\u0000\u0000"+
		"\u0129\u0127\u0001\u0000\u0000\u0000\u0129\u0128\u0001\u0000\u0000\u0000"+
		"\u012a\u001d\u0001\u0000\u0000\u0000\u012b\u0130\u0003\u0010\b\u0000\u012c"+
		"\u012d\u0005*\u0000\u0000\u012d\u012f\u0003\u0010\b\u0000\u012e\u012c"+
		"\u0001\u0000\u0000\u0000\u012f\u0132\u0001\u0000\u0000\u0000\u0130\u012e"+
		"\u0001\u0000\u0000\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u001f"+
		"\u0001\u0000\u0000\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0133\u0134"+
		"\u0005\"\u0000\u0000\u0134\u0135\u0005\u0002\u0000\u0000\u0135\u0136\u0003"+
		"\u001e\u000f\u0000\u0136\u0137\u0005\u0003\u0000\u0000\u0137\u013a\u0001"+
		"\u0000\u0000\u0000\u0138\u013a\u0005\"\u0000\u0000\u0139\u0133\u0001\u0000"+
		"\u0000\u0000\u0139\u0138\u0001\u0000\u0000\u0000\u013a!\u0001\u0000\u0000"+
		"\u0000\u013b\u013c\u0007\u0005\u0000\u0000\u013c#\u0001\u0000\u0000\u0000"+
		"\u013d\u013e\u0005\u0002\u0000\u0000\u013e\u0143\u0003\"\u0011\u0000\u013f"+
		"\u0140\u0005*\u0000\u0000\u0140\u0142\u0003\"\u0011\u0000\u0141\u013f"+
		"\u0001\u0000\u0000\u0000\u0142\u0145\u0001\u0000\u0000\u0000\u0143\u0141"+
		"\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144\u0146"+
		"\u0001\u0000\u0000\u0000\u0145\u0143\u0001\u0000\u0000\u0000\u0146\u0147"+
		"\u0005\u0003\u0000\u0000\u0147%\u0001\u0000\u0000\u0000\u0148\u014b\u0003"+
		"\"\u0011\u0000\u0149\u014a\u0005-\u0000\u0000\u014a\u014c\u0003&\u0013"+
		"\u0000\u014b\u0149\u0001\u0000\u0000\u0000\u014b\u014c\u0001\u0000\u0000"+
		"\u0000\u014c\u015a\u0001\u0000\u0000\u0000\u014d\u0150\u0003$\u0012\u0000"+
		"\u014e\u014f\u0005-\u0000\u0000\u014f\u0151\u0003&\u0013\u0000\u0150\u014e"+
		"\u0001\u0000\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u015a"+
		"\u0001\u0000\u0000\u0000\u0152\u0153\u0005\u0002\u0000\u0000\u0153\u0154"+
		"\u0003&\u0013\u0000\u0154\u0157\u0005\u0003\u0000\u0000\u0155\u0156\u0005"+
		"-\u0000\u0000\u0156\u0158\u0003&\u0013\u0000\u0157\u0155\u0001\u0000\u0000"+
		"\u0000\u0157\u0158\u0001\u0000\u0000\u0000\u0158\u015a\u0001\u0000\u0000"+
		"\u0000\u0159\u0148\u0001\u0000\u0000\u0000\u0159\u014d\u0001\u0000\u0000"+
		"\u0000\u0159\u0152\u0001\u0000\u0000\u0000\u015a\'\u0001\u0000\u0000\u0000"+
		"(+49?DIMTZcjtz\u0082\u0089\u008e\u0097\u00a7\u00ae\u00b5\u00bb\u00c0\u00d4"+
		"\u00d7\u00fb\u00fe\u0101\u0103\u0108\u0112\u0119\u0120\u0129\u0130\u0139"+
		"\u0143\u014b\u0150\u0157\u0159";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}