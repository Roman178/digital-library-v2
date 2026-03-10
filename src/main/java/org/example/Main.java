package org.example;

import org.example.db.DbCreator;
import org.example.domain.model.AppRunner;
import org.example.domain.model.ErrorPrinter;
import org.example.repository.*;
import org.example.service.*;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = DbCreator.createConnection();
        DbCreator.runInitialMigrations();

        ReaderRepository readerRepository = new ReaderRepository(conn);
        LoanRepository loanRepository = new LoanRepository(conn);
        PublicationRepository publicationRepository = new PublicationRepository(conn);
        ReportRepository reportRepository = new ReportRepository(conn);
        PubItemRepository pubItemRepository = new PubItemRepository(conn);

        ReaderService readerService = new ReaderService(readerRepository);
        LoanService loanService = new LoanService(loanRepository);
        PublicationService publicationService = new PublicationService(publicationRepository);
        ReportService reportService = new ReportService(reportRepository);
        PubItemService pubItemService = new PubItemService(pubItemRepository);

        AppRunner appRunner = new AppRunner(new CLIService(
                readerService,
                loanService,
                publicationService,
                reportService,
                pubItemService),
                new ErrorPrinter());

        appRunner.run();
    }
}