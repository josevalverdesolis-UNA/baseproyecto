// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.List;

/*
 * This class is the equivalent of Num in ast.mjs
 */
public record Num(Double value) implements Node {
    //--------------------------------------------------------------
    // Implementation of Node interface
    //--------------------------------------------------------------
    @Override
    public Object getHead() {
        return "Num: " + value;
    }

    @Override
    public List<Node> getChildren() {
        return List.of(); // None children
    }
}
