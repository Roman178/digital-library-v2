package org.example.db;

import org.example.exception.SQLErrorException;

import java.sql.*;

public class DbCreator {
    private static final String url = "jdbc:sqlite:library.db";
    private static Connection conn;

    public static void createConnection() {
        try {
            conn = DriverManager.getConnection(url);


        } catch (SQLException e) {
            throw new RuntimeException("Ошибка соединения с БД -", e);
        }
    }

    public static void createTables() {
        try {
            conn.prepareStatement(Query.SCHEMA_PUBLICATIONS.getSql()).executeUpdate();
            conn.prepareStatement(Query.SCHEMA_BOOKS.getSql()).executeUpdate();
            conn.prepareStatement(Query.SCHEMA_COMIC_ISSUES.getSql()).executeUpdate();
            conn.prepareStatement(Query.SCHEMA_MAGAZINE_ISSUES.getSql()).executeUpdate();
            conn.prepareStatement(Query.SCHEMA_AUTHORS.getSql()).executeUpdate();
            conn.prepareStatement(Query.SCHEMA_READERS.getSql()).executeUpdate();
            conn.prepareStatement(Query.SCHEMA_LOANS.getSql()).executeUpdate();
            conn.prepareStatement(Query.INDEX_UX_LOANS_ACTIVE_ITEM.getSql()).executeUpdate();
            conn.prepareStatement(Query.SCHEMA_PUBLICATION_ITEMS.getSql()).executeUpdate();
            conn.prepareStatement(Query.SCHEMA_PUBLICATION_AUTHORS.getSql()).executeUpdate();


//            publicationTableStatement.executeUpdate();
//            booksTableStatement.executeUpdate();

        } catch (SQLException e) {
            throw new SQLErrorException(e);
        }
    }
}
