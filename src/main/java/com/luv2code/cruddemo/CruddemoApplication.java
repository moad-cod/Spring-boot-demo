package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return  runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// Create multiple students
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("Mouad", "Med", "XXXXX@gmail.com");
		Student tempStudent2 = new Student("Mari", "choa", "YYYYY@gmail.com");
		Student tempStudent3 = new Student("Jhon", "jaki", "WWWWW@gmail.com");

		// Save the student objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// Display id of the saved students
		System.out.println("Saved student1 id: "+ tempStudent1.getId());
		System.out.println("Saved student2 id: "+ tempStudent2.getId());
		System.out.println("Saved student3 id: "+ tempStudent3.getId());

	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating knew student...");
		Student tempStudent = new Student("Mouad", "Med", "XXXXX@gmail.com");


		// save the student object
		System.out.println("Saving the student student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student id: "+ tempStudent.getId());
	}
}
