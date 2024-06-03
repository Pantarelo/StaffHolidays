package com.example.StaffHolidays.service;

import com.example.StaffHolidays.model.Location;
import com.example.StaffHolidays.model.TouristAttractions;
import com.example.StaffHolidays.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationByName(String name) {
        return locationRepository.getLocationByName(name);
    }

    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    public List<TouristAttractions> getTouristAttractions(String name) {
        Location location = getLocationByName(name);
        return location.getAttractions();
    }

    public boolean deleteLocation(String name) {
        Location location = locationRepository.getLocationByName(name);
        if (location != null) {
            locationRepository.delete(location);
            return true;
        }
        return false;
    }
}
