package com.example.StaffHolidays;

import com.example.StaffHolidays.util.TimeInterval;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Attraction {
    private TimeInterval timetable = new TimeInterval(); ;
    private String name;

    public void setTimetable(TimeInterval time) {
        this.timetable = time;
    }

    public TimeInterval getTimetable() {
        return this.timetable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}