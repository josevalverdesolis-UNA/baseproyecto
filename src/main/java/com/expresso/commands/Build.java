// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.commands;

import java.util.concurrent.Callable;

import com.expresso.Pipeline;
import com.expresso.model.Transpiler;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

// ----------------------------------------------------------------------------
// Command to transpile Expresso to Java
// ----------------------------------------------------------------------------
@Command(
    name = "build",
    description = "Transpile and build the project",
    version = "1.0.0"
)
public class Build implements Callable<Integer>{
    // ----------------------------------------------------------------------------
    // Parameters
    // ----------------------------------------------------------------------------
    @Parameters(description = ".expresso file to transpile")
    private String expressoFile;

    @Option(names = {"--out", "--output"}, description= "Output directory for the generated Java files", defaultValue="")
    private String outputDir;

    @Option(names = {"--verbose"}, description = "Enable verbose/detailed output")
    private boolean verbose;

    @Option(names = {"--showTree"}, description = "Show Custom AST tree")
    private boolean showTree;

    @Option(names = {"--showTrees"}, description = "Show Custom AST and ANTLR Parse trees")
    private boolean showTrees;

    @Option(names = {"--printTree"}, description = "Print Custom AST tree to console")
    private boolean printTree;

    @Option(names = {"--printTrees"}, description = "Print Custom AST and ANTLR Parse trees to console")
    private boolean printTrees;

    // ----------------------------------------------------------------------------
    // Override
    // ----------------------------------------------------------------------------
    @Override
    public Integer call() {
        Transpiler config = new Transpiler(expressoFile, outputDir, verbose, showTree, showTrees, printTree, printTrees);
        return Pipeline.build(config) ? 0 : 1;
    }
}
