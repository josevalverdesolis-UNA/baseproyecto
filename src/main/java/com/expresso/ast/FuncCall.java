// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.List;
import java.util.stream.Collectors;

/*
 * Represents a function call. Stores the function being called and the list of arguments passed to it.
 */
public record FuncCall(Node funcName, List<Node> arguments) implements Node {
    // --------------------------------------------------------------
    // Getters
    // --------------------------------------------------------------
    @Override
    public Object getHead() {
        return "Call: " + funcName;
    }

    @Override
    public List<Node> getChildren() {
        return arguments;
    }

    // --------------------------------------------------------------
    // Methods
    // --------------------------------------------------------------
    @Override
    public String toString() {
        String args = arguments.stream()
                .map(Node::toString)
                .collect(Collectors.joining(", "));
        return funcName.toString() + "(" + args + ")";
    }
}
