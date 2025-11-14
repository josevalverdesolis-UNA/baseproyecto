// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.model;

import java.nio.file.Path;

public record CompilationResult(boolean success, String message, Path compiledFile) {
    public static CompilationResult success(Path compiledFile) {
        return new CompilationResult(true, "Compilation successful", compiledFile);
    }

    public static CompilationResult failure(String message) {
        return new CompilationResult(false, message, null);
    }
}
