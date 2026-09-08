package com.react.form.repositories;

import com.react.form.models.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility, UUID> {
}