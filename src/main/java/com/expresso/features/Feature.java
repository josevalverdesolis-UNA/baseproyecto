// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.features;

/*
 * Lists all special features that can appear in Expresso code.
 * Used to decide what extra Java code (helpers, imports) to generate.
 */
public enum Feature {
    POW,
    PRINT,
    FUNCTIONAL,
    LIST,
    LAMBDA,
    TERNARY,
    DATA_TYPES, // For data declarations
    PATTERN_MATCHING, // For match expressions
    ATOMIC // For AtomicReference usage in recursive functions
}