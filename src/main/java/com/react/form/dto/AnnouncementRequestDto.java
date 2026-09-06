package com.react.form.dto;

import java.util.UUID;

public class AnnouncementRequestDto {
    private String title;
    private String message;
    private UUID authorId;      // optional
    private String authorEmail; // optional
    private String author;      // optional (uuid or email)
    private Boolean active;     // optional
    private String expiresAt;    // optional ISO-8601 string, e.g. "2026-09-07T15:30:00"

    public AnnouncementRequestDto() {}

    public String getTitle() { return title; }
    public String getMessage() { return message; }
    public UUID getAuthorId() { return authorId; }
    public String getAuthorEmail() { return authorEmail; }
    public String getAuthor() { return author; }
    public Boolean getActive() { return active; }
    public String getExpiresAt() { return expiresAt; }
}
