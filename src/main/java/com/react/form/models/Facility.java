package com.react.form.models;

import java.util.UUID;

/**
 * Scaffold
 */
public class Facility {
    private UUID id;
    private String name;
    private String description;
    private int capacity;
    private boolean active;
    private String location; // TODO: replace with structured Location object if needed
    // TODO: Change the properties buddy

    public Facility() {}

    public Facility(UUID id, String name, String description, int capacity, boolean active, String location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.active = active;
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
