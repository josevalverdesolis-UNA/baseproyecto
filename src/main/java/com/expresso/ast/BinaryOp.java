// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.List;

/*
 * Represents an operation with two operands like: +, -, *, /, ==, &&, etc.
 * Stores the operator symbol and the left and right expressions.
 * Like a binary tree node.
 */
public record BinaryOp(String operator, Node left, Node right) implements Node {
    // --------------------------------------------------------------
    // Getters
    // --------------------------------------------------------------
    @Override
    public Object getHead() {
        return "BinaryOp: " + operator;
    }

    @Override
    public List<Node> getChildren() {
        return List.of(left, right);
    }

    // --------------------------------------------------------------
    // Methods
    // --------------------------------------------------------------
    @Override
    public String toString() {
        String leftStr = left.toString();
        String rightStr = right.toString();

        if (left instanceof BinaryOp) {
            leftStr = "(" + leftStr + ")";
        }
        if (right instanceof BinaryOp) {
            rightStr = "(" + rightStr + ")";
        }

        return leftStr + " " + operator + " " + rightStr;
    }
}
