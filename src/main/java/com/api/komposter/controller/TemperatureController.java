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

import com.api.komposter.model.CreateTemperatureRequest;
import com.api.komposter.model.TemperatureResponse;
import com.api.komposter.model.UpdateTemperatureRequest;
import com.api.komposter.model.WebResponse;
import com.api.komposter.service.TemperatureService;

@RestController
public class TemperatureController {
    
    private String sensor = "Temperature";

    @Autowired
    private TemperatureService temperatureService;

    // CREATE -----------------------------------------------------------------------------------------
    @PostMapping(
        path = "/komposter/addData/temperatures",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<TemperatureResponse> addData(@RequestBody CreateTemperatureRequest request){

        TemperatureResponse createTemperature = temperatureService.create(request);
        return WebResponse.<TemperatureResponse>builder().sensor(sensor).data(createTemperature).build();
    }

    // READ --------------------------------------------------------------------------------------------
    @GetMapping(
        path = "/komposter/data/temperatures/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<TemperatureResponse> getData(@PathVariable("id") String id){
        TemperatureResponse temperatureResponse = temperatureService.getTemperature(id);
        return WebResponse.<TemperatureResponse>builder().sensor(sensor).data(temperatureResponse).build();
    }

    @GetMapping(
        path = "/komposter/data/temperatures",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<TemperatureResponse>> getAllData(){
        List<TemperatureResponse> temperatureResponse = temperatureService.getAllTemperature();
        return WebResponse.<List<TemperatureResponse>>builder().sensor(sensor).data(temperatureResponse ).build();
    }

    // UPDATE -------------------------------------------------------------------------------------------
    @PatchMapping(
        path = "/komposter/update/temperatures/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<TemperatureResponse> updateData(@PathVariable("id") String id, @RequestBody UpdateTemperatureRequest request){
        TemperatureResponse temperatureResponse = temperatureService.updateTemperature(id,request);
        return WebResponse.<TemperatureResponse>builder().sensor(sensor).data(temperatureResponse).build();
    }

    // DELETE -------------------------------------------------------------------------------------------
    @DeleteMapping(
        path = "/komposter/delete/temperatures/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> deleteData(@PathVariable("id") String id){
        temperatureService.deleteTemperature(id);
        return WebResponse.<String>builder().sensor(sensor).data("Succsess").build();
    }
}
