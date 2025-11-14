// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.visitors;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.expresso.ast.BinaryOp;
import com.expresso.ast.FuncCall;
import com.expresso.ast.Lambda;
import com.expresso.ast.LetStatement;
import com.expresso.ast.ListNode;
import com.expresso.ast.Node;
import com.expresso.ast.Num;
import com.expresso.ast.PrintStatement;
import com.expresso.ast.Program;
import com.expresso.ast.StringNode;
import com.expresso.ast.TernaryExpression;
import com.expresso.ast.UnaryOp;
import com.expresso.ast.Variable;

public class AstEvaluator {

    public static Object evaluate(Node n) {
        return switch (n) {
            // Pattern matching for different node types

            // Program node: a list of non null statements
            case Program(var statements) -> statements.stream()
                    .map(AstEvaluator::evaluate)
                    .filter(Objects::nonNull)
                    .toList();

            // Num node: a numeric value
            case Num(var value) -> value;

            // String node
            case StringNode(var value) -> value;

            // Variable node
            case Variable(var name) -> throw new RuntimeException("Variable no resuelta: " + name);

            // List node
            case ListNode(var elements) -> elements.stream()
                    .map(AstEvaluator::evaluate)
                    .toList();
            // Binary operation: + - * / ** !**
            case BinaryOp(var operator, var left, var right) -> {
                Object leftNode = evaluate(left);
                Object rightNode = evaluate(right);

                // Concatenate lists with +
                if (leftNode instanceof List<?> leftList && rightNode instanceof List<?> rightList
                        && operator.equals("+")) {
                    List<Object> result = new ArrayList<>(leftList);
                    result.addAll(rightList);
                    yield result; // Yield is necessary to return a value in switch expression blocks
                }

                double leftVal = convertToDouble(leftNode);
                double rightVal = convertToDouble(rightNode);

                yield switch (operator) {
                    case "+" -> safeNumericResult(leftVal + rightVal);
                    case "-" -> safeNumericResult(leftVal - rightVal);
                    case "*" -> safeNumericResult(leftVal * rightVal);
                    case "/" -> {
                        if (rightVal == 0)
                            throw new ArithmeticException("Division by zero");
                        yield safeNumericResult(leftVal / rightVal);
                    }
                    case "**" -> safeNumericResult(Math.pow(leftVal, rightVal));
                    case "!**" ->
                        safeNumericResult(Math.pow(convertToDouble(leftVal), (1.0 / convertToDouble(rightVal)))); // Nth
                                                                                                                  // root.
                                                                                                                  // Use
                                                                                                                  // 1.0
                                                                                                                  // to
                                                                                                                  // ensure
                                                                                                                  // floating
                                                                                                                  // point
                                                                                                                  // division
                    default -> throw new RuntimeException("Unknown operator: " + operator);
                };
            }

            // Ternary expression (short-circuit): condition ? trueBranch : falseBranch
            case TernaryExpression(var condition, var trueBranch, var falseBranch) -> {
                // Evaluate condition first and interpret as integer: non-zero -> true, zero ->
                // false
                int condInt = (int) convertToDouble(evaluate(condition));
                if (condInt != 0) {
                    // Lazy: evaluate only the true branch
                    yield evaluate(trueBranch);
                } else {
                    // Lazy: evaluate only the false branch
                    yield evaluate(falseBranch);
                }
            }

            // Unary operation
            case UnaryOp(var operator, var expr) -> {
                double val = convertToDouble(evaluate(expr));

                yield switch (operator) {
                    case "+" -> safeNumericResult(+val);
                    case "-" -> safeNumericResult(-val);
                    default -> throw new RuntimeException("Unknown unary operator: " + operator);
                };
            }

            // Print statement
            case PrintStatement(var expr) -> {
                Object value = evaluate(expr);
                System.out.println(value);

                yield value;
            }

            // Let statement (variable assignment)
            case LetStatement(var varName, var declaredType, var expr) -> evaluate(expr);

            // Lambda (function definition)
            case Lambda(var parameter, var body) -> n; // Just returns the node for functions, application
                                                       // implementation aside

            // Function call
            case FuncCall(var funcName, var args) -> {
                List<Object> evaluatedArgs = args.stream()
                        .map(AstEvaluator::evaluate)
                        .toList();
                throw new RuntimeException("FuncCall no implementado aún: " + funcName);
            }

            // Default case for unknown nodes
            default -> throw new RuntimeException("Unknown node type: " + n.getClass());
        };
    }

    // --------------------------------------------------------------
    // Auxiliary Methods
    // --------------------------------------------------------------

    // Convert to double or throw
    private static double convertToDouble(Object value) {
        if (value instanceof Number number)
            return number.doubleValue();
        throw new RuntimeException("Expected numeric value, got: " + value);
    }

    // Return int if no decimal part, else double
    private static Object safeNumericResult(double value) {
        if (value == (int) value)
            return (int) value;
        return value;
    }

}