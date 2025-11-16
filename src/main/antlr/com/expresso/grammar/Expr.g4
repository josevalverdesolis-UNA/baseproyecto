// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

grammar Expr;

// This grammar it's almost the same that the one used in class Entry point
prog: stat* EOF;

// A sentence can be and expresion and a NEWLINE or just a NEWLINE Statements
stat:
	LET ID (COLON type)? '=' expr (NEWLINE | EOF)? # LetStatement
	| FUN ID '(' arguments? ')' (COLON type)? '=' expr (
		NEWLINE
		| EOF
	)?                                       # Fun
	| data (NEWLINE | EOF)?                  # DataDeclaration
	| PRINT '(' expr ')' (NEWLINE | EOF)?    # PrintStatement
	| expr NEWLINE                           # PrintExpr
	| NEWLINE                                # Blank;

// Data declaration
data: DATA ID '=' LBRACE NEWLINE* constructors NEWLINE* RBRACE;

// Constructors of a Data Declaration
constructors: constructor (COMMA NEWLINE* constructor)*;
constructor: ID ('(' arguments ')')?;

// Arguments
arguments: argument (COMMA argument)*;
argument: ID (COLON type)?;

// Elements of a Lists
elements: expr (COMMA expr)*;

// Expresion with precedens and unary '-'
expr
    : lambdaExpr
    | ternaryExpr
    ;

lambdaExpr
    : lambdaHead ARROW expr
    | ID (COLON type)? ARROW expr
    ;

lambdaHead
    : '(' arguments? ')'
    ;

ternaryExpr
    : logicalOrExpr (QUESTION expr COLON ternaryExpr)?
    ;

logicalOrExpr
    : logicalXorExpr ('||' logicalXorExpr)*
    ;

logicalXorExpr
    : logicalAndExpr ('^^' logicalAndExpr)*
    ;

logicalAndExpr
    : equalityExpr ('&&' equalityExpr)*
    ;

equalityExpr
    : relationalExpr (('==' | '!=') relationalExpr)*
    ;

relationalExpr
    : additiveExpr (('<' | '<=' | '>' | '>=') additiveExpr)*
    ;

additiveExpr
    : multiplicativeExpr (('+' | '-') multiplicativeExpr)*
    ;

multiplicativeExpr
    : powerExpr (('*' | '/') powerExpr)*
    ;

powerExpr
    : unaryExpr
    | unaryExpr op = ('**' | '!**') powerExpr
    ;

unaryExpr
    : '-' unaryExpr                                              # UnaryMinus
    | '!' unaryExpr                                              # LogicalNot
    | '^' constructor_call                                      # Instantiator
    | MATCH expr WITH NEWLINE* match_rule
        (NEWLINE* PIPE NEWLINE* match_rule)*                     # Match
    | postfixExpr                                                # Postfix
    ;

postfixExpr
    : primaryExpr postfixPart*
    ;

postfixPart
    : '(' (expr (COMMA expr)*)? ')'                              # FuncCall
    | COLON type                                                 # Cast
    ;

primaryExpr
    : PRINT '(' expr ')'                                         # PrintExprValue
    | tupleExpr                                                  # TupleLiteral
    | groupExpr                                                  # GroupValue
    | LBRACK elements? RBRACK                                    # ListLiteral
    | INT                                                        # IntLiteral
    | FLOAT                                                      # FloatLiteral
    | BOOLEAN                                                    # BoolLiteral
    | STRING                                                     # StringLiteral
    | NONE                                                       # NoneLiteral
    | ID                                                         # Variable
    ;

tupleExpr
    : '(' expr (COMMA expr)+ ')'
    ;

groupExpr
    : '(' expr ')'
    ;

// ---------------------- Matching Rules ----------------------
match_rule: pattern guard? ARROW expr;

guard: IF expr;

pattern: data_pattern | native_pattern;

data_pattern: ID ('(' pattern_params ')')?;

pattern_params: data_pattern (COMMA data_pattern)*;

native_pattern:
    NONE        # NoneConstant
    | BOOLEAN   # BoolConstant
    | STRING    # StringConstant
    | INT       # NumericConstant
    | FLOAT     # NumericConstant
    | ID        # VariablePattern;

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
    atomic ARROW type           # AtomArrowType //ArrowType because can have arrow
    | atomic                    # AtomType
    | tuple ARROW type          # TupleArrowType //ArrowType because can have arrow
    | tuple                     # TupleType
    | '(' type ')' ARROW type   # ParenArrowType //ArrowType because can have arrow
    | '(' type ')'              # ParenType;

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
