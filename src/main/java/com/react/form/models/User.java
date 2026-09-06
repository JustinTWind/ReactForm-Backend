package com.react.form.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;
    private String email;
    private String hashedPassword;
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Boolean active = true;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // prevent infinite recursion when serializing User -> Announcement -> User
    private List<Announcement> announcements = new ArrayList<>();

    public User() {}

    public User(UUID id, String username, String email, String hashedPassword, String fullName, Role role, Boolean active, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.fullName = fullName;
        this.role = role;
        this.active = active;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(List<Announcement> announcements) {
        this.announcements = announcements;
    }

    public void addAnnouncement(Announcement announcement) {
        announcements.add(announcement);
        announcement.setAuthor(this);
    }

    public void removeAnnouncement(Announcement announcement) {
        announcements.remove(announcement);
        announcement.setAuthor(null);
    }
}
