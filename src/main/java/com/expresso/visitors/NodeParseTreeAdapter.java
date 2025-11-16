// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.visitors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;

import com.expresso.ast.Node;


/*
 * Adapter to convert the custom AST Node structure into an ANTLR ParseTree
 * This allows using ANTLR-based tools and visitors on the custom AST
 * So in that way we can use the ANTLR treeShow() method for visualization
 */
public class NodeParseTreeAdapter implements ParseTree {

    private final Node node;
    private RuleContext parent;
    private final List<NodeParseTreeAdapter> childrenAdapters;

    // ToDo change for to a FP style
    public NodeParseTreeAdapter(Node node) {
        this.node = node;
        this.childrenAdapters = node.getChildren().stream()
            .map(child -> {
                NodeParseTreeAdapter adapter = new NodeParseTreeAdapter(child);
                adapter.setParent(this.parent);
                return adapter;
            })
            .collect(Collectors.toList());
    }

    @Override
    public ParseTree getChild(int i) {
        return childrenAdapters.get(i);
    }

    @Override
    public int getChildCount() {
        return childrenAdapters.size();
    }

    @Override
    public ParseTree getParent() {
        return parent;
    }

    @Override
    public void setParent(RuleContext parent) {
        this.parent = parent;
    }

    @Override
    public Object getPayload() {
        return node.getHead() != null ? node.getHead() : node.getClass().getSimpleName();
    }

    @Override
    public String getText() {
        return node.getHead() != null ? node.getHead().toString() : node.getClass().getSimpleName();
    }

    @Override
    public String toStringTree() {
        return node.toString();
    }

    @Override
    public String toStringTree(org.antlr.v4.runtime.Parser parser) {
        return toStringTree();
    }

    @Override
    public <T> T accept(org.antlr.v4.runtime.tree.ParseTreeVisitor<? extends T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Interval getSourceInterval() {
        return Interval.INVALID;
    }
}
