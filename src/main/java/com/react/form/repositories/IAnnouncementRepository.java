package com.react.form.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.react.form.models.Announcement;
import java.util.UUID;

@Repository
public interface IAnnouncementRepository extends JpaRepository<Announcement, UUID> {
}
