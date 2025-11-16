// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.ArrayList;
import java.util.List;

public record FunNode(String name, List<Argument> parameters, TypeNode returnType, Node body) implements Node {
    // --------------------------------------------------------------
    // Implementation of Node interface
    // --------------------------------------------------------------
    @Override
    public Object getHead() {
        return name;
    }

    @Override
    public List<Node> getChildren() {
        List<Node> children = new ArrayList<>();

        if (returnType != null) {
            children.add(returnType);
        }
        children.add(body);

        return children;
    }
}
