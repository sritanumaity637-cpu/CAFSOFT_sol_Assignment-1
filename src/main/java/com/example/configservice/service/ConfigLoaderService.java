package com.example.configservice.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConfigLoaderService {

    // Preserve section order
    private final Map<String, Map<String, Object>> configStore = new LinkedHashMap<>();

    @PostConstruct
    public void loadConfig() throws Exception {

        InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("config.txt");

        if (is == null) {
            throw new RuntimeException("config.txt not found");
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        String currentSection = null;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            // Section name
            if (!line.contains("=")) {
                currentSection = line;
                configStore.put(currentSection, new LinkedHashMap<>());
                continue;
            }

            // key=value
            String[] parts = line.split("=", 2);
            String key = parts[0].trim();
            String value = parts[1].trim();

            Object finalValue;
            if (value.contains(",")) {
                finalValue = Arrays.stream(value.split(","))
                        .map(String::trim)
                        .toList();
            } else {
                finalValue = value;
            }

            configStore.get(currentSection).put(key, finalValue);
        }
    }

    public Map<String, Object> getSection(String section) {
        return configStore.get(section);
    }
}
