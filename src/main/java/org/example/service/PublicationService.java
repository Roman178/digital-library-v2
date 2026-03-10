package org.example.service;

import org.example.domain.model.PublicationCLICommands;
import org.example.domain.model.PublicationType;
import org.example.repository.PublicationRepository;

import java.util.List;

public class PublicationService {
    private final PublicationRepository publicationRepository;

    public PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    public void handleCommands(List<String> listOfCommands) {
        String inputCommand = listOfCommands.get(1);
        PublicationCLICommands command = PublicationCLICommands.from(inputCommand);
        
        List<String> sublistOfCommands = listOfCommands.subList(2, listOfCommands.size());

        switch (command) {
            case ADD -> createPublication(sublistOfCommands);
            case LIST -> getPublications(sublistOfCommands);
            case GET -> getPublicationById(sublistOfCommands);
            case SORT -> sortPublications(sublistOfCommands);
            case FILTER -> filterPublications(sublistOfCommands);
            case SEARCH -> searchPublications(sublistOfCommands);
        }
    }

    private void searchPublications(List<String> sublistOfCommands) {

    }

    private void filterPublications(List<String> sublistOfCommands) {

    }

    private void sortPublications(List<String> sublistOfCommands) {

    }

    private void getPublicationById(List<String> sublistOfCommands) {
        
    }

    private void getPublications(List<String> sublistOfCommands) {
        
    }

    private void createPublication(List<String> sublistOfCommands) {
        String pubType = sublistOfCommands.get(0);
        PublicationType type = PublicationType.from(pubType);

//        switch (type) {
//            case BOOK -> ;
//            case COMIC -> ;
//            case MAGAZINE -> ;
//        }
    }
}
