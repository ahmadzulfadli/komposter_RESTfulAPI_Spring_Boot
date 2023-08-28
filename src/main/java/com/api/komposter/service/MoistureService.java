package com.api.komposter.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.komposter.entity.Moisture;
import com.api.komposter.model.CreateMoistureRequest;
import com.api.komposter.repository.MoistureRepository;

import jakarta.transaction.Transactional;

@Service
public class MoistureService {

    @Autowired
    private MoistureRepository moistureRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public Moisture create(CreateMoistureRequest request){
        validationService.validate(request);

        Moisture moisture = new Moisture();
        moisture.setId(UUID.randomUUID().toString());
        moisture.setValue(request.getValue());
        moisture.setTimestamp(LocalDateTime.now());

        moistureRepository.save(moisture);

        return moisture;
    }
}
