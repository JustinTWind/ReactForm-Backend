package com.react.form.controllers;

import com.react.form.dto.FacilityRequestDto;
import com.react.form.dto.FacilityResponseDto;
import com.react.form.services.FacilityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/facilities")
public class FacilityController {
    private final FacilityService service;

    public FacilityController(FacilityService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FacilityResponseDto> create(@RequestBody FacilityRequestDto dto) {
        FacilityResponseDto response = service.createFacility(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}