package org.example.domain.model;

import java.util.Arrays;

public enum EntityType {
    PUBLICATION("publication"), LOAN("loan"), READER("reader");

    private final String value;

    EntityType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EntityType from(String inputValue) {
        return Arrays.stream(values())
                .filter(type -> type.getValue().equalsIgnoreCase(inputValue))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Неизвестный entity type " + inputValue));
    }
}
