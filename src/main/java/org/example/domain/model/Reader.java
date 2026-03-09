package org.example.domain.model;

import java.util.List;
import java.util.Map;

public record Reader(String fullName,
                     ReaderStatus readerStatus,
                     String email) {
    public static Reader from(Map argsMap) {
        String fullName = (String) argsMap.get("fullName");
        String email = (String) argsMap.get("email");

        return new Reader(fullName, ReaderStatus.ACTIVE, email);
    }
}

