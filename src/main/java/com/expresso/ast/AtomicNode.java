// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.List;

/*
 * Represents a simple type name (like int, string, boolean, etc).
 * The most basic types in the AST.
 */
public record AtomicNode(String name) implements TypeNode {
    // --------------------------------------------------------------
    // Implementation of Node interface
    // --------------------------------------------------------------
    @Override
    public Object getHead() {
        return name;
    }

    @Override
    public List<Node> getChildren() {
        return List.of(); // No children
    }
}
