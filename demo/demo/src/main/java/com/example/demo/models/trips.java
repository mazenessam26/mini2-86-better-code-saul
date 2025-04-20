package com.example.demo.models;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class trips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime tripDate;
    private String origin;
    private String destination;
    private Double tripCost;

    @ManyToOne
    @JoinColumn(name = "captain_id")
    private captains captains;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private customers customers;

    @OneToOne(mappedBy = "trip", cascade = CascadeType.ALL)
    private payments payments;

    public trips() {}

    public trips(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public trips(Long id, LocalDateTime tripDate, String origin, String destination, Double tripCost) {
        this.id = id;
        this.tripDate = tripDate;
        this.origin = origin;
        this.destination = destination;
        this.tripCost = tripCost;
    }

    // Getters and setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTripDate() {
        return tripDate;
    }

    public void setTripDate(LocalDateTime tripDate) {
        this.tripDate = tripDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getTripCost() {
        return tripCost;
    }

    public void setTripCost(Double tripCost) {
        this.tripCost = tripCost;
    }

    public captains getCaptain() {
        return captains;
    }

    public void setCaptain(captains captains) {
        this.captains = captains;
    }

    public customers getCustomer() {
        return customers;
    }

    public void setCustomer(customers customers) {
        this.customers = customers;
    }

    public payments getPayment() {
        return payments;
    }

    public void setPayment(payments payments) {
        this.payments = payments;
    }
}

