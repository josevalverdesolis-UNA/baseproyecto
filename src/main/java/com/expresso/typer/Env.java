// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.typer;

import java.util.HashMap;
import java.util.Map;

import com.expresso.ast.TypeNode;

public class Env {
    private final Env parent; // Parent environment for nested scopes (boxes)
    private final Map<String, TypeNode> locals; // Local variable

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------
    public Env(Env parent) {
        this.parent = parent;
        this.locals = new HashMap<>();
    }

    // -------------------------------------------------------------------------
    // Methods
    // -------------------------------------------------------------------------

    // Add a new variable to the environment
    public void define(String name, TypeNode type) {
        locals.put(name, type);
    }

    // Find a variable in the environment
    public TypeNode find(String name) {
        if (locals.containsKey(name))
            return locals.get(name);
        if (parent != null)
            return parent.find(name);
        return null;
    }

    // Check if a variable exists in the environment
    public boolean has(String name) {
        // Check in the local box/environment
        if (locals.containsKey(name))
            return true;

        // If not found and there's a parent env, check there
        if (parent != null)
            return parent.has(name);

        return false; // Not found anywhere
    }
}
