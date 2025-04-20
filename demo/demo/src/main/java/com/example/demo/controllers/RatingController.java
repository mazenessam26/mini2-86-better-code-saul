package com.example.demo.controllers;

import com.example.demo.models.ratings;
import com.example.demo.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    // 9.5.2.1 Add Rating
    @PostMapping("/addRating")
    public ratings addRating(@RequestBody ratings ratings) {
        return ratingService.addRating(ratings);
    }

    // 9.5.2.2 Update Rating
    @PutMapping("/update/{id}")
    public ratings updateRating(@PathVariable String id, @RequestBody ratings updatedRatings) {
        return ratingService.updateRating(id, updatedRatings);
    }

    // 9.5.2.3 Delete Rating
    @DeleteMapping("/delete/{id}")
    public String deleteRating(@PathVariable String id) {
        ratingService.deleteRating(id);
        return "Rating with ID " + id + " deleted successfully.";
    }

    // 9.5.2.4 Find Ratings For a Specific Entity
    @GetMapping("/findByEntity")
    public List<ratings> findRatingsByEntity(@RequestParam Long entityId, @RequestParam String entityType) {
        return ratingService.getRatingsByEntity(entityId, entityType);
    }

    // 9.5.2.5 Find Ratings Above a Specific Value
    @GetMapping("/findAboveScore")
    public List<ratings> findRatingsAboveScore(@RequestParam int minScore) {
        return ratingService.findRatingsAboveScore(minScore);
    }
}
