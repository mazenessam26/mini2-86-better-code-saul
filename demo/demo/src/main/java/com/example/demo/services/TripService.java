package com.example.demo.services;
import com.example.demo.models.trips;
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
    public trips addTrip(trips trips) {
        return tripRepository.save(trips);
    }

    // 8.3.2.2 Get All Trips
    public List<trips> getAllTrips() {
        return tripRepository.findAll();
    }

    // 8.3.2.3 Get Trip By ID
    public trips getTripById(Long id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with ID: " + id));
    }

    // 8.3.2.4 Update Trip
    public trips updateTrip(Long id, trips updatedTrips) {
        trips existingTrips = getTripById(id);
        existingTrips.setTripDate(updatedTrips.getTripDate());
        existingTrips.setOrigin(updatedTrips.getOrigin());
        existingTrips.setDestination(updatedTrips.getDestination());
        existingTrips.setTripCost(updatedTrips.getTripCost());
        existingTrips.setCaptain(updatedTrips.getCaptain());
        existingTrips.setCustomer(updatedTrips.getCustomer());
        return tripRepository.save(existingTrips);
    }

    // 8.3.2.5 Delete Trip
    public void deleteTrip(Long id) {
        if (!tripRepository.existsById(id)) {
            throw new RuntimeException("Trip not found with ID: " + id);
        }
        tripRepository.deleteById(id);
    }

    // 8.3.2.6 Find Trips Within a Date Range
    public List<trips> findTripsWithinDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return tripRepository.findByTripDateBetween(startDate, endDate);
    }

    // 8.3.2.7 Find Trips By Captain ID
    public List<trips> findTripsByCaptainId(Long captainId) {
        return tripRepository.findByCaptainId(captainId);
    }
}

