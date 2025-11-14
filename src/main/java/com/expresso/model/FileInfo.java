// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.model;

import java.nio.file.Path;
import java.util.Objects;

// File information. This class helps manage file metadata.
public record FileInfo(Path output, String path, String name) {

    public FileInfo {
        Objects.requireNonNull(output);
        Objects.requireNonNull(path);
        Objects.requireNonNull(name);
    }
}
