package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student); // Declare a method to save a Student object to the database.

    Student findById(Integer id);

    // Add new method
    List<Student> findAll();

    List<Student> findByLastName(String TheLastName);
}
