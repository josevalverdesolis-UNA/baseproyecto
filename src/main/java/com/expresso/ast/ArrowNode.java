// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.List;

/*
 * Represents a function type (input -> output) in the AST.
 * Used when declaring or checking types of lambdas and functions.
 */
public record ArrowNode(TypeNode inputType, TypeNode returnType) implements TypeNode {
    // --------------------------------------------------------------
    // Implementation of Node interface
    // --------------------------------------------------------------
    @Override
    public Object getHead() {
        return "ArrowType";
    }

    @Override
    public List<Node> getChildren() {
        return List.of(inputType, returnType);
    }
}
