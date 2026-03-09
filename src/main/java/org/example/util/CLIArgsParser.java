package org.example.util;

import org.example.domain.exception.HandleLineException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CLIArgsParser {
    public static Map parse(List<String> args) {
        Map<String, String> argsMap = new HashMap<>();
        for (String arg : args) {
            String[] keyVal = arg.split("=", 2);

            if (keyVal.length != 2) {
                throw new HandleLineException("Неверный аргумент " + arg);
            }

            String key = keyVal[0];
            String val = keyVal[1];

            if (key.isEmpty() || val.isEmpty()) {
                throw new HandleLineException("Пустой ключ или значение " + arg);
            }

            argsMap.put(key, val);
        }

        return argsMap;
    }
}
