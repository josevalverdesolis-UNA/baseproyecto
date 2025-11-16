// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import org.antlr.v4.runtime.CommonTokenStream;

import com.expresso.ast.Argument;
import com.expresso.ast.ArrowNode;
import com.expresso.ast.AtomicNode;
import com.expresso.ast.Constructor;
import com.expresso.ast.DataDeclaration;
import com.expresso.ast.FunNode;
import com.expresso.ast.LetStatement;
import com.expresso.ast.Program;
import com.expresso.ast.TupleNode;
import com.expresso.ast.TypeNode;
import com.expresso.features.Feature;
import com.expresso.model.Transpiler;
import com.expresso.typer.Env;
import com.expresso.typer.Typer;
import com.expresso.utils.Utils;
import com.expresso.utils.Utils.ParseTreeResult;
import com.expresso.visitors.AstEvaluator;
import com.expresso.visitors.AstTranspiler;
import com.expresso.visitors.FeatureCollector;

public class Pipeline {

    private static final String LIST_SENTINEL = "__list__";

    // --------------------------------------------------------------
    // Type Check: Validate types and generate .typings file
    // --------------------------------------------------------------
    public static boolean typeCheck(Transpiler config) {
        Function<String, String> logger = Utils.logIfVerbose("TYPE CHECK", config.verbose());
        Utils.log(logger.apply("Type checking..."));

        return Utils.prepareFile(config.inputFile(), config.outputPath(), logger)
                .flatMap(filePath -> Utils.readExpressoFile(filePath, logger))
                .flatMap(content -> processASTWithVisualization(content, logger, config))
                .map(result -> performTypeChecking(result.ast(), config.inputFile(), logger))
                .orElse(false);
    }

    // --------------------------------------------------------------
    // Transpile: Expresso -> Java
    // --------------------------------------------------------------
    public static boolean transpile(Transpiler config) {
        Function<String, String> logger = Utils.logIfVerbose("TRANSPILE", config.verbose());
        Utils.log(logger.apply("Transpiling AST to Java..."));

        return Utils.prepareFile(config.inputFile(), config.outputPath(), logger)
                .flatMap(filePath -> Utils.readExpressoFile(filePath, logger))
                .flatMap(content -> processASTWithVisualization(content, logger, config))
                .map(result -> transpileASTToJava(result.ast(), result.tokens(), config.outputPath(),
                        config.inputFile(), logger))
                .orElse(false);
    }

    // Shared typer for build workflow
    private static ThreadLocal<Typer> sharedTyper = new ThreadLocal<>();

    // --------------------------------------------------------------
    // Build: typeCheck + transpile + compile
    // --------------------------------------------------------------
    public static boolean build(Transpiler config) {
        Function<String, String> logger = Utils.logIfVerbose("BUILD", config.verbose());
        Utils.log(logger.apply("Building project..."));

        // IMPORTANT: Type check BEFORE transpiling. Suppress visualization here to
        // avoid showing AST/Parse trees twice when build/run is invoked with --showTree(s).
        Transpiler silentForTyper = new Transpiler(
                config.inputFile(),
                config.outputPath(),
                config.verbose(),
                false, // showTree
                false, // showTrees
                false, // printTree
                false // printTrees
        );

        try {
            return typeCheck(silentForTyper) &&
                    transpile(config) &&
                    Utils.compileJava(config.outputPath(), config.inputFile(), logger);
        } finally {
            sharedTyper.remove(); // Clean up
        }
    }

    // --------------------------------------------------------------
    // Run: build + execute
    ///-------------------------------------------------------------- 
    public static boolean run(Transpiler config) {
        Function<String, String> logger = Utils.logIfVerbose("RUN", config.verbose());
        Utils.log(logger.apply("Running project..."));

        return build(config) &&
                Utils.executeJavaClass(config.outputPath(), config.inputFile(), logger);
    }

    // --------------------------------------------------------------
    // Evaluate AST
    // --------------------------------------------------------------
    public static boolean evaluateAST(Transpiler config) {
        Function<String, String> logger = Utils.logIfVerbose("EVALUATE", config.verbose());
        Utils.log(logger.apply("Evaluating AST..."));

        return Utils.prepareFile(config.inputFile(), config.outputPath(), logger)
                .flatMap(filePath -> Utils.readExpressoFile(filePath, logger))
                .flatMap(content -> processASTWithVisualization(content, logger, config))
                .map(result -> evaluateAfterTyping(result.ast(), config.inputFile(), logger))
                .orElse(false);
    }

    // --------------------------------------------------------------
    // Helper Methods
    // --------------------------------------------------------------

    private static boolean performTypeChecking(Program ast, String inputFile, Function<String, String> logger) {
        try {
            Utils.log(logger.apply("#--- Starting type checking... ---#"));

            // Create a new typer with global environment
            Env globalEnv = new Env(null);
            Typer typer = new Typer(globalEnv);

            // Type visits all nodes
            typer.infer(ast);

            Utils.log(logger.apply("#--- Type checking successful ---#"));

            // Generate .typings file
            generateTypingsFile(ast, globalEnv, typer, inputFile, logger);

            sharedTyper.set(typer);

            return true;
        } catch (RuntimeException e) {
            Utils.logError("Type checking failed: " + e.getMessage());
            return false;
        }
    }

    private static boolean evaluateAfterTyping(Program ast, String inputFile, Function<String, String> logger) {
        if (!performTypeChecking(ast, inputFile, logger)) {
            return false;
        }
        try {
            Utils.log(logger.apply("#--- Evaluating AST... ---#"));
            Object result = AstEvaluator.evaluate(ast);
            System.out.println(result);
            Utils.log(logger.apply("#--- AST evaluated successfully ---#"));
            return true;
        } finally {
            sharedTyper.remove();
        }
    }

    // Generate the file .expresso.typings
    private static void generateTypingsFile(Program ast, Env env, Typer typer, String inputFile,
            Function<String, String> logger) {
        try {
            var inputPath = Paths.get(inputFile);
            var parent = inputPath.getParent();
            var baseName = inputPath.getFileName().toString(); // HelloWorld.expresso
            var typingsName = baseName + ".typings"; // HelloWorld.expresso.typings
            var outPath = (parent == null)
                    ? Paths.get(typingsName)
                    : parent.resolve(typingsName);

            StringBuilder sb = new StringBuilder();
            sb.append("# ").append(baseName).append("\n\n");

            for (var stmt : ast.statements()) {
                if (stmt instanceof DataDeclaration dd) {
                    String sum = dd.constructors().stream()
                            .map(Constructor::name)
                            .reduce((a, b) -> a + "|" + b)
                            .orElse("");
                    sb.append(dd.typeName()).append(": ").append(sum).append("\n");

                    // Each constructor line
                    for (Constructor c : dd.constructors()) {
                        String argsStr;
                        if (c.arguments().isEmpty()) {
                            argsStr = "void";
                        } else if (c.arguments().size() == 1) {
                            argsStr = typeToString(c.arguments().get(0).type());
                        } else {
                            String tuple = c.arguments().stream()
                                    .map(Argument::type)
                                    .map(Pipeline::typeToString)
                                    .reduce((a, b) -> a + ", " + b)
                                    .orElse("");
                            argsStr = "(" + tuple + ")";
                        }
                        sb.append(c.name())
                                .append(": ")
                                .append(argsStr)
                                .append(" ^ ")
                                .append(dd.typeName())
                                .append("\n");
                    }
                } else if (stmt instanceof LetStatement let) {
                    // Prefer the inferred type from the typer's environment if available
                    TypeNode type = env.find(let.varName());
                    String typeS = type == null ? "~" : typeToString(typer.apply(type));
                    sb.append(let.varName()).append(": ").append(typeS).append("\n");
                } else if (stmt instanceof FunNode fun) {
                    // Prefer the inferred function type from the typer's environment
                    TypeNode ft = env.find(fun.name());
                    if (ft instanceof ArrowNode arrow) {
                        sb.append(fun.name()).append(": ")
                                .append(typeToString(typer.apply(arrow.inputType())))
                                .append(" -> ")
                                .append(typeToString(typer.apply(arrow.returnType())))
                                .append("\n");
                    } else {
                        int n = fun.parameters() == null ? 0 : fun.parameters().size();
                        String paramsStr = switch (n) {
                            case 0 -> "~";
                            case 1 -> "any";
                            default -> {
                                java.util.List<String> anys = java.util.Collections.nCopies(n, "any");
                                String tuple = String.join(", ", anys);
                                yield "(" + tuple + ")";
                            }
                        };
                        String retStr = fun.returnType() == null ? "~" : typeToString(fun.returnType());
                        if (!"~".equals(paramsStr) || !"~".equals(retStr)) {
                            sb.append(fun.name()).append(": ")
                                    .append(paramsStr)
                                    .append(" -> ")
                                    .append(retStr)
                                    .append("\n");
                        } else {
                            sb.append(fun.name()).append(": ~\n");
                        }
                    }
                }
            }

            Files.writeString(outPath, sb.toString());
            Utils.log(logger.apply("Typings written to: " + outPath));
        } catch (Exception e) {
            Utils.logError("Error generating .typings file: " + e.getMessage());
        }
    }

    // Convert a TypeNode to Expresso surface syntax
    private static String typeToString(TypeNode t) {
        if (t == null)
            return "~";
        if (t instanceof com.expresso.ast.TypeVar) {
            return "any";
        }
        if (isListType(t)) {
            return "[" + typeToString(listElementType(t)) + "]";
        }
        return switch (t) {
            case AtomicNode a -> mapAtomicName(a.name());
            case TupleNode tuple -> {
                String inside = tuple.elements().stream()
                        .map(Pipeline::typeToString)
                        .reduce((a, b) -> a + ", " + b)
                        .orElse("");
                yield "(" + inside + ")";
            }
            case ArrowNode arrow -> typeToString(arrow.inputType()) + " -> " + typeToString(arrow.returnType());
            default -> "~";
        };
    }

    private static String mapAtomicName(String name) {
        if (name == null)
            return "~";
        return switch (name) {
            case "Int", "int" -> "int";
            case "Float", "float" -> "float";
            case "String", "string" -> "string";
            case "Boolean", "boolean" -> "boolean";
            case "Void", "void" -> "void";
            case "Any", "any" -> "any";
            default -> name;
        };
    }

    private static boolean isListType(TypeNode t) {
        if (t instanceof TupleNode tuple && tuple.elements().size() == 2) {
            TypeNode head = tuple.elements().get(0);
            return head instanceof AtomicNode a && LIST_SENTINEL.equals(a.name());
        }
        return false;
    }

    private static TypeNode listElementType(TypeNode listType) {
        TupleNode tuple = (TupleNode) listType;
        return tuple.elements().get(1);
    }

    private static Optional<ParseTreeResult> processASTWithVisualization(String content,
            Function<String, String> logger, Transpiler config) {
        // Single Tree Visualization
        if (config.showTree()) {
            return Utils.parseASTWithTree(content, logger)
                    .map(result -> {
                        handleSingleTreeVisualization(result, config);
                        return result;
                    });
        }

        // Both trees visualization
        return Utils.parseASTWithTree(content, logger)
                .map(result -> {
                    handleTreeVisualization(result, config);
                    return result;
                });
    }

    private static void handleTreeVisualization(ParseTreeResult result, Transpiler config) {
        if (config.showTrees()) {
            Utils.showCustomAST(result.ast());
            Utils.showANTLRTree(result.parseTree(), result.parser());
        }
    }

    private static void handleSingleTreeVisualization(ParseTreeResult result, Transpiler config) {
        if (config.showTree())
            Utils.showCustomAST(result.ast());
        if (config.printTree())
            System.out.println("PRINT -> Custom AST:");
    }

    private static boolean transpileASTToJava(Program ast, CommonTokenStream tokens, String outputDir, String inputFile,
            Function<String, String> logger) {
        String className = Utils.extractFileName(inputFile);

        // Recollect features from AST
        Set<Feature> features = FeatureCollector.collect(ast);

        // Use typer
        Typer existingTyper = sharedTyper.get();
        AstTranspiler transpiler = new AstTranspiler(className, features, tokens, existingTyper);
        String javaCode = transpiler.transpile(ast, transpiler.getGlobalEnv());

        boolean success = Utils.writeJavaFile(javaCode, outputDir, inputFile, logger);

        if (success) {
            Utils.log(logger.apply("Transpilation successful."));
        }

        return success;
    }
}
