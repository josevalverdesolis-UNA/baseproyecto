// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

public sealed interface TypeNode extends Node permits AtomicNode, TupleNode, ArrowNode, TypeVar {
}
