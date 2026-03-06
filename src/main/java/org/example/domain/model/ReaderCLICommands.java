package org.example.domain.model;

public enum ReaderCLICommands {
    ADD,
    LIST,
    GET;

    public static ReaderCLICommands from(String inputValue) {
        return ReaderCLICommands.valueOf(inputValue.toUpperCase());
    }
}
