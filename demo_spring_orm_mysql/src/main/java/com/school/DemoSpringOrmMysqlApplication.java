package com.school;

import java.util.List;

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
	
	//updateStudent();
	//displayAllStudents();
	//displayAllStudentsNameAndMarks();	
	//getAllMarks();
	getAllNames();
	}

	private void getAllNames() {
		List<String> names=studentService.getNames();
		names.forEach(name->System.out.println(name));
		
	}

	private void getAllMarks() {
		List<Integer> marks=studentService.getMarks();
	marks.forEach(score->System.out.println(score));
		
	}

	private void displayAllStudentsNameAndMarks() {
		List<Object[]> objects=studentService.getStudentsNameAndMarks();
		objects.forEach(student->{
			System.out.println(student[0]+"\t"+student[1]);
			
		});
		
	}

	private void displayAllStudents() {
		List<StudentDTO> studentDTOList=studentService.getStudents();
		studentDTOList.forEach(studentDTO->{
			System.out.println(studentDTO.getRoll()+"\t"+studentDTO.getName()+"\t"+studentDTO.getMarks());
			
		});
		
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
