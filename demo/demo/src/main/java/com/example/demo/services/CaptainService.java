package com.example.demo.services;

import com.example.demo.models.captains;
import com.example.demo.repositories.CaptainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaptainService {

    private final CaptainRepository captainRepository;

    public CaptainService(CaptainRepository captainRepository) {
        this.captainRepository = captainRepository;
    }

    // 8.1.2.1 Add Captain
    public captains addCaptain(captains captains) {
        return captainRepository.save(captains);
    }

    // 8.1.2.2 Get All Captains
    public List<captains> getAllCaptains() {
        return captainRepository.findAll();
    }

    // 8.1.2.3 Get Captain By ID
    public captains getCaptainById(Long id) {
        return captainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Captain not found with ID: " + id));
    }

    // 8.1.2.4 Filter by Rating
    public List<captains> getCaptainsByRating(Double ratingThreshold) {
        return captainRepository.findByAvgRatingScoreGreaterThan(ratingThreshold);
    }

    // 8.1.2.5 Filter by License Number
    public captains getCaptainByLicenseNumber(String licenseNumber) {
        captains captains = captainRepository.findByLicenseNumber(licenseNumber);
        if (captains == null) {
            throw new RuntimeException("Captain not found with license number: " + licenseNumber);
        }
        return captains;
    }
}

