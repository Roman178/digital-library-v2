package org.example.domain.model;

import org.example.domain.exception.HandleLineException;

public enum ReaderCLICommands {
    ADD,
    LIST,
    GET;

    public static ReaderCLICommands from(String inputValue) {
        try {
            return ReaderCLICommands.valueOf(inputValue.toUpperCase());
        } catch (RuntimeException e) {
            throw new HandleLineException("Введена неправильная команда читателей");
        }
    }
}
