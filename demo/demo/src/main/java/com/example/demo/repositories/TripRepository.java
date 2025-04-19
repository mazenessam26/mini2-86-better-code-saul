package com.example.demo.repositories;
import com.example.demo.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {

    // Find trips between two dates
    List<Trip> findByTripDateBetween(LocalDateTime start, LocalDateTime end);

    // Find trips by captain ID
    List<Trip> findByCaptainId(Long captainId);
}

