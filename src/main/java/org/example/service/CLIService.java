package org.example.service;

import org.example.domain.exception.HandleLineException;
import org.example.domain.model.EntityType;
import org.example.domain.model.Loan;
import org.example.domain.model.Publication;
import org.example.domain.model.Report;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CLIService {
    private final Scanner scanner = new Scanner(System.in);

    private final ReaderService readerService;
    private final LoanService loanService;
    private final PublicationService publicationService;
    private final ReportService reportService;
    private final PubItemService pubItemService;

    private boolean isNotTerminated = true;

    public CLIService(ReaderService readerService,
                      LoanService loanService,
                      PublicationService publicationService,
                      ReportService reportService,
                      PubItemService pubItemService) {
        this.readerService = readerService;
        this.loanService = loanService;
        this.publicationService = publicationService;
        this.reportService = reportService;
        this.pubItemService = pubItemService;
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
        List<String> inputStrings = Arrays.stream(line.split(";"))
                .map(String::trim)
                .filter(part -> !part.isEmpty())
                .toList();

        if (inputStrings.isEmpty()) {
            throw new HandleLineException("Пустая команда");
        }

        String entity = inputStrings.get(0);
        EntityType type = EntityType.from(entity);

        if (type == null) return;

        switch (type) {
            case READER -> readerService.handleCommands(inputStrings);
            case LOAN -> Loan.handleCommands(inputStrings);
            case PUB -> publicationService.handleCommands(inputStrings);
            case ITEM -> pubItemService.handleCommands(inputStrings);
            case REPORT -> Report.handleCommands(inputStrings);
            default -> throw new HandleLineException("Введена неизвестная команда");
        }
    }
}
