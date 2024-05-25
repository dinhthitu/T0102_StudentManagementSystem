package com.example.studentmanagementproject;

import com.example.studentmanagementproject.model.Student;
import com.example.studentmanagementproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(StudentManagementProjectApplication.class, args);
	}
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception{
        Student student1 = new Student(1, "tus", " dinh", "dinhtu@gmail.com");
		studentRepository.save(student1);
	}

}
