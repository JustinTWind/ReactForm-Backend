package com.react.form.dto;

public class FacilityRequestDto {
    private String name;
    private String description;
    private int capacity;
    private boolean active;
    private String location;

    public FacilityRequestDto() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}