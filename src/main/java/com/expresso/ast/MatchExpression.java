// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a match expression in Expresso.
 * Example: match a with Nil -> none | Cons(f, _) -> f
 * Transpiles to Java switch pattern matching
 */
public record MatchExpression(Node expression, List<MatchRule> rules) implements Node {
    // --------------------------------------------------------------
    // Implementation of Node interface
    // --------------------------------------------------------------
    @Override
    public Object getHead() {
        return "Match";
    }

    @Override
    public List<Node> getChildren() {
        List<Node> children = new ArrayList<>();
        children.add(expression);
        children.addAll(rules);
        return children;
    }

    // --------------------------------------------------------------
    // Methods
    // --------------------------------------------------------------
    @Override
    public String toString() {
        return "match " + expression + " with " + 
               String.join(" | ", rules.stream()
                   .map(MatchRule::toString)
                   .toList());
    }
}
