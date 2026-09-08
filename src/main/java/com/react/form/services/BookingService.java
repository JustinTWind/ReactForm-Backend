package com.react.form.services;

import com.react.form.dto.BookingRequestDto;
import com.react.form.dto.BookingResponseDto;
import com.react.form.models.Booking;
import com.react.form.repositories.IBookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final IBookingRepository repository;

    public BookingService(IBookingRepository repository) {
        this.repository = repository;
    }

    public BookingResponseDto createBooking(BookingRequestDto dto) {
        Booking booking = new Booking();
        booking.setUserEmail(dto.getUserEmail());
        booking.setFacilityName(dto.getFacilityName());
        booking.setStartAt(dto.getStartAt());
        booking.setEndAt(dto.getEndAt());
        booking.setStatus(dto.getStatus());
        booking.setNotes(dto.getNotes());

        Booking saved = repository.save(booking);

        return  new BookingResponseDto(
            saved.getId(),
            saved.getUserEmail(),
            saved.getFacilityName(),
            saved.getStartAt(),
            saved.getEndAt(),
            saved.getStatus(),
            saved.getNotes()
        );
    }
}