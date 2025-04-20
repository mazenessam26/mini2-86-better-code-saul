package com.example.demo.services;

import com.example.demo.models.ratings;
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
    public ratings addRating(ratings ratings) {
        return ratingRepository.save(ratings);
    }

    // 8.5.2.2 Update Rating
    public ratings updateRating(String id, ratings updatedRatings) {
        ratings existingRatings = ratingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rating not found with ID: " + id));
        existingRatings.setScore(updatedRatings.getScore());
        existingRatings.setComment(updatedRatings.getComment());
        existingRatings.setEntityId(updatedRatings.getEntityId());
        existingRatings.setEntityType(updatedRatings.getEntityType());
        return ratingRepository.save(existingRatings);
    }

    // 8.5.2.3 Delete Rating
    public void deleteRating(String id) {
        if (!ratingRepository.existsById(id)) {
            throw new RuntimeException("Rating not found with ID: " + id);
        }
        ratingRepository.deleteById(id);
    }

    // 8.5.2.4 Get Ratings By Entity
    public List<ratings> getRatingsByEntity(Long entityId, String entityType) {
        return ratingRepository.findByEntityIdAndEntityType(entityId, entityType);
    }

    // 8.5.2.5 Find Ratings Above a Specific Value
    public List<ratings> findRatingsAboveScore(int minScore) {
        return ratingRepository.findByScoreGreaterThan(minScore);
    }
}

