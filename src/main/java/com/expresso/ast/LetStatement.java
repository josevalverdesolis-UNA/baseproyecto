// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.List;

public record LetStatement(String varName, TypeNode declaredType, Node expression) implements Node {
    //--------------------------------------------------------------
    // Getters
    //--------------------------------------------------------------
    @Override
    public Object getHead() {
        return "Let: " + varName + (declaredType != null ? (":" + declaredType) : "");
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
        String typeStr = declaredType != null ? ": " + declaredType : "";
        return "let " + varName + typeStr + " = " + expression;
    }
}
