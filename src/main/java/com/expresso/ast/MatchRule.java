// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single rule in a match expression.
 * Example: Cons(f, _) -> f or pattern guard -> expr
 */
public record MatchRule(Pattern pattern, Node guard, Node expression) implements Node {
    // --------------------------------------------------------------
    // Implementation of Node interface
    // --------------------------------------------------------------
    @Override
    public Object getHead() {
        return "Rule";
    }

    @Override
    public List<Node> getChildren() {
        List<Node> children = new ArrayList<>();
        children.add(pattern);
        if (guard != null) {
            children.add(guard);
        }
        children.add(expression);
        return children;
    }

    // --------------------------------------------------------------
    // Methods
    // --------------------------------------------------------------
    @Override
    public String toString() {
        String guardStr = guard != null ? " if " + guard : "";
        return pattern + guardStr + " -> " + expression;
    }
}
