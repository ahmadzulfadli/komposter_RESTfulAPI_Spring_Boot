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

import com.api.komposter.model.CreatePhMeterRequest;
import com.api.komposter.repository.PhMeterRepository;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PhMeterControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PhMeterRepository phMeterRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        phMeterRepository.deleteAll();
    }

    @Test
    void testCreatePhMeterRequest() throws Exception{
        CreatePhMeterRequest request = new CreatePhMeterRequest();

        request.setValue("1.1");

        mockMvc.perform(
            post("/komposter/addData/phMeters")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(request))
        ).andExpect(
            status().isOk()
        ).andExpect(MockMvcResultMatchers.jsonPath("$.sensor").exists());
    }
}
