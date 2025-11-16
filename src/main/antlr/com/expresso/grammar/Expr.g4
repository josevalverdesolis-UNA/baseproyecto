// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

grammar Expr;

prog: stat* EOF;

stat:
      LET ID (COLON type)? '=' expr (NEWLINE | EOF)?
    | FUN ID '(' arguments? ')' (COLON type)? '=' expr (NEWLINE | EOF)?
    | DATA ID '=' dataAlts (NEWLINE | EOF)?
    | PRINT '(' expr ')' (NEWLINE | EOF)?
    | expr NEWLINE
    | NEWLINE
    ;

arguments: param (COMMA param)*;
param: ID (COLON type)?;

argumentList: expr (COMMA expr)*;

dataAlts: dataAlt (PIPE dataAlt)*;
dataAlt: ID ('(' typeList? ')')?;
typeList: type (COMMA type)*;

elements: expr (COMMA expr)*;

expr
    : lambdaExpr
    | ternaryExpr
    ;

lambdaExpr
    : '(' arguments? ')' ARROW expr
    | ID (COLON type)? ARROW expr
    ;

ternaryExpr
    : logicalOr (QUESTION expr COLON expr)?
    ;

logicalOr
    : logicalAnd ( '||' logicalAnd )*
    ;

logicalAnd
    : equality ( '&&' equality )*
    ;

equality
    : comparison ( ('==' | '!=') comparison )*
    ;

comparison
    : additive ( ('<' | '<=' | '>' | '>=') additive )*
    ;

additive
    : multiplicative ( ('+' | '-') multiplicative )*
    ;

multiplicative
    : unary ( ('*' | '/' | '%') unary )*
    ;

unary
    : '!' unary
    | '-' unary
    | '^' constructor_call
    | postfix
    ;

postfix
    : funcCall
    | primary
    ;

funcCall
    : primary '(' argumentList? ')' ( '(' argumentList? ')' )*
    ;

primary
    : literal
    | ID
    | listLiteral
    | matchExpr
    | tupleLiteral
    | '(' expr ')'
    ;

literal
    : INT
    | FLOAT
    | BOOLEAN
    | STRING
    | NONE
    ;

listLiteral: LBRACK elements? RBRACK;

tupleLiteral: '(' expr (COMMA expr)+ ')';

matchExpr
    : MATCH expr WITH NEWLINE* matchArm (NEWLINE* matchArm)*
    ;

matchArm: PIPE pattern guard? ARROW expr;

guard: IF expr;

pattern: data_pattern | native_pattern | UNDERSCORE;

data_pattern: ID ('(' pattern_params? ')')?;
pattern_params: pattern (COMMA pattern)*;

native_pattern
    : NONE
    | BOOLEAN
    | STRING
    | INT
    | FLOAT
    | ID
    ;

constructor_call: ID '(' params? ')' | ID;
params: expr (COMMA expr)*;

type
    : typeNoArrow (ARROW type)?
    ;

typeNoArrow
    : atomic
    | '(' type (COMMA type)+ ')'
    | '(' type ')'
    ;

atomic
    : ANY
    | VOID
    | INT_TYPE
    | FLOAT_TYPE
    | STRING_TYPE
    | BOOLEAN_TYPE
    | ID
    ;

DATA: 'data';
FUN: 'fun';
LET: 'let';
PRINT: 'print';
IF: 'if';
MATCH: 'match';
WITH: 'with';
ANY: 'any';
VOID: 'void';
INT_TYPE: 'int';
FLOAT_TYPE: 'float';
STRING_TYPE: 'string';
BOOLEAN_TYPE: 'boolean';
BOOLEAN: 'true' | 'false';
NONE: 'none';
UNDERSCORE: '_';

ID: [a-zA-Z_][a-zA-Z0-9_]*;

FLOAT: [0-9]+ '.' [0-9]* | '.' [0-9]+;
INT: [0-9]+;
STRING: '"' (~["\\\r\n] | '\\' .)* '"';

LBRACE: '{';
RBRACE: '}';
LBRACK: '[';
RBRACK: ']';
COMMA: ',';
QUESTION: '?';
COLON: ':';
ARROW: '->';
PIPE: '|';

WS: [ \t]+ -> skip;
NEWLINE: ('\r'? '\n');
LINECOMMENT: '//' ~[\r\n]* -> channel(HIDDEN);
BLOCKCOMMENT: '/*' .*? '*/' -> channel(HIDDEN);
