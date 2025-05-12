package org.example.model;

import java.util.UUID;

public abstract class Publication {
    private final UUID id = UUID.randomUUID();
    String title;
    String author;
    Genre genre;
    int year;
}
