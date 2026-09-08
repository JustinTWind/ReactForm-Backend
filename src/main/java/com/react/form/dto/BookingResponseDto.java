package com.react.form.dto;

import java.util.UUID;

public class BookingResponseDto {
    private UUID id;
    private String userEmail;
    private String facilityName;
    private String startAt;
    private String endAt;
    private String status;
    private String notes;

    public BookingResponseDto() {}

    public BookingResponseDto(UUID id, String userEmail, String facilityName, String startAt, String endAt, String status, String notes) {
        this.id = id;
        this.userEmail = userEmail;
        this.facilityName = facilityName;
        this.startAt = startAt;
        this.endAt = endAt;
        this.status = status;
        this.notes = notes;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getFacilityName() { return facilityName; }
    public void setFacilityName(String facilityName) { this.facilityName = facilityName; }

    public String getStartAt() { return startAt; }
    public void setStartAt(String startAt) { this.startAt = startAt; }

    public String getEndAt() { return endAt; }
    public void setEndAt(String endAt) { this.endAt = endAt; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}