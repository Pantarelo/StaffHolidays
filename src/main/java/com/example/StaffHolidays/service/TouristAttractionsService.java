package com.example.StaffHolidays.service;

import com.example.StaffHolidays.model.TouristAttractions;
import com.example.StaffHolidays.repository.TouristAttractionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristAttractionsService {
    @Autowired
    private TouristAttractionsRepository touristAttractionsRepository;

    public List<TouristAttractions> getAllAttractions() {
        return touristAttractionsRepository.findAll();
    }

    public TouristAttractions getAttractionById(Long id) {
        return touristAttractionsRepository.findById(id).orElse(null);
    }

    public TouristAttractions saveAttraction(TouristAttractions attraction) {
        return touristAttractionsRepository.save(attraction);
    }

    public void deleteAttraction(Long id) {
        touristAttractionsRepository.deleteById(id);
    }

}
