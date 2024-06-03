package com.example.StaffHolidays.controller;

import com.example.StaffHolidays.Attraction;
import com.example.StaffHolidays.TravelPlan;
import com.example.StaffHolidays.Trip;
import com.example.StaffHolidays.model.Location;
import com.example.StaffHolidays.model.TouristAttractions;
import com.example.StaffHolidays.service.LocationService;
import com.example.StaffHolidays.util.TimeInterval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/{name}")
    public Location getLocationByName(@PathVariable String name) {
        return locationService.getLocationByName(name);
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationService.saveLocation(location);
    }

    @GetMapping("/attractions/{name}")
    public List<TouristAttractions> getAttractions(@PathVariable String name) {
        return locationService.getTouristAttractions(name);
    }

    @GetMapping("/attractions/{name}/trip")
    public List<Attraction> getTrip(@PathVariable String name)
    {
        List<TouristAttractions> attractions = getAttractions(name);

        Attraction []touristAttractions = new Attraction[attractions.size()];

        for (int i = 0; i < attractions.size(); i++)
        {
            touristAttractions[i] = new Attraction();
            touristAttractions[i].setName(attractions.get(i).getName());
            touristAttractions[i].setTimetable(new TimeInterval(attractions.get(i).getOpeningTime(), attractions.get(i).getCloseTime()));
        }

        Trip trip = new Trip();

        trip.addTouristAttraction(touristAttractions);

        TravelPlan travelPlan = new TravelPlan();

        travelPlan.setTrip(trip);

        travelPlan.setTravelPlan();

        List<Attraction> tripAttractions = travelPlan.getTrip();

        return tripAttractions;


//        List<TouristAttractions> touristAttractionsList = new ArrayList<>();
//
//        for (Attraction attraction: tripAttractions)
//        {
//            touristAttractionsList.add(new TouristAttractions(attraction.getName(),attraction.getTimetable().getValue1(), attraction.getTimetable().getValue2(),new Location(name)));
//        }
//
//
//        return touristAttractionsList;
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteLocation(@PathVariable String name) {
        boolean isDeleted = locationService.deleteLocation(name);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
