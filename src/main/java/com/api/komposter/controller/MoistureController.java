package com.api.komposter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.api.komposter.model.CreateMoistureRequest;
import com.api.komposter.model.MoistureResponse;
import com.api.komposter.model.UpdateMoistureRequest;
import com.api.komposter.model.WebResponse;
import com.api.komposter.service.MoistureService;

@RestController
public class MoistureController {
    
    private String sensor = "Moisture";

    @Autowired
    private MoistureService moistureService;

    // CREATE -----------------------------------------------------------------------------------------
    @PostMapping(
        path = "/komposter/addData/moistures",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<MoistureResponse> addData(@RequestBody CreateMoistureRequest request){
        MoistureResponse createMoisture =  moistureService.create(request);
        return WebResponse.<MoistureResponse>builder().sensor(sensor).data(createMoisture).build();
    }

    // READ -----------------------------------------------------------------------------------------
    @GetMapping(
        path = "/komposter/data/moistures/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<MoistureResponse> getData(@PathVariable String id){
        MoistureResponse moistureResponse = moistureService.getMoisture(id);
        return WebResponse.<MoistureResponse>builder().sensor(sensor).data(moistureResponse).build();
    }

    @GetMapping(
        path = "/komposter/data/moistures",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<MoistureResponse>> getAllData(){
        List<MoistureResponse> moistureResponse = moistureService.getAllMoisture();
        return WebResponse.<List<MoistureResponse>>builder().sensor(sensor).data(moistureResponse).build();
    }

    // UPDATE -------------------------------------------------------------------------------------------
    @PatchMapping(
        path = "/komposter/update/moistures/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse updateMoisture(@PathVariable("id") String id, @RequestBody UpdateMoistureRequest request){
        MoistureResponse moistureResponse = moistureService.updateMoisture(id, request);
        return WebResponse.<MoistureResponse>builder().sensor(sensor).data(moistureResponse).build();
    }

    // DELETE -------------------------------------------------------------------------------------------
    @DeleteMapping(
        path = "/komposter/delete/moistures/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse deleteMoisture(@PathVariable("id") String id){
        moistureService.deleteMoisture(id);
        return WebResponse.<String>builder().sensor(sensor).data("Succsess").build();
    }
}
