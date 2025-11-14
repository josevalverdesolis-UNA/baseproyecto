// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.List;

/**
 * Represents a constructor instantiation using the '^' operator.
 * Example: ^Cons(666, ^Nil)
 */
public record InstantiatorNode(String constructorName, List<Node> arguments) implements Node {
    @Override
    public Object getHead() {
        return "New: " + constructorName;
    }

    @Override
    public List<Node> getChildren() {
        return arguments;
    }
}
