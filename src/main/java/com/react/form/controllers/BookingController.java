package com.react.form.controllers;

import com.react.form.dto.BookingRequestDto;
import com.react.form.dto.BookingResponseDto;
import com.react.form.services.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BookingResponseDto> create(@RequestBody BookingRequestDto dto) {
        BookingResponseDto response = service.createBooking(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}