package com.example.demo.repositories;
import com.example.demo.models.ratings;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RatingRepository extends MongoRepository<ratings, String> {

    // Find ratings by entity ID and type
    List<ratings> findByEntityIdAndEntityType(Long entityId, String entityType);

    // Find ratings with score above a value
    List<ratings> findByScoreGreaterThan(Integer score);
}

