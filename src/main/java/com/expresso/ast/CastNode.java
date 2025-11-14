// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.List;

/*
 * Represents a type cast (converting an expression to a specific type).
 * Example: (value : int) means "treat value as an int".
 */
public record CastNode(Node expression, TypeNode targetType) implements Node {

    @Override
    public Object getHead() {
        return "Cast → " + targetType;
    }

    @Override
    public List<Node> getChildren() {
        return List.of(expression);
    }

    @Override
    public String toString() {
        return "Cast(" + expression + " : " + targetType + ")";
    }
}
