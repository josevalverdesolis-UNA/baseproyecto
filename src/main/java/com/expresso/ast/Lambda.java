// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.List;

/*
 * Lambda was changed from Lambda(String parameter, Node body) to
 * Lambda(List<Argument> parameters, Node body) to support multiple parameters and
 * optional type annotations per parameter.
 */
public record Lambda(List<Argument> parameters, Node body) implements Node {
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
            case 1 -> formatParameter(parameters.get(0));
            default -> parameters.stream()
                    .map(this::formatParameter)
                    .reduce((a, b) -> a + ", " + b)
                    .map(vals -> "(" + vals + ")")
                    .orElse("()");
        };
        return paramList + " -> " + body;
    }

    private String formatParameter(Argument argument) {
        String name = argument.name() != null ? argument.name() : "_";
        if (argument.type() == null) {
            return name;
        }
        return name + ":" + argument.type();
    }
}
