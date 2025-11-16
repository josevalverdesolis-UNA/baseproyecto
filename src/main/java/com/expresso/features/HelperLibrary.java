// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.features;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Provides small code pices to be included in the generated Java code
 * depending on the features used in the Expresso source code.
 */
public class HelperLibrary {

        private static final Map<Feature, String> HELPERS = Map.ofEntries(

                        Map.entry(Feature.PRINT,
                                        "public static void print(Object arg){ System.out.println(arg); }"),
                        Map.entry(Feature.POW,
                                        "public static int pow(int x, int e){ return (int)Math.pow(x, e); }\n"
                                                        + "public static double pow(double x, double e){ return Math.pow(x, e); }"),
                        Map.entry(Feature.COERCIONS,
                                        "public static Double toDouble(Object value){\n"
                                                        + "\tif(value == null) return null;\n"
                                                        + "\tif(value instanceof Double d) return d;\n"
                                                        + "\tif(value instanceof Integer i) return i.doubleValue();\n"
                                                        + "\tif(value instanceof Number n) return n.doubleValue();\n"
                                                        + "\tif(value instanceof String s) return Double.valueOf(s);\n"
                                                        + "\tthrow new ClassCastException(\"Cannot convert to Double: \" + value);\n"
                                                        + "}\n"
                                                        + "public static Integer toInteger(Object value){\n"
                                                        + "\tif(value == null) return null;\n"
                                                        + "\tif(value instanceof Integer i) return i;\n"
                                                        + "\tif(value instanceof Number n) return n.intValue();\n"
                                                        + "\tif(value instanceof String s) return Integer.valueOf(s);\n"
                                                        + "\tthrow new ClassCastException(\"Cannot convert to Integer: \" + value);\n"
                                                        + "}"));

        private static final Map<Feature, String> IMPORTS = Map.of(
                        Feature.FUNCTIONAL, "import java.util.function.*;",
                        Feature.LIST, "import java.util.*;",
                        Feature.LAMBDA, "import java.util.function.*;",
                        Feature.ATOMIC, "import java.util.concurrent.atomic.*;");

        public static String generateHelpers(Set<Feature> features) {
                return features.stream()
                                .map(HELPERS::get)
                                .filter(Objects::nonNull)
                                .collect(Collectors.joining("\n"));
        }

        public static String generateImports(Set<Feature> features) {
                return features.stream()
                                .map(IMPORTS::get)
                                .filter(Objects::nonNull)
                                .distinct()
                                .collect(Collectors.joining("\n"));
        }
}
