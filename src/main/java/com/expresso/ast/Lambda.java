// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.List;

/*
 * Lambda was changed from Lambda(String parameter, Node body) to
 * Lambda(List<String> parameters, Node body) to support multiple parameters.
 */
public record Lambda(List<String> parameters, Node body) implements Node {
    // --------------------------------------------------------------
    // Getters
    // --------------------------------------------------------------
    @Override
    public Object getHead() {
        return "Lambda(" + parameters.size() + " params)"; // Indicate number of parameters
    }

    @Override
    public List<Node> getChildren() {
        return List.of(body);
    }

    // --------------------------------------------------------------
    // Methods
    // --------------------------------------------------------------
    @Override
    public String toString() {
        String paramList = switch (parameters.size()) {
            case 0 -> "()";
            case 1 -> parameters.get(0);
            default -> "(" + String.join(", ", parameters) + ")";
        };
        return paramList + " -> " + body;
    }
}
