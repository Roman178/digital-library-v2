package org.example.service;

import org.example.domain.exception.HandleLineException;
import org.example.domain.model.Reader;
import org.example.domain.model.ReaderCLICommands;
import org.example.repository.ReaderRepository;
import org.example.util.CLIArgsParser;

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
            case GET -> getReaderById(args);
            case LIST -> getReaders();
        }
    }

    private void getReaders() {
        List<Reader> readerList = readerRepository.getReaders();

        if (readerList.isEmpty()) {
            printSuccessResult("Нет читателей");
        }

        StringBuilder sb = new StringBuilder();

        for (Reader reader : readerList) {
            sb.append(mapReaderToStr(reader));
            sb.append("\n");
        }

        printSuccessResult(sb.toString());
    }

    private void getReaderById(List<String> args) {
        String id = (String) CLIArgsParser.parse(args)
                .get("id");
        if (id == null) {
            throw new HandleLineException("Не передан id ");
        }

        Reader foundReader = readerRepository.getReaderById(id);
        if (foundReader == null) {
            printSuccessResult("Читатель не найден ");
            return;
        }

        printSuccessResult("Найден читатель " + mapReaderToStr(foundReader));
    }

    private String mapReaderToStr(Reader reader) {
        return reader.fullName() + " | " + reader.email() + " | " + reader.status();
    }

    private void createReader(List<String> args) {
        Reader newReader = Reader.from(CLIArgsParser.parse(args));
        readerRepository.createReader(newReader);
        printSuccessResult("Читатель " + newReader.fullName() + " создан");
    }

    private void printSuccessResult(String msg) {
        System.out.println(msg);
    }
}
