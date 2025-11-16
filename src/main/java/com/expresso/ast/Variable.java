// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.Collections;
import java.util.List;

// This class represents the ID of the AST Grammar
public record Variable(String name) implements Node {
    //--------------------------------------------------------------
    // Getters
    //--------------------------------------------------------------
    @Override
    public Object getHead() {
        return "Variable: " + name;
    }

    @Override
    public List<Node> getChildren() {
        return Collections.emptyList();
    }
}
