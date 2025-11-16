// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.visitors;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.expresso.ast.BinaryOp;
import com.expresso.ast.BooleanNode;
import com.expresso.ast.CastNode;
import com.expresso.ast.DataDeclaration;
import com.expresso.ast.FunNode;
import com.expresso.ast.FuncCall;
import com.expresso.ast.InstantiatorNode;
import com.expresso.ast.Lambda;
import com.expresso.ast.LetStatement;
import com.expresso.ast.ListNode;
import com.expresso.ast.MatchExpression;
import com.expresso.ast.Node;
import com.expresso.ast.NoneNode;
import com.expresso.ast.Num;
import com.expresso.ast.PrintStatement;
import com.expresso.ast.Program;
import com.expresso.ast.StringNode;
import com.expresso.ast.TernaryExpression;
import com.expresso.ast.UnaryOp;
import com.expresso.ast.Variable;
import com.expresso.features.Feature;

/*
 * FeatureCollector class to collect features used in the AST
 * Features include: PRINT, POW, LAMBDA, LIST, FUNCTIONAL, TERNARY
 */
public class FeatureCollector {

    public static Set<Feature> collect(Node node) {
        return switch (node) {

            // Program node: collect features from all statements
            case Program(var statements) -> {
                Set<Feature> features = new HashSet<>(); // HashSet is a list to avoid duplicates

                for (Node stmt : statements) {
                    features.addAll(collect(stmt));
                }

                yield features;
            }

            // Print Statement
            case PrintStatement _ -> Set.of(Feature.PRINT);

            // Binary Operation
            case BinaryOp(var operator, var left, var right) -> {
                Set<Feature> features = new HashSet<>();

                features.addAll(collect(left));
                features.addAll(collect(right));

                if ("**".equals(operator) || "!**".equals(operator)) {
                    features.add(Feature.POW);
                }
                yield features;
            }

            // Ternary Expression: cond ? true : false
            case TernaryExpression(var condition, var trueBranch, var falseBranch) -> {
                Set<Feature> features = new HashSet<>();

                // Recursive collection on the three sub-expressions
                features.addAll(collect(condition));
                features.addAll(collect(trueBranch));
                features.addAll(collect(falseBranch));

                // Register presence of the ternary conditional operator
                features.add(Feature.TERNARY); // Feature enum must include: TERNARY (Ternary conditional operator: cond
                                               // ? a : b)

                yield features;
            }

            // Lambda
            case Lambda(var param, var body) -> {
                Set<Feature> features = new HashSet<>();

                features.add(Feature.LAMBDA);
                features.addAll(collect(body));

                yield features;
            }

            // List Node
            case ListNode(var elements) -> {
                Set<Feature> features = new HashSet<>();

                features.add(Feature.LIST);

                for (Node elem : elements) {
                    features.addAll(collect(elem));
                }

                yield features;
            }

            // Function Call
            case FuncCall(var funcName, var args) -> {
                Set<Feature> features = new HashSet<>();

                features.add(Feature.FUNCTIONAL);

                for (Node arg : args) {
                    features.addAll(collect(arg));
                }

                yield features;
            }

            // Unary Operation
            case UnaryOp(var operator, var expr) -> collect(expr);

            // Num
            case Num _ -> Collections.emptySet();

            // StringNode
            case StringNode _ -> Collections.emptySet();

            // Variable
            case Variable _ -> Collections.emptySet();

            // Let Statement
            case LetStatement(var varName, var declaredType, var expr) -> collect(expr);

            // Fun Node (function declarations)
            case FunNode(var name, var params, var returnType, var body) -> {
                Set<Feature> features = new HashSet<>();
                features.add(Feature.FUNCTIONAL);
                features.addAll(collect(body));
                yield features;
            }

            // Data Declaration (sealed interfaces + records)
            case DataDeclaration _ -> Set.of(Feature.DATA_TYPES);

            // Instantiator (^Constructor)
            case InstantiatorNode(var name, var args) -> {
                Set<Feature> features = new HashSet<>();
                features.add(Feature.DATA_TYPES);
                for (Node arg : args) {
                    features.addAll(collect(arg));
                }
                yield features;
            }

            // Match Expression (pattern matching)
            case MatchExpression(var expr, var rules) -> {
                Set<Feature> features = new HashSet<>();
                features.add(Feature.PATTERN_MATCHING);
                features.addAll(collect(expr));
                // Note: we don't need to collect from rules' patterns/guards/expressions
                // as those will be handled recursively if needed
                yield features;
            }

            // Boolean Node
            case BooleanNode _ -> Collections.emptySet();

            // None Node
            case NoneNode _ -> Collections.emptySet();

            // Cast Node
            case CastNode(var expr, var targetType) -> collect(expr);

            // Default case: unsupported node type
            default -> throw new RuntimeException("Unsupported node: " + node);
        };
    }
}
