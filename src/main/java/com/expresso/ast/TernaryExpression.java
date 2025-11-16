// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Represents a conditional expression like `condition ? trueBranch :
 * falseBranch`.
 * <p>
 * This record stores the three parts of a ternary expression:
 * the `condition` to be checked, the `trueBranch` to execute if the condition
 * is true, and the `falseBranch` to execute if it's false.
 */
public record TernaryExpression(
        Node condition,
        Node trueBranch,
        Node falseBranch) implements Node {

    public TernaryExpression {
        // Ensures that none of the parts of the expression are missing.
        Objects.requireNonNull(condition, "condition");
        Objects.requireNonNull(trueBranch, "trueBranch");
        Objects.requireNonNull(falseBranch, "falseBranch");
    }

    /**
     * Returns a list of the three child nodes: the condition, true branch, and
     * false branch.
     * This is useful for code that needs to process all parts of the expression.
     */
    @Override
    public List<Node> getChildren() {
        return Arrays.asList(condition, trueBranch, falseBranch);
    }

    /**
     * Returns the name of this node type for easy identification.
     */
    @Override
    public String getHead() {
        return "TernaryExpression";
    }

    /**
     * Returns a human-readable string representation of the ternary expression.
     */
    @Override
    public String toString() {
        return "(" + condition + " ? " + trueBranch + " : " + falseBranch + ")";
    }
}
