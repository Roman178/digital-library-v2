package org.example.domain.model;

import java.util.List;

public abstract class Publication {
    //    private final UUID id = UUID.randomUUID();
    String title;
    String author;
    Genre genre;
    int year;


    public static void handleCommands(List<String> inputStrings) {
        try {
            PublicationCLICommands cliCommand = PublicationCLICommands.valueOf(inputStrings.get(1));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}
