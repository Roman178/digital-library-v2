package org.example.domain.model;

import java.util.List;

public record Reader(String fullName,
                     ReaderStatus readerStatus,
                     String email) {
}

