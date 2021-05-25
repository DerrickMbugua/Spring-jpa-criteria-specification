package com.example.springspecification.controller;

import com.example.springspecification.model.Employee;
import com.example.springspecification.repository.EmployeeRepository;
import com.example.springspecification.specifications.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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

@GetMapping("/employees/{firstname}/{department}")
    public List<Employee> findByFirstNameAndLastName(@PathVariable(name = "firstname") String firstname,
                                                     @PathVariable(name = "department") String department){
    Specification<Employee> specifications=Specification.where(EmployeeSpecification.hasFirstName(firstname)
            .and(EmployeeSpecification.hasDepartment(department)));
        return employeeRepository.findAll(specifications);
    }

    @GetMapping("/employees/{lastname}")
    public List<Employee> findByLastname(@PathVariable("lastname") String lastname){
        Specification<Employee> specifications=Specification.where(EmployeeSpecification.containsLastName(lastname));
        return employeeRepository.findAll(specifications);
    }

}
