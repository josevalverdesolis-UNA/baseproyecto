// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

public record StringNode(String value) implements Node {
    //--------------------------------------------------------------
    // Implementation of Node interface
    //--------------------------------------------------------------
    @Override
    public Object getHead() {
        return "String: " + value;
    }

    @Override
    public java.util.List<Node> getChildren() {
        return java.util.List.of(); // No children
    }
}
