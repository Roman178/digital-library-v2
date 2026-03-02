package org.example.domain.model;

public enum PublicationCLICommands {
    ADD("add"),
    LIST("list"),
    GET("get"),
    SEARCH("search"),
    FILTER("filter"),
    SORT("sort");

    private final String value;

    PublicationCLICommands(String value) {
        this.value = value;
    }
}
