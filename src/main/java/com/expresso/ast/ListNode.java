// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.List;
import java.util.stream.Collectors;

public record ListNode(List<Node> elements) implements Node {
    //--------------------------------------------------------------
    // Getters
    //--------------------------------------------------------------
    @Override
    public Object getHead() {
        return "List";
    }

    @Override
    public List<Node> getChildren() {
        return elements;
    }   

    //--------------------------------------------------------------
    // Methods
    //--------------------------------------------------------------
    // This method is just for convenience. Canbe removed later. But it's easier to understand.
    public List<Node> getElements() {
        return getChildren();
    }

    public int size() {
        return getChildren().size();
    }

    public boolean isEmpty() {
        return getChildren().isEmpty();
    }

    @Override
    public String toString() {
        return "[" + getElements().stream()
                .map(Node::toString)
                .collect(Collectors.joining(", ")) + "]";
    }
}
