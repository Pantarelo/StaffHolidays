package com.example.StaffHolidays.repository;

import com.example.StaffHolidays.model.TouristAttractions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TouristAttractionsRepository extends JpaRepository<TouristAttractions, Long> {
}
