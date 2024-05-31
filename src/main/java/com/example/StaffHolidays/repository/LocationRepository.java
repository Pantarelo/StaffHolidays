package com.example.StaffHolidays.repository;

import com.example.StaffHolidays.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Location getLocationByName(String name);
    Location deleteLocationByName(String name);
}
