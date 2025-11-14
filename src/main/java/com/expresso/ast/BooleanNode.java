// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.Collections;
import java.util.List;

/*
 * Represents a boolean constant (true or false) in the AST.
 */
public record BooleanNode(boolean value) implements Node {

    @Override
    public Object getHead() {
        return "Boolean: " + value;
    }

    @Override
    public List<Node> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public String toString() {
        return "Boolean(" + value + ")";
    }
}
