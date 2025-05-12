package org.example;

import org.example.service.CLIService;

public class Main {
    public static void main(String[] args) {
        CLIService cliService = new CLIService();
        cliService.parseLine();
    }
}