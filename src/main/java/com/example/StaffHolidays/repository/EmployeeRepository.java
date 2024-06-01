package com.example.StaffHolidays.repository;

import com.example.StaffHolidays.model.Employee;
import com.example.StaffHolidays.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee getByName(String name);
}
