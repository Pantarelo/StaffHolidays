package com.example.StaffHolidays.util;

import java.time.LocalTime;

public class TimeInterval extends Pair<LocalTime,LocalTime> {
    public TimeInterval(LocalTime beginHour, LocalTime endHour) {
        this.setValue1(beginHour);
        this.setValue2(endHour);
    }

    public TimeInterval() {

    }
}
