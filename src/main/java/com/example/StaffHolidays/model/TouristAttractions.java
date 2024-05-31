package com.example.StaffHolidays.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table (name = "attractions")
public class TouristAttractions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalTime openingTime;
    private LocalTime closeTime;
    @ManyToOne
    @JoinColumn(name = "id_location", nullable = false)
    @JsonIgnore
    private Location location;

    public TouristAttractions() {

    }

    public TouristAttractions(String name, LocalTime openingTime, LocalTime closeTime, Location location) {
        this.name = name;
        this.openingTime = openingTime;
        this.closeTime = closeTime;
        this.location = location;
    }

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

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
