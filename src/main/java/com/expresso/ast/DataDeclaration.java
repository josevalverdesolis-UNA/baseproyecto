// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a data type declaration in Expresso.
 * Example: data nat = { Zero, S(n:nat) }
 */
public record DataDeclaration(String typeName, List<Constructor> constructors) implements Node {
    // --------------------------------------------------------------
    // Implementation of Node interface
    // --------------------------------------------------------------
    @Override
    public Object getHead() {
        return "Data: " + typeName;
    }

    @Override
    public List<Node> getChildren() {
        return new ArrayList<>(constructors);
    }

    // --------------------------------------------------------------
    // Methods
    // --------------------------------------------------------------
    @Override
    public String toString() {
        return "data " + typeName + " = { " +
                String.join(", ", constructors.stream()
                        .map(Constructor::toString)
                        .toList())
                + " }";
    }
}
