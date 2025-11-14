// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;

import com.expresso.ast.Program;
import com.expresso.grammar.ExprLexer;
import com.expresso.grammar.ExprParser;
import com.expresso.visitors.AstBuilder;
import com.expresso.visitors.NodeParseTreeAdapter;

public class Utils {
    
    // --------------------------- 
    // File Operations
    // --------------------------- 
    public static Optional<Path> prepareFile(String inputFile, String outputDir, Function<String, String> logger) {
        log(logger.apply("Preparing file paths..."));
        
        Path input = Paths.get(inputFile);
        if (!Files.exists(input)) {
            logError("File does not exist: " + inputFile);
            return Optional.empty();
        }
        
        Path output = outputDir.isEmpty() ? Paths.get(".") : Paths.get(outputDir);
        try {
            Files.createDirectories(output);
        } catch (IOException e) {
            logError("Error creating output directory: " + e.getMessage());
            return Optional.empty();
        }
        
        log(logger.apply("Input file: " + input + ", Output dir: " + output));
        return Optional.of(input);
    }
    
    public static Optional<String> readExpressoFile(Path path, Function<String, String> logger) {
        try {
            String content = Files.readString(path);
            log(logger.apply("Read " + content.length() + " chars from " + path));
            return Optional.of(content);
        } catch (IOException e) {
            logError("Error reading file: " + e.getMessage());
            return Optional.empty();
        }
    }
    
    public static boolean writeJavaFile(String javaCode, String outputDir, String inputFile, Function<String, String> logger) {
        String className = extractFileName(inputFile);
        Path outputPath = Paths.get(outputDir, className + ".java");
        
        try {
            Files.writeString(outputPath, javaCode);
            log(logger.apply("Java code written to: " + outputPath));
            return true;
        } catch (IOException e) {
            logError("Error writing Java file: " + e.getMessage());
            return false;
        }
    }

    //---------------------------
    // Logs
    //---------------------------
    // Logs a message.
    public static void log(String message)
    {
        Optional.ofNullable(message).ifPresent(msg -> System.out.println(msg));
    }

    // Logs an error message.
    public static void logError(String message)
    {
        Optional.ofNullable(message).ifPresent(msg -> System.err.println(msg));
    }

    // Logs a message if verbose mode is enabled.
    public static Function<String, String> logIfVerbose(String prefix, boolean verbose)
    {
        return message -> (verbose ? prefix + " -> " + message : null);
    }
    
    // --------------------------- 
    // AST Operations
    // --------------------------- 
    public static Optional<Program> parseAST(String content, Function<String, String> logger) {
        try {
            var lexer = new ExprLexer(CharStreams.fromString(content));
            var tokens = new CommonTokenStream(lexer);
            var parser = new ExprParser(tokens);
            var tree = parser.prog();
            
            Program ast = (Program) new AstBuilder().visit(tree);
            log(logger.apply("AST created with " + ast.size() + " statements"));
            
            return Optional.of(ast);
        } catch (Exception e) {
            logError("Parse error: " + e.getMessage());
            return Optional.empty();
        }
    }
    
    public static Optional<Program> parseFileToAST(String filePath, Function<String, String> logger) {
        try {
            Path path = Paths.get(filePath);
            if (!Files.exists(path)) {
                logError("File does not exist: " + filePath);
                return Optional.empty();
            }
            
            String content = Files.readString(path);
            log(logger.apply("Reading file: " + filePath));
            return parseAST(content, logger);
        } catch (IOException e) {
            logError("Error reading file: " + filePath + " - " + e.getMessage());
            return Optional.empty();
        }
    }
    
    public static Optional<Program> parseStringToAST(String source, Function<String, String> logger) {
        log(logger.apply("Parsing string content"));
        return parseAST(source, logger);
    }
    
    public static Optional<ParseTreeResult> parseASTWithTree(String content, Function<String, String> logger) {
        try {
            var lexer = new ExprLexer(CharStreams.fromString(content));
            var tokens = new CommonTokenStream(lexer);
            var parser = new ExprParser(tokens);
            var tree = parser.prog();
            
            Program ast = (Program) new AstBuilder().visit(tree);
            tokens.fill();
            log(logger.apply("AST created with " + ast.size() + " statements"));
            
            return Optional.of(new ParseTreeResult(ast, tree, parser, tokens));
        } catch (Exception e) {
            logError("Parse error: " + e.getMessage());
            return Optional.empty();
        }
    }
    
    // --------------------------- 
    // Compilation Operations
    // --------------------------- 
    public static boolean compileJava(String outputDir, String inputFile, Function<String, String> logger) {
        Path javaFile = Paths.get(outputDir, extractFileName(inputFile) + ".java");
        
        try {
            javax.tools.JavaCompiler compiler = javax.tools.ToolProvider.getSystemJavaCompiler();
            int result = compiler.run(null, null, null, javaFile.toString(), "-d", outputDir);
            
            if (result == 0) {
                log(logger.apply("Compilation successful: " + javaFile));
                return true;
            } else {
                logError("Compilation failed: " + javaFile);
                return false;
            }
        } catch (Exception e) {
            logError("Compilation error: " + e.getMessage());
            return false;
        }
    }
    
    // --------------------------- 
    // Execution Operations
    // --------------------------- 
    public static boolean executeJavaClass(String outputDir, String inputFile, Function<String, String> logger) {
        String className = extractFileName(inputFile);
        Path classFile = Paths.get(outputDir, className + ".class");
        
        if (!Files.exists(classFile)) {
            logError("Class file does not exist: " + classFile);
            return false;
        }
        
        try {
            log(logger.apply("Executing Java class: " + className));
            
            ProcessBuilder processBuilder = new ProcessBuilder(
                "java", "-cp", outputDir, className
            );
            processBuilder.inheritIO(); // This will output directly to console
            
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            
            if (exitCode == 0) {
                log(logger.apply("Execution completed successfully"));
                return true;
            } else {
                logError("Execution failed with exit code: " + exitCode);
                return false;
            }
        } catch (Exception e) {
            logError("Execution error: " + e.getMessage());
            return false;
        }
    }
    
    // --------------------------- 
    // Tree Visualization
    // ---------------------------   
    public static void showCustomAST(Program ast) {
        final Object lock = new Object();
        
        SwingUtilities.invokeLater(() -> {
            NodeParseTreeAdapter adapter = new NodeParseTreeAdapter(ast);
            TreeViewer viewer = new TreeViewer(List.of("CustomAST"), adapter);
            viewer.setScale(1.2);
            
            JScrollPane scrollPane = new JScrollPane(viewer);
            JFrame frame = new JFrame("Custom AST - TreeViewer");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(scrollPane);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override 
                public void windowClosed(java.awt.event.WindowEvent e) {
                    synchronized (lock) { 
                        lock.notify(); 
                    }
                }
            });
            frame.setVisible(true);
        });
        
        synchronized (lock) {
            try { 
                lock.wait(); 
            } catch (InterruptedException ignored) {}
        }
    }
    
    public static void showANTLRTree(ParseTree tree, Parser parser) {
        final Object lock = new Object();
        
        SwingUtilities.invokeLater(() -> {
            TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
            viewer.setScale(1.5);
            
            JScrollPane scrollPane = new JScrollPane(viewer);
            JFrame frame = new JFrame("ANTLR Parse Tree");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(scrollPane);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override 
                public void windowClosed(java.awt.event.WindowEvent e) {
                    synchronized (lock) {
                        lock.notify();
                    }
                }
            });
            frame.setVisible(true);
        });
        
        synchronized (lock) {
            try { 
                lock.wait(); 
            } catch (InterruptedException ignored) {}
        }
    }
    
    // --------------------------- 
    // Utility Methods
    // ---------------------------   
    public static String extractFileName(String file) {
        String name = Paths.get(file).getFileName().toString();
        int idx = name.lastIndexOf('.');
        name = idx > 0 ? name.substring(0, idx) : name;
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
    
    // --------------------------- 
    // Helper Records
    // --------------------------- 
    public record ParseTreeResult(Program ast, ParseTree parseTree, Parser parser, CommonTokenStream tokens) {}
}