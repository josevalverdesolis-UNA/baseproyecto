// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.ast;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public sealed interface Node
        permits Num, StringNode, BinaryOp, FuncCall, Lambda, LetStatement, ListNode, PrintStatement, Program,
        TernaryExpression, UnaryOp, Variable, TypeNode, FunNode, BooleanNode, NoneNode, CastNode, InstantiatorNode,
        DataDeclaration, Constructor, MatchExpression, MatchRule, Pattern {

    // --------------------------------------------------------------
    // Getters
    // --------------------------------------------------------------
    Object getHead();

    List<Node> getChildren();

    // --------------------------------------------------------------
    // Auxiliary Methods
    // --------------------------------------------------------------
    default DefaultMutableTreeNode toSwingTree() {
        DefaultMutableTreeNode swingNode = new DefaultMutableTreeNode(
                getHead() != null ? getHead() : getClass().getSimpleName());

        getChildren().stream()
                .map(Node::toSwingTree) // Recursively apply the method to each child
                .forEach(swingNode::add); // Add the mapped child nodes to the current node

        return swingNode;
    }
}
