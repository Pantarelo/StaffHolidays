package com.example.StaffHolidays.controller;

import com.example.StaffHolidays.model.TouristAttractions;
import com.example.StaffHolidays.service.TouristAttractionsService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attractions")
public class TouristAttractionsController {
    @Autowired
    private TouristAttractionsService touristAttractionsService;

    @GetMapping
    public List<TouristAttractions> getAllAttractions() {
        return touristAttractionsService.getAllAttractions();
    }

    @GetMapping("/{id}")
    public TouristAttractions getAttractionById(@PathVariable Long id) {
        return touristAttractionsService.getAttractionById(id);
    }

    @PostMapping
    public TouristAttractions createAttraction(@RequestBody TouristAttractions attraction) {
        return touristAttractionsService.saveAttraction(attraction);
    }

    @DeleteMapping("/{id}")
    public void deleteAttraction(@PathVariable Long id) {
        touristAttractionsService.deleteAttraction(id);
    }

//    @GetMapping("/trip/{id}")
//    public List<TouristAttractions> getTrip(@PathVariable Long id) {
//        return touristAttractionsService.getTrip(id);
//    }
}
