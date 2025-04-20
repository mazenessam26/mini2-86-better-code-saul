package com.example.demo.repositories;

import com.example.demo.models.captains;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaptainRepository extends JpaRepository<captains, Long> {

    // Find all captains with rating above a threshold
    List<captains> findByAvgRatingScoreGreaterThan(Double threshold);

    // Find captain by license number
    captains findByLicenseNumber(String licenseNumber);
}

