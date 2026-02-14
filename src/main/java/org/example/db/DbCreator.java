package org.example.db;

import org.example.exception.SQLErrorException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbCreator {
    private static final String url = "jdbc:sqlite:library.db";
    private static Connection conn;

    // language=SQL
    private static final String createTablesSQL =
            "CREATE TABLE IF NOT EXISTS publications (" +
                    "id INTEGER PRIMARY KEY," +
                    "type TEXT NOT NULL," +
                    "title TEXT NOT NULL, " +
                    "genre NOT NULL, " +
                    "publisher TEXT NULL, " +
                    "publication_year INTEGER NOT NULL," +
                    "created_at DATE NOT NULL DEFAULT(datetime('now')), " +
                    "updated_at DATE NOT NULL DEFAULT(datetime('now')))";

    public static void createConnection() {
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка соединения с БД -", e);
        }
    }

    public static void createTables() {
        try {
            Statement stmnt = conn.createStatement();
            stmnt.executeUpdate(createTablesSQL);
        } catch (SQLException e) {
            throw new SQLErrorException(e);
        }
    }
}
