package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// DAO (Data Access Object) pour to manage operations on the Student entity
// (Use Spring and Hibernate to interact with the database)
@Repository // Spring type DAO
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager

    private EntityManager entityManager;

    // inject entity manager using constructor injection

    @Autowired // JPA (Java Persistence API)
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //Ensures that the save() method runs within a transaction
    public void save(Student theStudent) {
        entityManager.persist((theStudent)); // JPA method to save an entity in the database.
    }
}







