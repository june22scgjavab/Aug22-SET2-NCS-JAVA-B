package com.school.repository;

import java.util.List;

import com.school.dto.StudentDTO;
// CRUD
public interface StudentRepository {
	void addStudent(StudentDTO studentDTO);

	StudentDTO getStudent(int id);

	int updateStudent(int id, int marks);

	int deleteStudent(int id);
	
	List<StudentDTO> getStudents();
	// Display name and marks
	List<Object[]> getStudentsNameAndMarks();
	List<Integer> getMarks();
	List<String> getNames();
}
