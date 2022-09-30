package com.school.service;

import com.school.dto.StudentDTO;

public interface StudentService {
	void addStudent(StudentDTO studentDTO);

	StudentDTO getStudent(int id);

	int updateStudent(int id, int marks);

	int deleteStudent(int id);
}
