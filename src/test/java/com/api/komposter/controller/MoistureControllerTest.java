package com.api.komposter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.api.komposter.model.CreateMoistureRequest;
import com.api.komposter.repository.MoistureRepository;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class MoistureControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MoistureRepository moistureRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        moistureRepository.deleteAll();
    }

    @Test
    void testCreateMoistureRequest() throws Exception{
        CreateMoistureRequest request = new CreateMoistureRequest();

        request.setValue("32.1");

        mockMvc.perform(
            post("/komposter/addData/moistures")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(request))
        ).andExpect(
            status().isOk()
        ).andExpect(MockMvcResultMatchers.jsonPath("$.sensor").exists());
    }
    
}
