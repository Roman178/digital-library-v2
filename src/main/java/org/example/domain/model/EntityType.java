package org.example.domain.model;

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
            System.out.println("ВВедена неправильная команда ");
        }

        return entityType;
    }
}
