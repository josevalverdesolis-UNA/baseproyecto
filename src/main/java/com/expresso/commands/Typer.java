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
// Command to run the Typer phase only and generate .typings
// ----------------------------------------------------------------------------
@Command(name = "typer", description = "Run the Typer phase and generate the .typings file", version = "1.0.0")
public class Typer implements Callable<Integer> {

    @Parameters(description = ".expresso file to type-check")
    private String expressoFile;

    @Option(names = { "--out",
            "--output" }, description = "Output directory for generated files (unused by typer)", defaultValue = "")
    private String outputDir;

    @Option(names = { "--verbose" }, description = "Enable verbose/detailed output")
    private boolean verbose;

    @Option(names = { "--showTree" }, description = "Show Custom AST tree before type checking")
    private boolean showTree;

    @Option(names = { "--showTrees" }, description = "Show Custom AST and ANTLR Parse trees before type checking")
    private boolean showTrees;

    @Option(names = { "--printTree" }, description = "Print Custom AST tree to console")
    private boolean printTree;

    @Option(names = { "--printTrees" }, description = "Print Custom AST and ANTLR Parse trees to console")
    private boolean printTrees;

    @Override
    public Integer call() {
        Transpiler config = new Transpiler(expressoFile, outputDir, verbose, showTree, showTrees, printTree,
                printTrees);
        return Pipeline.typeCheck(config) ? 0 : 1;
    }
}
