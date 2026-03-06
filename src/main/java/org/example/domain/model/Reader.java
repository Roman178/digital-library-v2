package org.example.domain.model;

import org.example.domain.exception.HandleLineException;

import java.util.List;

public class Reader {
//    UUID readerId = UUID.randomUUID();
    String fullName;
    ReaderStatus readerStatus;
    String email;


    public static void handleCommands(List<String> listOfCommands) {
        String inputCommand = listOfCommands.get(1);
        ReaderCLICommands command = null;
        try {
            command = ReaderCLICommands.from(inputCommand);
        } catch (RuntimeException e) {
            throw new HandleLineException("Readers: введена неправильная команда");
        }


    }
}

