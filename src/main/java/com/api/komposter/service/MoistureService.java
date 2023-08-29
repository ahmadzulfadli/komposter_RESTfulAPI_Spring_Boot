package com.api.komposter.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.api.komposter.entity.Moisture;
import com.api.komposter.model.CreateMoistureRequest;
import com.api.komposter.model.MoistureResponse;
import com.api.komposter.model.UpdateMoistureRequest;
import com.api.komposter.repository.MoistureRepository;

@Service
public class MoistureService {

    @Autowired
    private MoistureRepository moistureRepository;

    @Autowired
    private ValidationService validationService;

    private MoistureResponse toMoistureResponse(Moisture moisture){
        return MoistureResponse.builder()
        .id(moisture.getId())
        .value(moisture.getValue())
        .timestamp(moisture.getTimestamp())
        .build();
    }

    // CREATE -------------------------------------------------------------------
    @Transactional
    public MoistureResponse create(CreateMoistureRequest request){
        validationService.validate(request);

        Moisture moisture = new Moisture();
        moisture.setId(UUID.randomUUID().toString());
        moisture.setValue(request.getValue());
        moisture.setTimestamp(LocalDateTime.now());

        moistureRepository.save(moisture);

        return toMoistureResponse(moisture);
    }

    // READ ----------------------------------------------------------------------
    @Transactional(readOnly = true)
    public MoistureResponse getMoisture(String id){
        Moisture moisture = moistureRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found"));
        
        return toMoistureResponse(moisture);
    }
    @Transactional(readOnly = true)
    public List<MoistureResponse> getAllMoisture(){
        List<Moisture> moisture = moistureRepository.findAll();
        return moisture.stream().map(this::toMoistureResponse).toList();
    }
    // UPDATE ----------------------------------------------------------------------
    @Transactional
    public MoistureResponse updateMoisture(String id, UpdateMoistureRequest request){
        validationService.validate(request);

        Moisture moisture = moistureRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found"));

        moisture.setValue(request.getValue());
        moistureRepository.save(moisture);

        return toMoistureResponse(moisture);
    }

    // DELETE ----------------------------------------------------------------------
    @Transactional
    public void deleteMoisture(String id){
        Moisture moisture = moistureRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found"));

        moistureRepository.delete(moisture);
    }
    
}
