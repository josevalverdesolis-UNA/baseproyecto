// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso.features;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Provides small code pices to be included in the generated Java code
 * depending on the features used in the Expresso source code.
 */
public class HelperLibrary {

        private static final Map<Feature, String> HELPERS = Map.of(
                        Feature.PRINT,
                        "public static void print(Object arg){ System.out.println(arg); }",

                        Feature.POW,
                        "public static int pow(int x, int e){ return (int)Math.pow(x, e); }");

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
