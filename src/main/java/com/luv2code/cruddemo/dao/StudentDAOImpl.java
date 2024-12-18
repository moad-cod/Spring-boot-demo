package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        entityManager.persist(theStudent); // JPA method to save an entity in the database.
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id); // (Entity class, Primary key)
    }

    @Override
    public List<Student> findAll() {

        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student", Student.class); // asc = A -> Z | desc = Z -> A

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String TheLastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        // set query parameters
        theQuery.setParameter("theData", TheLastName);

        // return query results
        return  theQuery.getResultList();

    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // retrieve the student
        Student theStudent = entityManager.find(Student.class, id);

        // delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate(); // executeUpdate() ==> generic term to modifying database
        return numRowsDeleted;
    }
}







