package com.example.demo.services;

import com.example.demo.models.Rating;
import com.example.demo.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    // 8.5.2.1 Add Rating
    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    // 8.5.2.2 Update Rating
    public Rating updateRating(String id, Rating updatedRating) {
        Rating existingRating = ratingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rating not found with ID: " + id));
        existingRating.setScore(updatedRating.getScore());
        existingRating.setComment(updatedRating.getComment());
        existingRating.setEntityId(updatedRating.getEntityId());
        existingRating.setEntityType(updatedRating.getEntityType());
        return ratingRepository.save(existingRating);
    }

    // 8.5.2.3 Delete Rating
    public void deleteRating(String id) {
        if (!ratingRepository.existsById(id)) {
            throw new RuntimeException("Rating not found with ID: " + id);
        }
        ratingRepository.deleteById(id);
    }

    // 8.5.2.4 Get Ratings By Entity
    public List<Rating> getRatingsByEntity(Long entityId, String entityType) {
        return ratingRepository.findByEntityIdAndEntityType(entityId, entityType);
    }

    // 8.5.2.5 Find Ratings Above a Specific Value
    public List<Rating> findRatingsAboveScore(int minScore) {
        return ratingRepository.findByScoreGreaterThan(minScore);
    }
}

