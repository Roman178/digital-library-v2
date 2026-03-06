package org.example.service;

import org.example.domain.exception.HandleLineException;
import org.example.domain.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CLIService {
    private final Scanner scanner = new Scanner(System.in);
    private final ReaderService readerService;
    private boolean isNotTerminated = true;

    public CLIService(ReaderService readerService) {
        this.readerService = readerService;
    }

    public boolean getIsNotTerminated() {
        return isNotTerminated;
    }

    private void setIsNotTerminated(boolean notTerminated) {
        isNotTerminated = notTerminated;
    }

    public void parseLine() {
        String line = scanner.nextLine();

        if (line.trim()
                .equals("exit")) {
            setIsNotTerminated(false);
            return;
        }

        handleLine(line);
    }

    private void handleLine(String line) {
        List<String> inputStrings = Arrays.stream(line.split(" "))
                .map(String::trim)
                .toList();

        String entity = inputStrings.get(0);
        EntityType type = EntityType.from(entity);

        if (type == null) return;

        switch (type) {
            case READER -> readerService.handleCommands(inputStrings);
            case LOAN -> Loan.handleCommands(inputStrings);
            case PUB, ITEM -> Publication.handleCommands(inputStrings);
            case REPORT -> Report.handleCommands(inputStrings);
            default -> throw new HandleLineException("Введена неизвестная команда");
        }
    }
}
