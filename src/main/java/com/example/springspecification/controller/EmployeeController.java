package com.example.springspecification.controller;

import com.example.springspecification.model.Employee;
import com.example.springspecification.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping("/employee")
    public Employee postEmployees(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

@GetMapping("/employees/{firstname}/{lastname}")
    public List<Employee> findByFirstNameAndLastName(@PathVariable(name = "firstname") String firstname,
                                                     @PathVariable(name = "lastname") String lastname){
        return employeeRepository.findByFirstNameAndLastName(firstname, lastname);
    }
}
