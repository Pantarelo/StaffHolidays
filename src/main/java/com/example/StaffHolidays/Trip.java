package com.example.StaffHolidays;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Trip {
    private String cityName;
    private LocalDate startTripDate;
    private LocalDate endTripDate;
    private List<Attraction> touristAttraction;

    public Trip()
    {
        this.startTripDate = LocalDate.of(2024,3,15);
        this.endTripDate = LocalDate.of(2024,3, 16);
        touristAttraction = new ArrayList<>();
    }
    public String getCityName() {
        return this.cityName;
    }

    public LocalDate getStartTripDate() {
        return startTripDate;
    }

    public LocalDate getEndTripDate() {
        return endTripDate;
    }

    public List<Attraction> getTouristAttraction() {
        return this.touristAttraction;
    }

    public void addTouristAttraction(Attraction ... attractions) {

        for (Attraction attraction : attractions)
        {
            if(attraction != null)
                this.touristAttraction.add(attraction);
        }

    }

    public void printAttractions()
    {
        for (Attraction attraction : touristAttraction)
        {
            System.out.println(attraction.getName());
        }
    }
}
