package com.example.springspecification.repository;

import com.example.springspecification.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeCustomRepoImpl implements EmployeeCustomRepo {
    private EntityManager entityManager;

    @Autowired
    public EmployeeCustomRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findByFirstNameAndLastName(String firstname, String lastname) {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery cq=cb.createQuery(Employee.class);

        Root<Employee> employee=cq.from(Employee.class);

        Predicate firstNamePredicate=cb.equal(employee.get("firstname"),firstname);
        Predicate lastNamePredicate=cb.equal(employee.get("lastname"),lastname);

        cq.where(firstNamePredicate, lastNamePredicate);

        TypedQuery<Employee> query=entityManager.createQuery(cq);
        return query.getResultList();
    }
}
