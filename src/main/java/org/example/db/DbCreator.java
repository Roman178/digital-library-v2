package org.example.db;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.*;

public class DbCreator {
    private static final String url = "jdbc:sqlite:library.db";
    private static Connection conn;
    private static String changelogPath = "db/changelog/changelog.xml";

    public static void createConnection() {
        try {
            conn = DriverManager.getConnection(url);
            conn.createStatement().execute("PRAGMA foreign_keys = ON;");
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка соединения с БД ", e);
        }

    }

    public static void runInitialMigrations() {
        try {
            Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(conn));
            Liquibase liquibase = new Liquibase(changelogPath, new ClassLoaderResourceAccessor(), database);
            liquibase.update();
        } catch (DatabaseException e) {
            throw new RuntimeException("Ошибка прогона миграций ", e);
        } catch (LiquibaseException e) {
            throw new RuntimeException(e);
        }
    }
}

