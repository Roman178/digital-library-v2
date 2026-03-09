package org.example.repository;

import org.example.domain.model.Reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка SQL при создании читателя ", e);
        }
    }

    public Reader getReaderById(String id) {
        try(PreparedStatement ps = conn.prepareStatement("SELECT * FROM readers WHERE id = ?")) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return Reader.from(rs);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка SQL запросе читателя по id " + id, e);
        }

    }

    public List<Reader> getReaders() {
        try(PreparedStatement ps = conn.prepareStatement("SELECT * FROM readers")) {
            ResultSet rs = ps.executeQuery();
            List<Reader> readerList = new ArrayList<>();

            while (rs.next()) {
                readerList.add(Reader.from(rs));
            }

            return readerList;
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка SQL запроса списка читателей ", e);
        }
    }
}
