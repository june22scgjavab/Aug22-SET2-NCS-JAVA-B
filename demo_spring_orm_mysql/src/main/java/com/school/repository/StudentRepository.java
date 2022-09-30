package com.school.repository;

import com.school.dto.StudentDTO;
// CRUD
public interface StudentRepository {
	void addStudent(StudentDTO studentDTO);

	StudentDTO getStudent(int id);

	int updateStudent(int id, int marks);

	int deleteStudent(int id);
}
