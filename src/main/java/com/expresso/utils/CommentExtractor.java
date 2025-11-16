// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import com.expresso.grammar.ExprLexer;

// Utility class for extracting and formatting comments from the Hidden channel
public class CommentExtractor {

    // Extracts comments from the token stream and groups them by their line numbers
    public static Map<Integer, List<String>> extractCommentsByLine(CommonTokenStream tokens) {
        return tokens.getTokens().stream()
            .filter(CommentExtractor::isComment)
            .collect(Collectors.groupingBy(
                Token::getLine,
                Collectors.mapping(
                    Token::getText,
                    Collectors.toList()
                )
            ));
    }

    // Checks if a token is a comment // or /* */
    private static boolean isComment(Token token) {
        return token.getType() == ExprLexer.LINECOMMENT || 
               token.getType() == ExprLexer.BLOCKCOMMENT;
    }

    // Gets comments for a specific line number
    public static List<String> getCommentsForLine(Map<Integer, List<String>> commentsByLine, int lineNumber) {
        return commentsByLine.getOrDefault(lineNumber, List.of());
    }

    public static String formatCommentsForLine(Map<Integer, List<String>> commentsByLine, int lineNumber) {
        List<String> comments = getCommentsForLine(commentsByLine, lineNumber);
        
        if (comments.isEmpty()) {
            return "";
        }
        
        return comments.stream()
            .map(CommentExtractor::formatSingleComment)
            .collect(Collectors.joining(" "));
    }

    private static String formatSingleComment(String comment) {
        return comment;
    }

    // Checks if there are comments for a specific line number
    public static boolean hasComments(Map<Integer, List<String>> commentsByLine, int lineNumber) {
        return commentsByLine.containsKey(lineNumber) && 
               !commentsByLine.get(lineNumber).isEmpty();
    }
}