package org.example.repository;

import org.example.domain.model.PublicationType;

import java.sql.Connection;
import java.util.Map;

public class PublicationRepository {
    private final Connection conn;

    public PublicationRepository(Connection conn) {
        this.conn = conn;
    }

    public void createBook(Map parse) {

    }

    public void createComic(Map parse) {

    }

    public void createMagazine(Map parse) {

    }
}
