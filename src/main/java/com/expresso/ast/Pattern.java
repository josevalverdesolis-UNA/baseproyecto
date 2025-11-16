// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

/**
 * Base sealed interface for all pattern types in match expressions.
 * Patterns can be either DataPattern or NativePattern.
 */
public sealed interface Pattern extends Node
        permits DataPattern, NativePattern {
}
