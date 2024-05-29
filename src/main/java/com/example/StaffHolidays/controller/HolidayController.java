package com.example.StaffHolidays.controller;

import com.example.StaffHolidays.model.Holiday;
import com.example.StaffHolidays.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holiday")
public class HolidayController {
    @Autowired
    private HolidayService holidayService;

    @GetMapping
    public List<Holiday> getAllHolidays() {
        return holidayService.getAllHolidays();
    }

    @GetMapping("/{id}")
    public Holiday getHolidayById(@PathVariable Long id) {
        return holidayService.getHolidayById(id);
    }

    @PostMapping
    public Holiday createHoliday(@RequestBody Holiday holiday) {
        return holidayService.saveHoliday(holiday);
    }

    @DeleteMapping("/{id}")
    public void deleteHoliday(@PathVariable Long id) {
        holidayService.deleteHoliday(id);
    }
}
