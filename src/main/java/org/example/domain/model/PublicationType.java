package org.example.domain.model;

import org.example.domain.exception.HandleLineException;

public enum PublicationType {
    BOOK, MAGAZINE, COMIC;

    public static PublicationType from(String pubType) {
        try {
            return PublicationType.valueOf(pubType.toUpperCase());
        } catch (RuntimeException e) {
            throw new HandleLineException("ВВеден неправильный тип публикации");
        }
    }
}
