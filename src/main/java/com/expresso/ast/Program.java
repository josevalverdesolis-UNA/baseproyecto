// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.List;

/*
 * This class is the equivalent of Program in ast.mjs
 * A Program node contains a list of statements.
 * The head is null.
 */
public record Program(List<Node> statements) implements Node {
    //--------------------------------------------------------------
    // Getters
    //--------------------------------------------------------------
    @Override
    public Object getHead() {
        return "Program";
    }

    @Override
    public List<Node> getChildren() {
        return statements;
    }
    
    //--------------------------------------------------------------
    // Methods
    //--------------------------------------------------------------
    @Override
    public String toString() {
        return statements.stream()
                .map(Node::toString)
                .filter(s -> !s.isEmpty())
                .reduce((a, b) -> a + "; " + b)
                .orElse("");
    }

    //--------------------------------------------------------------
    // Auxiliary Methods
    //--------------------------------------------------------------
    public int size() {
        return statements.size();
    }

    public boolean isEmpty() {
        return statements.isEmpty();
    }
}
