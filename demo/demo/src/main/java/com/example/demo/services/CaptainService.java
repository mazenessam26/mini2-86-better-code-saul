package com.example.demo.services;

import com.example.demo.models.Captain;
import com.example.demo.repositories.CaptainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaptainService {

    private final CaptainRepository captainRepository;

    @Autowired
    public CaptainService(CaptainRepository captainRepository) {
        this.captainRepository = captainRepository;
    }

    // 8.1.2.1 Add Captain
    public Captain addCaptain(Captain Captain) {
        return captainRepository.save(Captain);
    }

    // 8.1.2.2 Get All Captains
    public List<Captain> getAllCaptains() {
        return captainRepository.findAll();
    }

    // 8.1.2.3 Get Captain By ID
    public Captain getCaptainById(Long id) {
        return captainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Captain not found with ID: " + id));
    }

    // 8.1.2.4 Filter by Rating
    public List<Captain> getCaptainsByRating(Double ratingThreshold) {
        return captainRepository.findByAvgRatingScoreGreaterThan(ratingThreshold);
    }

    // 8.1.2.5 Filter by License Number
    public Captain getCaptainByLicenseNumber(String licenseNumber) {
        return captainRepository.findByLicenseNumber(licenseNumber);
//        if (Captain == null) {
//            throw new RuntimeException("Captain not found with license number: " + licenseNumber);
//        }

    }
}

