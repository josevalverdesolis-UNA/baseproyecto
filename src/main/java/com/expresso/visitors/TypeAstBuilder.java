// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.visitors;

import java.util.List;
import java.util.stream.Collectors;

import com.expresso.ast.ArrowNode;
import com.expresso.ast.AtomicNode;
import com.expresso.ast.TupleNode;
import com.expresso.ast.TypeNode;
import com.expresso.grammar.ExprBaseVisitor;
import com.expresso.grammar.ExprParser;

public class TypeAstBuilder extends ExprBaseVisitor<TypeNode> {
    
    @Override
    public AtomicNode visitAtomic(ExprParser.AtomicContext ctx) {
        String name;

        if(ctx.ID() != null) {
            name = ctx.ID().getText();
        } else {
            name = ctx.getText();
        }

        return new AtomicNode(name);
    }

    @Override
    public TupleNode visitTuple(ExprParser.TupleContext ctx) {
        List<TypeNode> elements = ctx.atomic().stream()
            .map(this::visitAtomic)
            .collect(Collectors.toList());
        return new TupleNode(elements);
    }

    @Override
    public TypeNode visitAtomArrowType(ExprParser.AtomArrowTypeContext ctx) {
        TypeNode left = visitAtomic(ctx.atomic());
        TypeNode right = visit(ctx.type());
        return new ArrowNode(left, right);
    }

    @Override
    public TypeNode visitAtomType(ExprParser.AtomTypeContext ctx) {
        return visitAtomic(ctx.atomic());
    }

    @Override
    public TypeNode visitTupleArrowType(ExprParser.TupleArrowTypeContext ctx) {
        TypeNode left = visitTuple(ctx.tuple());
        TypeNode right = visit(ctx.type());
        return new ArrowNode(left, right);
    }

    @Override
    public TypeNode visitTupleType(ExprParser.TupleTypeContext ctx) {
        return visitTuple(ctx.tuple());
    }

    @Override
    public TypeNode visitParenArrowType(ExprParser.ParenArrowTypeContext ctx) {
        TypeNode inner = visit(ctx.type(0));
        TypeNode right = visit(ctx.type(1));
        return new ArrowNode(inner, right);
    }

    @Override
    public TypeNode visitParenType(ExprParser.ParenTypeContext ctx) {
        return visit(ctx.type());
    }
}
