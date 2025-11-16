// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.List;

/**
 * Represents a native pattern in a match expression.
 * Can be: none, boolean, string, numeric constant, or variable pattern
 */
public record NativePattern(PatternType type, Object value) implements Pattern {
    
    public enum PatternType {
        NONE,           // none
        BOOLEAN,        // true/false
        STRING,         // "hello"
        NUMERIC,        // 123, 3.14
        VARIABLE        // x, y, _ (wildcard)
    }

    // --------------------------------------------------------------
    // Implementation of Node interface
    // --------------------------------------------------------------
    @Override
    public Object getHead() {
        return "NativePattern: " + type;
    }

    @Override
    public List<Node> getChildren() {
        return List.of(); // Native patterns are leaf nodes
    }

    // --------------------------------------------------------------
    // Methods
    // --------------------------------------------------------------
    @Override
    public String toString() {
        return switch (type) {
            case NONE -> "none";
            case BOOLEAN -> String.valueOf(value);
            case STRING -> "\"" + value + "\"";
            case NUMERIC -> String.valueOf(value);
            case VARIABLE -> String.valueOf(value);
        };
    }

    /**
     * Helper method to check if this is a wildcard pattern (_)
     */
    public boolean isWildcard() {
        return type == PatternType.VARIABLE && "_".equals(value);
    }
}
