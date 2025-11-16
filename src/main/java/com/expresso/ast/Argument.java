// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

/**
 * Represents an argument in a constructor or function.
 * Example: n:nat or just :int (unnamed)
 */
public record Argument(String name, TypeNode type) {
    
    @Override
    public String toString() {
        if (name != null && !name.isEmpty()) {
            return name + ":" + type;
        }
        return type.toString();
    }
}
