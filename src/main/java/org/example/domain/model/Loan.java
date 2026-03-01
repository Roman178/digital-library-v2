package org.example.domain.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Loan {
    UUID loanId = UUID.randomUUID();
    UUID itemId;
    UUID readerId;
    LocalDate issuedAt;
    LocalDate dueAt;
    LocalDate returnedAt;

    public static void handleCommands(List<String> listOfCommands) {

    }
}
