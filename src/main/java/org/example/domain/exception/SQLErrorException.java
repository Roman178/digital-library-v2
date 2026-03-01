package org.example.domain.exception;

import java.sql.SQLException;

public class SQLErrorException extends RuntimeException {
    public SQLErrorException(SQLException e) {
        throw new RuntimeException("Ошибка SQL запроса ", e);
    }
}
