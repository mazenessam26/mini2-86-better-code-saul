package com.example.demo.services;
import com.example.demo.models.Trip;
import com.example.demo.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    // 8.3.2.1 Add Trip
    public Trip addTrip(Trip Trip) {
        return tripRepository.save(Trip);
    }

    // 8.3.2.2 Get All Trips
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    // 8.3.2.3 Get Trip By ID
    public Trip getTripById(Long id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with ID: " + id));
    }

    // 8.3.2.4 Update Trip
    public Trip updateTrip(Long id, Trip updatedTrip) {
        Trip existingTrip = getTripById(id);
        existingTrip.setTripDate(updatedTrip.getTripDate());
        existingTrip.setOrigin(updatedTrip.getOrigin());
        existingTrip.setDestination(updatedTrip.getDestination());
        existingTrip.setTripCost(updatedTrip.getTripCost());
        existingTrip.setCaptain(updatedTrip.getCaptain());
        existingTrip.setCustomer(updatedTrip.getCustomer());
        return tripRepository.save(existingTrip);
    }

    // 8.3.2.5 Delete Trip
    public void deleteTrip(Long id) {

        tripRepository.deleteById(id);
    }

    // 8.3.2.6 Find Trips Within a Date Range
    public List<Trip> findTripsWithinDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return tripRepository.findByTripDateBetween(startDate, endDate);
    }

    // 8.3.2.7 Find Trips By Captain ID
    public List<Trip> findTripsByCaptainId(Long captainId) {
        return tripRepository.findByCaptainId(captainId);
    }
}

