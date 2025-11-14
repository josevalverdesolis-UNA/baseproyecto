// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a constructor in a data type declaration.
 * Example: S(n:nat) or Zero
 */
public record Constructor(String name, List<Argument> arguments) implements Node {
    // --------------------------------------------------------------
    // Implementation of Node interface
    // --------------------------------------------------------------
    @Override
    public Object getHead() {
        return "Constructor: " + name;
    }

    @Override
    public List<Node> getChildren() {
        List<Node> children = new ArrayList<>();
        arguments.forEach(arg -> {
            if (arg.type() != null) {
                children.add(arg.type());
            }
        });
        return children;
    }

    // --------------------------------------------------------------
    // Methods
    // --------------------------------------------------------------
    @Override
    public String toString() {
        if (arguments.isEmpty()) {
            return name;
        }
        return name + "(" +
                String.join(", ", arguments.stream()
                        .map(Argument::toString)
                        .toList())
                + ")";
    }
}
