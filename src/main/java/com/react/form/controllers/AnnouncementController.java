package com.react.form.controllers;

import com.react.form.dto.AnnouncementRequestDto;
import com.react.form.dto.AnnouncementResponseDto;
import com.react.form.models.Announcement;
import com.react.form.models.User;
import com.react.form.repositories.IUserRepository;
import com.react.form.services.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private IUserRepository userRepository;

    @PostMapping
    public ResponseEntity<AnnouncementResponseDto> create(@RequestBody AnnouncementRequestDto req) {
        if (req == null || req.getTitle() == null || req.getMessage() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        try {
            Announcement announcement = new Announcement();
            announcement.setTitle(req.getTitle());
            announcement.setMessage(req.getMessage());
            announcement.setActive(req.getActive() != null ? req.getActive() : Boolean.TRUE);

            if (req.getAuthorId() != null) {
                Optional<User> u = userRepository.findById(req.getAuthorId());
                u.ifPresent(announcement::setAuthor);
            } else if (req.getAuthorEmail() != null) {
                Optional<User> u = userRepository.findByEmail(req.getAuthorEmail());
                u.ifPresent(announcement::setAuthor);
            } else if (req.getAuthor() != null) {
                try {
                    UUID parsed = UUID.fromString(req.getAuthor());
                    Optional<User> u = userRepository.findById(parsed);
                    u.ifPresent(announcement::setAuthor);
                } catch (IllegalArgumentException ex) {
                    Optional<User> u = userRepository.findByEmail(req.getAuthor());
                    u.ifPresent(announcement::setAuthor);
                }
            }

// parse expiresAt if provided (ISO-8601)
if (req.getExpiresAt() != null && !req.getExpiresAt().isBlank()) {
    try {
        java.time.LocalDateTime parsed = java.time.LocalDateTime.parse(req.getExpiresAt());
        announcement.setExpiresAt(parsed);
    } catch (Exception pe) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}

Announcement created = announcementService.createAnnouncement(announcement);

AnnouncementResponseDto resp = new AnnouncementResponseDto();
            resp.setId(created.getId());
            resp.setTitle(created.getTitle());
            resp.setMessage(created.getMessage());
            resp.setActive(created.getActive());
            resp.setCreatedAt(created.getCreatedAt());
            resp.setExpiresAt(created.getExpiresAt());
            if (created.getAuthor() != null) {
                resp.setAuthorId(created.getAuthor().getId());
                resp.setAuthorUsername(created.getAuthor().getUsername());
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(resp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
