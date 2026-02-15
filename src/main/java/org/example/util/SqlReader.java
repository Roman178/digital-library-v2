package org.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public final class SqlReader {
    public static String load(String sqlPath) {
        try {
            InputStream inputStream = SqlReader.class.getClassLoader().getResourceAsStream(sqlPath);
            if (inputStream == null) {
                throw new IllegalArgumentException("Файл не найден по пути: " + sqlPath);
            }
            String readSql = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

            return readSql;
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения SQL скрипта: " + sqlPath, e);
        }
    }
}
