package com.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.school.dto.StudentDTO;
import com.school.service.StudentService;

@SpringBootApplication
public class DemoSpringOrmMysqlApplication implements CommandLineRunner{

	@Autowired
	private StudentService studentService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringOrmMysqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//addStudent();
	//deleteStudent();
	   //displayStudent();
	
	updateStudent();
		
	}

	private void updateStudent() {
	    int roll=studentService.updateStudent(1, 0);
	    System.out.println(roll);
		
	}

	private void deleteStudent() {
		int roll=studentService.deleteStudent(2);
		System.out.println(roll);
		
	}

	private void displayStudent() {
		StudentDTO studentDTO=studentService.getStudent(2);
		System.out.println(studentDTO);
	}

	private void addStudent() {
		StudentDTO studentDTO=new StudentDTO(2,"Ashok",100);
	    studentService.addStudent(studentDTO);	
	}

}
