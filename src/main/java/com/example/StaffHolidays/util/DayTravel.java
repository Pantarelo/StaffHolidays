package com.example.StaffHolidays.util;

import com.example.StaffHolidays.Attraction;

import java.time.LocalDate;
import java.util.List;

public class DayTravel extends Pair<LocalDate, List<Attraction>> {

    public DayTravel(List<Attraction> attractions) {
        this.setValue2(attractions);
    }
}
