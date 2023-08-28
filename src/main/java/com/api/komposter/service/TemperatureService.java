package com.api.komposter.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.api.komposter.entity.Temperature;
import com.api.komposter.model.CreateTemperatureRequest;
import com.api.komposter.model.TemperatureResponse;
import com.api.komposter.model.UpdateTemperatureRequest;
import com.api.komposter.repository.TemperatureRepository;

@Service
public class TemperatureService {
    
    @Autowired
    private TemperatureRepository temperatureRepository;

    @Autowired
    private ValidationService validationService;

    private TemperatureResponse toTemperatureResponse(Temperature temperature){
        return TemperatureResponse.builder()
        .id(temperature.getId())
        .value(temperature.getValue())
        .timestamp(temperature.getTimestamp())
        .build();
    }

    // CREATE -------------------------------------------------------------------
    @Transactional
    public TemperatureResponse create(CreateTemperatureRequest request){
        validationService.validate(request);
        
        Temperature temperature = new Temperature();
        temperature.setId(UUID.randomUUID().toString());
        temperature.setValue(request.getValue());
        temperature.setTimestamp(LocalDateTime.now());
        
        temperatureRepository.save(temperature);
        return toTemperatureResponse(temperature);
    }

    // READ ----------------------------------------------------------------------
    @Transactional(readOnly = true)
    public TemperatureResponse getTemperature(String id){
        Temperature temperature = temperatureRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found"));

        return toTemperatureResponse(temperature);
    }

    @Transactional(readOnly = true)
    public List<TemperatureResponse> getAllTemperature(){
        List<Temperature> temperature = temperatureRepository.findAll();
        return temperature.stream().map(this::toTemperatureResponse).toList();
    }

    // UPDATE ---------------------------------------------------------------------
    @Transactional
    public TemperatureResponse updateTemperature(String id,UpdateTemperatureRequest request){
        validationService.validate(request);

        Temperature temperature = temperatureRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found"));
        
        temperature.setValue(request.getValue());
        temperatureRepository.save(temperature);

        return toTemperatureResponse(temperature);
    }

    // UPDATE ---------------------------------------------------------------------
    @Transactional
    public void deleteTemperature(String id){
        Temperature temperature = temperatureRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found"));

        temperatureRepository.delete(temperature);
    }

}
