package org.example.repository;

import org.example.domain.model.Reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReaderRepository {
    private final Connection conn;

    public ReaderRepository(Connection conn) {
        this.conn = conn;
    }

    public void createReader(Reader reader) {
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO readers (full_name, email, status) VALUES (?, ?, ?)")) {
            ps.setString(1, reader.fullName());
            ps.setString(2, reader.email());
            ps.setString(3, reader.status()
                    .name());

            ps.executeUpdate();
            conn.commit();
            //        reader add fullName=fdsds email=dfsd@example.com

        } catch (SQLException e) {
            throw new RuntimeException("Ошибка SQL при создании читателя ", e);
        }
    }
}
