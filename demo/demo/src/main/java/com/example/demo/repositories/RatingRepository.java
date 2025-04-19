package com.example.demo.repositories;
import com.example.demo.models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {

    // Find ratings by entity ID and type
    List<Rating> findByEntityIdAndEntityType(Long entityId, String entityType);

    // Find ratings with score above a value
    List<Rating> findByScoreGreaterThan(Integer score);
}

