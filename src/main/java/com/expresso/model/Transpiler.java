// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.model;

import java.util.Objects;

/*
 * This class works as abstract configuration for the transpiler.
 */
public record Transpiler(String inputFile, String outputPath, boolean verbose, boolean showTree, boolean showTrees, boolean printTree, boolean printTrees) {

    public Transpiler{
        Objects.requireNonNull(inputFile);
        Objects.requireNonNull(outputPath);
    }
    
}
