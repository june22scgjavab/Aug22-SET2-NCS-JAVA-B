package com.school.service;

import java.util.List;

import com.school.dto.StudentDTO;

public interface StudentService {
	void addStudent(StudentDTO studentDTO);

	StudentDTO getStudent(int id);

	int updateStudent(int id, int marks);

	int deleteStudent(int id);
	
	List<StudentDTO> getStudents();
	List<Object[]> getStudentsNameAndMarks();
	List<Integer> getMarks();
	 List<String> getNames();
}
