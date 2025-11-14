// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.List;

public record TupleNode(List<TypeNode> elements) implements TypeNode {
    // --------------------------------------------------------------
    // Implementation of Node interface
    // --------------------------------------------------------------
    @Override
    public Object getHead() {
        return "TupleType";
    }

    @Override
    public List<Node> getChildren() {
        return List.copyOf(elements);
    }
}
