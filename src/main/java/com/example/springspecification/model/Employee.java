package com.example.springspecification.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstname;

    @Column(name = "LAST_NAME")
    private String lastname;

    @Column(name = "DEPARTMENT_NAME")
    private String department;

    public Employee(String firstname, String lastname, String department) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
    }
}
