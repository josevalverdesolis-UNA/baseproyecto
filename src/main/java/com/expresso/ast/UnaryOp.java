// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.List;

public record UnaryOp(String operator, Node expression) implements Node {
    //--------------------------------------------------------------
    // Getters
    //--------------------------------------------------------------
    @Override
    public Object getHead() {
        return "UnaryOp: " + operator;
    }

    @Override
    public List<Node> getChildren() {
        return List.of(expression);
    }

    //--------------------------------------------------------------
    // Methods
    //--------------------------------------------------------------
    @Override
    public String toString() {
        return operator() + "(" + expression() + ")";
    }
}
