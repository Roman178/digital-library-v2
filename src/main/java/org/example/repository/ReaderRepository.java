package org.example.repository;

import org.example.domain.model.Reader;
import java.sql.Connection;

public class ReaderRepository {
    private final Connection conn;

    public ReaderRepository(Connection conn) {
        this.conn = conn;
    }

    public void createReader(Reader reader) {

    }
}
