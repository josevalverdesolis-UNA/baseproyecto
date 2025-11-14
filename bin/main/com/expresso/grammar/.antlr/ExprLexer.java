// Generated from c:/Dev/Paradigmas/Expresso/bin/main/com/expresso/grammar/Expr.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, ID=13, NEWLINE=14, LINECOMMENT=15, BLOCKCOMMENT=16, 
		INT=17, WS=18, FLOAT=19, LBRACK=20, RBRACK=21, COMMA=22, QUESTION=23, 
		COLON=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "ID", "NEWLINE", "LINECOMMENT", "BLOCKCOMMENT", 
			"INT", "WS", "FLOAT", "LBRACK", "RBRACK", "COMMA", "QUESTION", "COLON"
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


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0018\u009e\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0005\fV\b\f\n\f\f\fY\t\f\u0001"+
		"\r\u0003\r\\\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000ed\b\u000e\n\u000e\f\u000eg\t\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000fm\b\u000f\n\u000f\f\u000fp\t"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0004\u0010v\b"+
		"\u0010\u000b\u0010\f\u0010w\u0001\u0011\u0004\u0011{\b\u0011\u000b\u0011"+
		"\f\u0011|\u0001\u0011\u0001\u0011\u0001\u0012\u0004\u0012\u0082\b\u0012"+
		"\u000b\u0012\f\u0012\u0083\u0001\u0012\u0001\u0012\u0005\u0012\u0088\b"+
		"\u0012\n\u0012\f\u0012\u008b\t\u0012\u0001\u0012\u0001\u0012\u0004\u0012"+
		"\u008f\b\u0012\u000b\u0012\f\u0012\u0090\u0003\u0012\u0093\b\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001n\u0000\u0018\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018"+
		"\u0001\u0000\u0005\u0003\u0000AZ__az\u0004\u000009AZ__az\u0002\u0000\n"+
		"\n\r\r\u0001\u000009\u0002\u0000\t\t  \u00a7\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000"+
		"\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00011"+
		"\u0001\u0000\u0000\u0000\u00035\u0001\u0000\u0000\u0000\u00057\u0001\u0000"+
		"\u0000\u0000\u0007=\u0001\u0000\u0000\u0000\t?\u0001\u0000\u0000\u0000"+
		"\u000bA\u0001\u0000\u0000\u0000\rD\u0001\u0000\u0000\u0000\u000fH\u0001"+
		"\u0000\u0000\u0000\u0011J\u0001\u0000\u0000\u0000\u0013L\u0001\u0000\u0000"+
		"\u0000\u0015N\u0001\u0000\u0000\u0000\u0017P\u0001\u0000\u0000\u0000\u0019"+
		"S\u0001\u0000\u0000\u0000\u001b[\u0001\u0000\u0000\u0000\u001d_\u0001"+
		"\u0000\u0000\u0000\u001fh\u0001\u0000\u0000\u0000!u\u0001\u0000\u0000"+
		"\u0000#z\u0001\u0000\u0000\u0000%\u0092\u0001\u0000\u0000\u0000\'\u0094"+
		"\u0001\u0000\u0000\u0000)\u0096\u0001\u0000\u0000\u0000+\u0098\u0001\u0000"+
		"\u0000\u0000-\u009a\u0001\u0000\u0000\u0000/\u009c\u0001\u0000\u0000\u0000"+
		"12\u0005l\u0000\u000023\u0005e\u0000\u000034\u0005t\u0000\u00004\u0002"+
		"\u0001\u0000\u0000\u000056\u0005=\u0000\u00006\u0004\u0001\u0000\u0000"+
		"\u000078\u0005p\u0000\u000089\u0005r\u0000\u00009:\u0005i\u0000\u0000"+
		":;\u0005n\u0000\u0000;<\u0005t\u0000\u0000<\u0006\u0001\u0000\u0000\u0000"+
		"=>\u0005(\u0000\u0000>\b\u0001\u0000\u0000\u0000?@\u0005)\u0000\u0000"+
		"@\n\u0001\u0000\u0000\u0000AB\u0005*\u0000\u0000BC\u0005*\u0000\u0000"+
		"C\f\u0001\u0000\u0000\u0000DE\u0005!\u0000\u0000EF\u0005*\u0000\u0000"+
		"FG\u0005*\u0000\u0000G\u000e\u0001\u0000\u0000\u0000HI\u0005-\u0000\u0000"+
		"I\u0010\u0001\u0000\u0000\u0000JK\u0005*\u0000\u0000K\u0012\u0001\u0000"+
		"\u0000\u0000LM\u0005/\u0000\u0000M\u0014\u0001\u0000\u0000\u0000NO\u0005"+
		"+\u0000\u0000O\u0016\u0001\u0000\u0000\u0000PQ\u0005-\u0000\u0000QR\u0005"+
		">\u0000\u0000R\u0018\u0001\u0000\u0000\u0000SW\u0007\u0000\u0000\u0000"+
		"TV\u0007\u0001\u0000\u0000UT\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000"+
		"\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000X\u001a\u0001"+
		"\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000Z\\\u0005\r\u0000\u0000[Z"+
		"\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000"+
		"\u0000]^\u0005\n\u0000\u0000^\u001c\u0001\u0000\u0000\u0000_`\u0005/\u0000"+
		"\u0000`a\u0005/\u0000\u0000ae\u0001\u0000\u0000\u0000bd\b\u0002\u0000"+
		"\u0000cb\u0001\u0000\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000"+
		"\u0000\u0000ef\u0001\u0000\u0000\u0000f\u001e\u0001\u0000\u0000\u0000"+
		"ge\u0001\u0000\u0000\u0000hi\u0005/\u0000\u0000ij\u0005*\u0000\u0000j"+
		"n\u0001\u0000\u0000\u0000km\t\u0000\u0000\u0000lk\u0001\u0000\u0000\u0000"+
		"mp\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000"+
		"\u0000oq\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000qr\u0005*\u0000"+
		"\u0000rs\u0005/\u0000\u0000s \u0001\u0000\u0000\u0000tv\u0007\u0003\u0000"+
		"\u0000ut\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wu\u0001\u0000"+
		"\u0000\u0000wx\u0001\u0000\u0000\u0000x\"\u0001\u0000\u0000\u0000y{\u0007"+
		"\u0004\u0000\u0000zy\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000"+
		"|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000"+
		"\u0000~\u007f\u0006\u0011\u0000\u0000\u007f$\u0001\u0000\u0000\u0000\u0080"+
		"\u0082\u0007\u0003\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085"+
		"\u0089\u0005.\u0000\u0000\u0086\u0088\u0007\u0003\u0000\u0000\u0087\u0086"+
		"\u0001\u0000\u0000\u0000\u0088\u008b\u0001\u0000\u0000\u0000\u0089\u0087"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u0093"+
		"\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008c\u008e"+
		"\u0005.\u0000\u0000\u008d\u008f\u0007\u0003\u0000\u0000\u008e\u008d\u0001"+
		"\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u008e\u0001"+
		"\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0093\u0001"+
		"\u0000\u0000\u0000\u0092\u0081\u0001\u0000\u0000\u0000\u0092\u008c\u0001"+
		"\u0000\u0000\u0000\u0093&\u0001\u0000\u0000\u0000\u0094\u0095\u0005[\u0000"+
		"\u0000\u0095(\u0001\u0000\u0000\u0000\u0096\u0097\u0005]\u0000\u0000\u0097"+
		"*\u0001\u0000\u0000\u0000\u0098\u0099\u0005,\u0000\u0000\u0099,\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0005?\u0000\u0000\u009b.\u0001\u0000\u0000"+
		"\u0000\u009c\u009d\u0005:\u0000\u0000\u009d0\u0001\u0000\u0000\u0000\u000b"+
		"\u0000W[enw|\u0083\u0089\u0090\u0092\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}