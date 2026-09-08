package com.react.form.repositories;

import com.react.form.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, UUID> {
}