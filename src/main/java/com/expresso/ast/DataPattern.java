// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a data pattern in a match expression.
 * Example: Cons(f, _) or Nil or S(n)
 */
public record DataPattern(String constructorName, List<DataPattern> params) implements Pattern {
    // --------------------------------------------------------------
    // Implementation of Node interface
    // --------------------------------------------------------------
    @Override
    public Object getHead() {
        return "DataPattern: " + constructorName;
    }

    @Override
    public List<Node> getChildren() {
        return new ArrayList<>(params);
    }

    // --------------------------------------------------------------
    // Methods
    // --------------------------------------------------------------
    @Override
    public String toString() {
        if (params.isEmpty()) {
            return constructorName;
        }
        return constructorName + "(" + 
               String.join(", ", params.stream()
                   .map(DataPattern::toString)
                   .toList()) + ")";
    }
}
