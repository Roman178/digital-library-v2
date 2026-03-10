package org.example.service;

import org.example.repository.PubItemRepository;

import java.util.List;

public class PubItemService {
    private final PubItemRepository pubItemRepository;

    public PubItemService(PubItemRepository pubItemRepository) {
        this.pubItemRepository = pubItemRepository;
    }

    public void handleCommands(List<String> inputStrings) {

    }
}
