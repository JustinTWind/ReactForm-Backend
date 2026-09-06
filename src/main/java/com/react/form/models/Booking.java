package com.react.form.models;

import java.util.UUID;

/**
 * Scaffold
 */
public class Booking {
    private UUID id;
    private UUID userId;     // TODO: replace with User reference when adding relationships
    private UUID facilityId; // TODO: replace with Facility reference when adding relationships
    private String startAt;  // TODO: use ISO-8601 strings or LocalDateTime when adopting Java time
    private String endAt;    // TODO: same as above
    private String status;   // e.g. "PENDING", "CONFIRMED", "CANCELLED" use a Enum, don't be lazy
    private String notes;
    // TODO: Change the properties also

    public Booking() {}

    public Booking(UUID id, UUID userId, UUID facilityId, String startAt, String endAt, String status, String notes) {
        this.id = id;
        this.userId = userId;
        this.facilityId = facilityId;
        this.startAt = startAt;
        this.endAt = endAt;
        this.status = status;
        this.notes = notes;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(UUID facilityId) {
        this.facilityId = facilityId;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
