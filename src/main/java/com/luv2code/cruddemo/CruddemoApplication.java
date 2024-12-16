package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return  runner -> {
			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudenets(studentDAO);

			queryForStudentsByLastName(studentDAO);
		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("choa");

		// display list of students
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void queryForStudenets(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// Create a student object
		System.out.println("Creating new student object...");
		Student tempstudent = new Student("Mouad", "Med", "XXXXX@gmail.com");

		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempstudent);
		// display id student based on the id: primary key
		int theID = tempstudent.getId();
		System.out.println("Saved student. Generated ID: " + theID);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with ID: " + theID);
		Student myStudent = studentDAO.findById(theID);

		// display student
		System.out.println("Found the student:  " + myStudent);
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
