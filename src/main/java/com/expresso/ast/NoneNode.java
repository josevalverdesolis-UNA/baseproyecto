// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.Collections;
import java.util.List;

/**
 * Represents the 'none' constant in the AST.
 * It transpiles to null in Java.
 * Example:
 */
public record NoneNode() implements Node {

    @Override
    public Object getHead() {
        return "None";
    }

    @Override
    public List<Node> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public String toString() {
        return "None";
    }
}
