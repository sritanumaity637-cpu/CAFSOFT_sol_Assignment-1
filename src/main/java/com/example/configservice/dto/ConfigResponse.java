package com.example.configservice.dto;

public class ConfigResponse {

    private String section;
    private Object data;

    // constructor
    public ConfigResponse(String section, Object data) {
        this.section = section;
        this.data = data;
    }

    // getters (IMPORTANT for JSON)
    public String getSection() {
        return section;
    }

    public Object getData() {
        return data;
    }
}
