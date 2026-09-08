package com.react.form.services;

import com.react.form.dto.FacilityRequestDto;
import com.react.form.dto.FacilityResponseDto;
import com.react.form.models.Facility;
import com.react.form.repositories.IFacilityRepository;
import org.springframework.stereotype.Service;

@Service
public class FacilityService {
    private final IFacilityRepository repository;

    public FacilityService(IFacilityRepository repository) {
        this.repository = repository;
    }

    public FacilityResponseDto createFacility(FacilityRequestDto dto) {
        Facility facility = new Facility();
        facility.setName(dto.getName());
        facility.setDescription(dto.getDescription());
        facility.setCapacity(dto.getCapacity());
        facility.setActive(dto.isActive());
        facility.setLocation(dto.getLocation());

        Facility saved = repository.save(facility);

        return new FacilityResponseDto(
            saved.getId(),
            saved.getName(),
            saved.getDescription(),
            saved.getCapacity(),
            saved.isActive(),
            saved.getLocation()
        );
    }
}