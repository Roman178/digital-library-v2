package org.example.service;

import org.example.domain.exception.HandleLineException;
import org.example.domain.model.Reader;
import org.example.domain.model.ReaderCLICommands;
import org.example.repository.ReaderRepository;

import java.util.List;

public class ReaderService {
    private final ReaderRepository readerRepository;

    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public void handleCommands(List<String> listOfCommands) {
        String inputCommand = listOfCommands.get(1);
        ReaderCLICommands command = ReaderCLICommands.from(inputCommand);
        List<String> args = listOfCommands.subList(2, listOfCommands.size());

        switch (command) {
            case ADD -> createReader(args);
//            case GET -> getRaderById();
//            case LIST -> getReaders();
        }
    }

    private void createReader(List<String> args) {

    }
}
