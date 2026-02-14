package org.example.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Loan {
    UUID loanId = UUID.randomUUID();
    UUID itemId;
    UUID readerId;
    LocalDate issuedAt;
    LocalDate dueAt;
    LocalDate returnedAt;
}
