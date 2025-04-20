package com.example.demo.models;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
public class captains {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String licenseNumber;
    private Double avgRatingScore;

    @OneToMany(mappedBy = "captain")
    private List<com.example.demo.models.trips> trips = new ArrayList<>();

    // Default constructor
    public captains() {
    }

    // Partial constructor
    public captains(String name, String licenseNumber,Double avgRatingScore) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.avgRatingScore = avgRatingScore;
    }

    // Full constructor
    public captains(Long id, String name, String licenseNumber, Double avgRatingScore) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.avgRatingScore = avgRatingScore;
    }

    // Getters and setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Double getAvgRatingScore() {
        return avgRatingScore;
    }

    public void setAvgRatingScore(Double avgRatingScore) {
        this.avgRatingScore = avgRatingScore;
    }

    public List<com.example.demo.models.trips> getTrips() {
        return trips;
    }

    public void setTrips(List<com.example.demo.models.trips> trips) {
        this.trips = trips;
    }
}

