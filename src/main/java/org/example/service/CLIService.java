package org.example.service;

import java.util.Scanner;

public class CLIService {
    private final Scanner scanner = new Scanner(System.in);

    public void parseLine() {
        String line = scanner.nextLine();
        handleLine(line);
    }

    private void handleLine(String line) {

    }
}
