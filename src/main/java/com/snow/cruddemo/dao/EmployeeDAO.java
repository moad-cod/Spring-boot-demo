package com.snow.cruddemo.dao;

import com.snow.cruddemo.entity.Employee;

import java.util.List;
// Create DAO interface
public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteByID(int id);
}
