//package com.example.configservice.controller;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class ConfigControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    void shouldReturnOrderServiceConfig() throws Exception {
//        mockMvc.perform(get("/config")
//                        .param("section", "Order Service"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.section").value("Order Service"))
//                .andExpect(jsonPath("$.data.broker").value("https://orbroker.in"))
//                .andExpect(jsonPath("$.data.topic").isArray());
//    }
//
//    @Test
//    void shouldReturn400WhenSectionMissing() throws Exception {
//        mockMvc.perform(get("/config"))
//                .andExpect(status().isBadRequest());
//    }
//
//    @Test
//    void shouldReturn404WhenSectionInvalid() throws Exception {
//        mockMvc.perform(get("/config")
//                        .param("section", "Invalid"))
//                .andExpect(status().isNotFound());
//    }
//}
