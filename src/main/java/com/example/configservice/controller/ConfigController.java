package com.example.configservice.controller;

import com.example.configservice.dto.ConfigResponse;
import com.example.configservice.service.ConfigLoaderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/config")
public class ConfigController {

    private final ConfigLoaderService service;

    public ConfigController(ConfigLoaderService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getConfig(@RequestParam(required = false) String section) {

        if (section == null || section.isBlank()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "section parameter is required"));
        }

        Map<String, Object> data = service.getSection(section);
        if (data == null) {
            return ResponseEntity.status(404)
                    .body(Map.of("error", "section not found"));
        }

        // ⭐ DTO instead of Map
        return ResponseEntity.ok(
                new ConfigResponse(section, data)
        );
    }
}
