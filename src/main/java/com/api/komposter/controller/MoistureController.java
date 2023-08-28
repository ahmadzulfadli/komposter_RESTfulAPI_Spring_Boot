package com.api.komposter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.api.komposter.entity.Moisture;
import com.api.komposter.model.CreateMoistureRequest;
import com.api.komposter.service.MoistureService;

@RestController
public class MoistureController {
    
    @Autowired
    private MoistureService moistureService;

    @PostMapping(
        path = "/komposter/addData/moistures",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Moisture> addData(@RequestBody CreateMoistureRequest request){
        Moisture creaMoisture =  moistureService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creaMoisture);
    }
}
