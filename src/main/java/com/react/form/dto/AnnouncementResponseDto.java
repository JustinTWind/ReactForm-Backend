package com.react.form.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class AnnouncementResponseDto {
    private UUID id;
    private String title;
    private String message;
    private UUID authorId;
    private String authorUsername;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;

    public AnnouncementResponseDto() {}

    public UUID getId() { return id; }
    public String getTitle() { return title; }
    public String getMessage() { return message; }
    public UUID getAuthorId() { return authorId; }
    public String getAuthorUsername() { return authorUsername; }
    public Boolean getActive() { return active; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getExpiresAt() { return expiresAt; }

    public void setId(UUID id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setMessage(String message) { this.message = message; }
    public void setAuthorId(UUID authorId) { this.authorId = authorId; }
    public void setAuthorUsername(String authorUsername) { this.authorUsername = authorUsername; }
    public void setActive(Boolean active) { this.active = active; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setExpiresAt(LocalDateTime expiresAt) { this.expiresAt = expiresAt; }
}
