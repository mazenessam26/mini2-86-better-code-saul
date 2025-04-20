package com.example.demo.repositories;
import com.example.demo.models.trips;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface TripRepository extends JpaRepository<trips, Long> {

    // Find trips between two dates
    List<trips> findByTripDateBetween(LocalDateTime start, LocalDateTime end);

    // Find trips by captain ID
    List<trips> findByCaptainId(Long captainId);
}

