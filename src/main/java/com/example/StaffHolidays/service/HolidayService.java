package com.example.StaffHolidays.service;

import com.example.StaffHolidays.model.Holiday;
import com.example.StaffHolidays.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayService {
    @Autowired
    private HolidayRepository holidayRepository;

    public List<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }

    public Holiday getHolidayById(Long id) {
        return holidayRepository.findById(id).orElse(null);
    }

    public Holiday saveHoliday(Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    public void deleteHoliday(Long id) {
        holidayRepository.deleteById(id);
    }
}
