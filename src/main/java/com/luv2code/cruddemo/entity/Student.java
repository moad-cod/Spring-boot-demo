package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

// JPA : enables Object-Relational Mapping (ORM),
// which allows to interact with databases using Java objects,
// without writing complex SQL queries.

// ==> EntityManager (Low-Level control)
@Entity // Mark a class as a JPA entity. A JPA entity represents a table in a relational database.
        // Each instance of this class corresponds to a row in the student table
@Table(name="student") // Specifies the name of the table in the database with which this entity is associated.
public class Student {

    // define fields

    @Id // Identifies the id field as the primary key of the table.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // utilise la fonctionnalité auto-increment de la base de données.) // Specifies the strategy for generating values for the primary key.
    @Column(name="id") // Associates the id field of the class with the id column of the table in the database.
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    // define constructors

    public Student() {

    }

    public Student(String firstName, String lastName,String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // define getters/setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // define toString() method


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
