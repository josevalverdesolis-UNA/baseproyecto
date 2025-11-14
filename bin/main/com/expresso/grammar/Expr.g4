// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

grammar Expr;

// This grammar it's almost the same that the one used in class Entry point
prog: stat* EOF;

// A sentence can be and expresion and a NEWLINE or just a NEWLINE Statements
stat:
	LET ID '=' expr (NEWLINE | EOF)? # LetStatement
	| FUN ID '(' arguments? ')' (COLON type)? '=' expr (
		NEWLINE
		| EOF
	)?										# Fun
	| data (NEWLINE | EOF)?					# DataDeclaration
	| PRINT '(' expr ')' (NEWLINE | EOF)?	# PrintStatement
	| expr NEWLINE							# PrintExpr
	| NEWLINE								# Blank;

// Data declaration
data: DATA ID '=' LBRACE NEWLINE* constructors NEWLINE* RBRACE;

// Constructors of a Data Declaration
constructors: constructor (COMMA NEWLINE* constructor)*;
constructor: ID ('(' arguments ')')?;

// Arguments
arguments: argument (COMMA argument)*;
argument: (ID COLON)? type;

// Elements of a Lists
elements: expr (COMMA expr)*;

// Expresion with precedens and unary '-'
expr:
	'-' expr													# UnaryMinus
	| '!' expr													# LogicalNot
	| '^' constructor_call										# Instantiator
	| MATCH expr WITH NEWLINE* match_rule (NEWLINE* PIPE NEWLINE* match_rule)*		# Match
	| expr COLON type											# Cast
	| expr '(' (expr (',' expr)*)? ')'							# FuncCall
	| <assoc = right> expr op = ('**' | '!**') expr				# PowSqrt
	| expr op = ('*' | '/') expr								# MulDiv
	| expr op = ('+' | '-') expr								# AddSub
	| expr op = ('<' | '<=' | '>' | '>=' | '==' | '!=') expr	# Relational
	| expr op = '&&' expr										# LogicalAnd
	| expr op = '||' expr										# LogicalOr
	| <assoc = right> expr QUESTION expr COLON expr				# Ternary
	| <assoc = right> '(' arguments? ')' ARROW expr				# LambdaParams
	//	| '(' arguments? ')' ARROW expr	# LambdaParams
	| <assoc = right> ID ARROW expr	# Lambda
	| INT							# Num
	| FLOAT							# Num
	| BOOLEAN						# Bool
	| STRING						# String
	| NONE							# None
	| ID							# Variable
	| '(' expr ')'					# Parens
	| LBRACK elements? RBRACK		# Lists;

// ---------------------- Matching Rules ----------------------
match_rule: pattern guard? ARROW expr;
guard: IF expr;
pattern: data_pattern | native_pattern;
data_pattern: ID ('(' pattern_params ')')?;
pattern_params: data_pattern (COMMA data_pattern)*;
native_pattern:
	NONE		# NoneConstant
	| BOOLEAN	# BoolConstant
	| STRING	# StringConstant
	| INT		# NumericConstant
	| FLOAT		# NumericConstant
	| ID		# VariablePattern;

// Params
params: expr (COMMA expr)*;

//Constructor call
constructor_call: ID '(' params ')' | ID;

// Types
atomic:
	ANY // Object
	| VOID // Void
	| INT_TYPE // Integer
	| FLOAT_TYPE // Float
	| STRING_TYPE // String
	| ID; // Usergiven

tuple: '(' atomic (COMMA atomic)* ')';

type:
	atomic (ARROW type)?			# AtomArrowType //ArrowType because can have arrow
	| tuple (ARROW type)?			# TupleArrowType //ArrowType because can have arrow
	| '(' type ')' (ARROW type)?	# ParenArrowType; //ArrowType because can have arrow

//-----------------------------------------------------------------------------------------------------------
// Lexer LEXER In ANTLR the lexer rules are defined with capital letters A lexer rule means how to
// identify tokens
// -----------------------------------------------------------------------------------------------------------
// Keywords
DATA: 'data';
FUN: 'fun';
LET: 'let';
PRINT: 'print';
IF: 'if'; // Para el guard
MATCH: 'match';
WITH: 'with';
ANY: 'any';
VOID: 'void';
INT_TYPE: 'int'; // Para el tipo
FLOAT_TYPE: 'float'; // Para el tipo
STRING_TYPE: 'string'; // Para el tipo
BOOLEAN: 'true' | 'false';
NONE: 'none';

// Identifiers
ID: [a-zA-Z_][a-zA-Z0-9_]*;

// Types
FLOAT: [0-9]+ '.' [0-9]* | '.' [0-9]+;
INT: [0-9]+;
STRING: '"' (~["\\\r\n] | '\\' .)* '"';

// Symbols
LBRACE: '{';
RBRACE: '}';
LBRACK: '[';
RBRACK: ']';
COMMA: ',';
QUESTION: '?';
COLON: ':';
ARROW: '->';
PIPE: '|';

// Whitespace and newlines
WS: [ \t]+ -> skip;
NEWLINE: ('\r'? '\n');

// Comments
LINECOMMENT: '//' ~[\r\n]* -> channel(HIDDEN);
BLOCKCOMMENT: '/*' .*? '*/' -> channel(HIDDEN);
//~ Means any symbol so LINECOMMENT accepted any caracter excepted \r and \n . means all caracter *
// as we know means 1 or many and ? means none or many. So why use *? it's like confuse or reduntant
// The real meaning is that *? makes it non-greedy. So what it means, well it means that it will
// stop in the first */.