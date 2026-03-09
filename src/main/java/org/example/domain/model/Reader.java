package org.example.domain.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public record Reader(String fullName, ReaderStatus status, String email) {
    public static Reader from(Map argsMap) {
        String fullName = (String) argsMap.get("fullName");
        String email = (String) argsMap.get("email");

        return new Reader(fullName, ReaderStatus.ACTIVE, email);
    }

    public static Reader from(ResultSet rs) {
        try {
            return new Reader(rs.getString("full_name"),
                    ReaderStatus.valueOf(rs.getString("status")),
                    rs.getString("email"));
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка маппинга модели читателя ", e);
        }
    }
}

