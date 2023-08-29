package com.api.komposter.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.api.komposter.entity.PhMeter;
import com.api.komposter.model.CreatePhMeterRequest;
import com.api.komposter.model.PhMeterResponse;
import com.api.komposter.model.UpdatePhMeterRequest;
import com.api.komposter.repository.PhMeterRepository;

@Service
public class PhMeterService {
    
    @Autowired
    private PhMeterRepository phMeterRepository;

    @Autowired
    private ValidationService validationService;

    private PhMeterResponse toPhMeterResponse(PhMeter phMeter){
        return PhMeterResponse.builder()
        .id(phMeter.getId())
        .value(phMeter.getValue())
        .timestamp(phMeter.getTimestamp())
        .build();
    }

    // CREATE -------------------------------------------------------------------
    @Transactional
    public PhMeterResponse create(CreatePhMeterRequest request){
        validationService.validate(request);

        PhMeter phMeter = new PhMeter();
        phMeter.setId(UUID.randomUUID().toString());
        phMeter.setValue(request.getValue());
        phMeter.setTimestamp(LocalDateTime.now());

        phMeterRepository.save(phMeter);
        return toPhMeterResponse(phMeter);
    }

    // READ ----------------------------------------------------------------------
    @Transactional(readOnly = true)
    public PhMeterResponse getPhMeter(String id){
        PhMeter phMeter = phMeterRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found"));

        return toPhMeterResponse(phMeter);
    }

    @Transactional(readOnly = true)
    public List<PhMeterResponse> getAllPhMeter(){
        List<PhMeter> phMeter = phMeterRepository.findAll();
        return phMeter.stream().map(this::toPhMeterResponse).toList();
    }

    // UPDATE ----------------------------------------------------------------------
    public PhMeterResponse updatePhMeter(String id, UpdatePhMeterRequest request){
        PhMeter phMeter = phMeterRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found"));

        phMeter.setValue(request.getValue());
        phMeterRepository.save(phMeter);
        return toPhMeterResponse(phMeter);
    }

    // DELETE ----------------------------------------------------------------------
    public void deletePhMeter(String id){
        PhMeter phMeter= phMeterRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found"));

        phMeterRepository.delete(phMeter);
    }
}
