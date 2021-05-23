package com.example.springspecification.repository;

import com.example.springspecification.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCustomRepo {
    List<Employee> findByFirstNameAndLastName(String firstname, String lastname);
}
