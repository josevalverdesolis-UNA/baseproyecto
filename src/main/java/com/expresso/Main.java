// Project: Expresso
// Subject: EIF400 - Programming Paradigms - II-2025
// Group: 03 6PM
// Authors: Rodrigo C. , Eduardo F. , Diego S., Jose Luis V.

package com.expresso;

import com.expresso.commands.Build;
import com.expresso.commands.Run;
import com.expresso.commands.Transpile;
import com.expresso.commands.Typer;

import picocli.CommandLine;
import picocli.CommandLine.Command;

// ----------------------------------------------------------------------------
// PicoCLI
// ----------------------------------------------------------------------------

@Command(name = "expresso", description = "Transpiler from Expresso to Java.", version = "1.0.0", subcommands = {
        Transpile.class,
        Build.class,
        Typer.class,
        Run.class,
        CommandLine.HelpCommand.class,
})
public class Main {
    public static void main(String[] args) {
        System.exit(new CommandLine(new Main()).execute(args));
    }
}

// https://picocli.info/#_getting_started
// https://github.com/remkop/picocli/blob/main/picocli-examples/annotation-processing/example-gradle-project/src/main/java/com/company/Main.java