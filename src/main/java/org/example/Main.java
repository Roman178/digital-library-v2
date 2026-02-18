package org.example;

import org.example.db.DbCreator;
import org.example.service.CLIService;

public class Main {
    public static void main(String[] args) {
        DbCreator.createConnection();
        DbCreator.runInitialMigrations();

//        CLIService cliService = new CLIService();
//        cliService.parseLine();
    }
}