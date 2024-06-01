package com.example.StaffHolidays.service;

import com.example.StaffHolidays.model.Employee;
import com.example.StaffHolidays.model.Holiday;
import com.example.StaffHolidays.repository.EmployeeRepository;
import com.example.StaffHolidays.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    private HolidayRepository holidayRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee getByName(String name) { return employeeRepository.getByName(name);}

    public Employee getEmployeeById(Long id) { return employeeRepository.findById(id).orElse(null);}

    public List<Holiday> getAllHolidays(Long id) { Employee employee = getEmployeeById(id); return employee.getHolidays(); }
}
