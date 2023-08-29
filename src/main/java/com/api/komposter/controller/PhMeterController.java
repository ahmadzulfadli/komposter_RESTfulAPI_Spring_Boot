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

import com.api.komposter.model.CreatePhMeterRequest;
import com.api.komposter.model.PhMeterResponse;
import com.api.komposter.model.UpdatePhMeterRequest;
import com.api.komposter.model.WebResponse;
import com.api.komposter.service.PhMeterService;

import jakarta.annotation.Generated;

@RestController
public class PhMeterController {

    private String sensor = "Ph-Meter";
    
    @Autowired
    private PhMeterService phMeterService;

    // CREATE -----------------------------------------------------------------------------------------
    @PostMapping(
        path = "/komposter/addData/phMeters",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<PhMeterResponse> addData(@RequestBody CreatePhMeterRequest request){
        PhMeterResponse phMeterReponse = phMeterService.create(request);
        return WebResponse.<PhMeterResponse>builder().sensor(sensor).data(phMeterReponse).build();
    }

    // READ -------------------------------------------------------------------------------------------
    @GetMapping(
        path = "/komposter/data/phMeters/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<PhMeterResponse> getData(@PathVariable("id") String id){
        PhMeterResponse phMeterResponse = phMeterService.getPhMeter(id);
        return WebResponse.<PhMeterResponse>builder().sensor(sensor).data(phMeterResponse).build();
    }

    @GetMapping(
        path = "/komposter/data/phMeters",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<PhMeterResponse>> getAllData(){
        List<PhMeterResponse> phMeterResponse = phMeterService.getAllPhMeter();
        return WebResponse.<List<PhMeterResponse>>builder().sensor(sensor).data(phMeterResponse).build();
    }

    // UPDATE -----------------------------------------------------------------------------------------
    @PatchMapping(
        path = "/komposter/update/phMeters/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<PhMeterResponse> updateData(@PathVariable("id") String id,@RequestBody UpdatePhMeterRequest request){
        PhMeterResponse phMeterResponse = phMeterService.updatePhMeter(id, request);
        return WebResponse.<PhMeterResponse>builder().sensor(sensor).data(phMeterResponse).build();
    }

    // DELETE -----------------------------------------------------------------------------------------
    @DeleteMapping(
        path = "/komposter/delete/phMeters/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> deleteData(@PathVariable("id") String id){
        phMeterService.deletePhMeter(id);
        return WebResponse.<String>builder().sensor(sensor).data("Succsess").build();
    }


}
