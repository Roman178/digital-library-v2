package org.example.domain.model;

import org.example.domain.exception.HandleLineException;

public enum PublicationCLICommands {
    ADD,
    LIST,
    GET,
    SEARCH,
    FILTER,
    SORT;

    public static PublicationCLICommands from(String inputValue) {
        try {
            return PublicationCLICommands.valueOf(inputValue.toUpperCase());
        } catch (RuntimeException e) {
            throw new HandleLineException("Введена неправильная команда читателей");
        }
    }
}
