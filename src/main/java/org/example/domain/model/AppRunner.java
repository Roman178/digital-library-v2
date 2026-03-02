package org.example.domain.model;

import org.example.service.CLIService;

public class AppRunner {
    private final CLIService cliService;
    private final ErrorPrinter errorPrinter;

    public AppRunner(CLIService cliService, ErrorPrinter errorPrinter) {
        this.cliService = cliService;
        this.errorPrinter = errorPrinter;
    }

    public void run() {
        while (cliService.getIsNotTerminated()) {
            try {
                cliService.parseLine();
            } catch (Exception e) {
               errorPrinter.printError(e);
            }
        }
    }
}
