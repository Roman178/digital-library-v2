package org.example.db;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.example.exception.SQLErrorException;

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

//    public static void createTables() {
//        try {
//            conn.createStatement().execute("PRAGMA foreign_keys = ON;");
//
//            conn.prepareStatement(Query.SCHEMA_PUBLICATIONS.getSql()).executeUpdate();
//            conn.prepareStatement(Query.SCHEMA_BOOKS.getSql()).executeUpdate();
//            conn.prepareStatement(Query.SCHEMA_COMIC_ISSUES.getSql()).executeUpdate();
//            conn.prepareStatement(Query.SCHEMA_MAGAZINE_ISSUES.getSql()).executeUpdate();
//            conn.prepareStatement(Query.SCHEMA_AUTHORS.getSql()).executeUpdate();
//            conn.prepareStatement(Query.SCHEMA_READERS.getSql()).executeUpdate();
//            conn.prepareStatement(Query.SCHEMA_LOANS.getSql()).executeUpdate();
//            conn.prepareStatement(Query.INDEX_UX_LOANS_ACTIVE_ITEM.getSql()).executeUpdate();
//            conn.prepareStatement(Query.SCHEMA_PUBLICATION_ITEMS.getSql()).executeUpdate();
//            conn.prepareStatement(Query.SCHEMA_PUBLICATION_AUTHORS.getSql()).executeUpdate();
//        } catch (SQLException e) {
//            throw new SQLErrorException(e);
//        }


}

//    public static void seed() {
//        String seedDbSql = Query.SEED.getSql();
//
//        String[] s = seedDbSql.split(";");
//    }
//}
