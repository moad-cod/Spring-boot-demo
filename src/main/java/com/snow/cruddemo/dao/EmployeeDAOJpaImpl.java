package com.snow.cruddemo.dao;

import com.snow.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define field dor entityManager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results

        return employees;
    }

    // we don't use @Transactional at DAO layer it will be handled at Service layer
    @Override
    public Employee findById(int theId) {

        // get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);
        // return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        // save employee
        Employee dbEmployee = entityManager.merge(theEmployee); // if id == 0 then insert/save else update

        // return employee
        return dbEmployee;
    }

    @Override
    public void deleteByID(int theId) {

        // find employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // delete employee
        entityManager.remove(theEmployee);
    }
}
