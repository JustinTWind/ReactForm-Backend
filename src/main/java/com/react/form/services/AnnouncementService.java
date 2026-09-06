package com.react.form.services;

import com.react.form.models.Announcement;
import com.react.form.models.User;
import com.react.form.repositories.IAnnouncementRepository;
import com.react.form.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class AnnouncementService {

    @Autowired
    private IAnnouncementRepository announcementRepository;

    @Autowired
    private IUserRepository userRepository;

    /**
     * Just the bare minimum xd : resolve author by id if provided, set createdAt, and then the save.
     */
    public Announcement createAnnouncement(Announcement announcement) {
        if (announcement.getCreatedAt() == null) {
            announcement.setCreatedAt(LocalDateTime.now());
        }
        if (announcement.getActive() == null) {
            announcement.setActive(Boolean.TRUE);
        }
        // If frontend sent only author.id, resolve full User entity
        if (announcement.getAuthor() != null && announcement.getAuthor().getId() != null) {
            Optional<User> authorOpt = userRepository.findById(announcement.getAuthor().getId());
            authorOpt.ifPresent(announcement::setAuthor);
        }
        return announcementRepository.save(announcement);
    }
}
