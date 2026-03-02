package org.example;

import org.example.db.DbCreator;
import org.example.domain.model.AppRunner;
import org.example.domain.model.ErrorPrinter;
import org.example.service.CLIService;

public class Main {
    public static void main(String[] args) {
        DbCreator.createConnection();
        DbCreator.runInitialMigrations();

        AppRunner appRunner = new AppRunner(new CLIService(), new ErrorPrinter());

        appRunner.run();

//        CLIService cliService = new CLIService();
//
//        while (cliService.getIsNotTerminated()) {
//            try {
//                cliService.parseLine();
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }
    }
}