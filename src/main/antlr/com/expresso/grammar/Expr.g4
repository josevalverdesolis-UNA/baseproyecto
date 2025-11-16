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
expr:
        // Lambdas first (highest precedence, right-associative)
        <assoc = right> '(' arguments? ')' ARROW expr                 # LambdaParams
        | <assoc = right> ID (COLON type)? ARROW expr                 # Lambda

        // Explicit cast: expr : type
        | expr COLON type                                            # Cast
        | '-' expr                                                   # UnaryMinus
        | '!' expr                                                   # LogicalNot
        | '^' constructor_call                                       # Instantiator
        | MATCH expr WITH NEWLINE* match_rule
            (NEWLINE* PIPE NEWLINE* match_rule)*                     # Match
        | expr '(' (expr (COMMA expr)*)? ')'                         # FuncCall
        | PRINT '(' expr ')'                                         # PrintExprValue
        | <assoc = right> expr op = ('**' | '!**') expr              # PowSqrt
        | expr op = ('*' | '/') expr                                 # MulDiv
        | expr op = ('+' | '-') expr                                 # AddSub
        | expr op = ('<' | '<=' | '>' | '>=' | '==' | '!=') expr     # Relational
        | expr op = '&&' expr                                        # LogicalAnd
        | expr op = '||' expr                                        # LogicalOr
        | <assoc = right> expr QUESTION expr COLON expr              # Ternary
        | INT                                                        # Num
        | FLOAT                                                      # Num
        | BOOLEAN                                                    # Bool
        | STRING                                                     # String
        | NONE                                                       # None
        | LBRACK elements? RBRACK                                    # Lists
        | ID                                                         # Variable
        | '(' inner=pureExpr ')'                                     # Parens
        ;

pureExpr:
        <assoc = right> '(' arguments? ')' ARROW expr
        | <assoc = right> ID (COLON type)? ARROW expr
        | '-' pureExpr
        | '!' pureExpr
        | '^' constructor_call
        | MATCH pureExpr WITH NEWLINE* match_rule (NEWLINE* PIPE NEWLINE* match_rule)*
        | pureExpr '(' (expr (COMMA expr)*)? ')'
        | <assoc = right> pureExpr op = ('**' | '!**') pureExpr
        | pureExpr op = ('*' | '/') pureExpr
        | pureExpr op = ('+' | '-') pureExpr
        | pureExpr op = ('<' | '<=' | '>' | '>=' | '==' | '!=') pureExpr
        | pureExpr op = '&&' pureExpr
        | pureExpr op = '||' pureExpr
        | <assoc = right> pureExpr QUESTION pureExpr COLON pureExpr
        | INT
        | FLOAT
        | BOOLEAN
        | STRING
        | NONE
        | ID
        | '(' pureExpr ')'
        | LBRACK elements? RBRACK
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
