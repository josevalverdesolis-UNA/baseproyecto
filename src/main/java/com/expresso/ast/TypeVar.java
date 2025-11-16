// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.List;
import java.util.Objects;

/**
 * Represents a type variable used during type inference
 */
public final class TypeVar implements TypeNode {
    private final String name;

    public TypeVar(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public String name() {
        return name;
    }

    @Override
    public Object getHead() {
        return "TypeVar(" + name + ")";
    }

    @Override
    public List<Node> getChildren() {
        return List.of();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        TypeVar other = (TypeVar) obj;
        return name.equals(other.name);
    }
}
