package org.example.service;

import org.example.domain.model.EntityType;
import org.example.domain.model.Loan;
import org.example.domain.model.Publication;
import org.example.domain.model.Reader;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CLIService {
    private final Scanner scanner = new Scanner(System.in);
    private boolean isNotTerminated = true;

    public boolean isNotTerminated() {
        return isNotTerminated;
    }

    public void parseLine() {
        String line = scanner.nextLine();

        if (line.trim()
                .equals("exit")) {
            isNotTerminated = false;
            return;
        }

        handleLine(line);
    }

    private void handleLine(String line) {
        List<String> listOfCommands = Arrays.stream(line.split(","))
                .map(String::trim)
                .toList();

        String entity = listOfCommands.get(1);

        switch (EntityType.from(entity)) {
            case LOAN -> Loan.handleCommands(listOfCommands);
            case READER -> Reader.handleCommands(listOfCommands);
            case PUBLICATION -> Publication.handleCommands(listOfCommands);
        }
    }


    public void setNotTerminated(boolean notTerminated) {
        isNotTerminated = notTerminated;
    }
}
