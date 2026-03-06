package org.example;

import org.example.db.DbCreator;
import org.example.domain.model.AppRunner;
import org.example.domain.model.ErrorPrinter;
import org.example.repository.ReaderRepository;
import org.example.service.CLIService;
import org.example.service.ReaderService;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = DbCreator.createConnection();
        DbCreator.runInitialMigrations();

        ReaderRepository readerRepository = new ReaderRepository(conn);
        ReaderService readerService = new ReaderService(readerRepository);

        AppRunner appRunner = new AppRunner(new CLIService(readerService), new ErrorPrinter());

        appRunner.run();
    }
}