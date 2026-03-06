package org.example.domain.model;

import org.example.domain.exception.HandleLineException;

import java.util.Arrays;

public enum EntityType {
    PUB,
    LOAN,
    READER,
    ITEM,
    REPORT;

    public static EntityType from(String inputValue) {
        EntityType entityType = null;
        try {
            entityType = EntityType.valueOf(inputValue.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new HandleLineException("ВВедена неправильная команда " + inputValue + e);
        }

        return entityType;
    }
}
