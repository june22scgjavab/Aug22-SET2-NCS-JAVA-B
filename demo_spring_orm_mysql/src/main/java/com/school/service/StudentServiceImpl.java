package com.school.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dto.StudentDTO;
import com.school.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	private StudentRepository studentRepository;
	@Override
	
	public void addStudent(StudentDTO studentDTO) {
		studentRepository.addStudent(studentDTO);

	}

	@Override
	public StudentDTO getStudent(int roll) {
		StudentDTO studentDTO=studentRepository.getStudent(roll);
		return studentDTO;
	}

	@Override
	public int updateStudent(int roll, int marks) {
		int rollNumber=studentRepository.updateStudent(roll, marks);
		return rollNumber;
	}

	@Override
	public int deleteStudent(int roll) {
		int rollNumber=studentRepository.deleteStudent(roll);
		return rollNumber;
	}

	@Override
	public List<StudentDTO> getStudents() {
		
		return studentRepository.getStudents();
	}

	@Override
	public List<Object[]> getStudentsNameAndMarks() {
		
		return studentRepository.getStudentsNameAndMarks();
	}

	@Override
	public List<Integer> getMarks() {
		
		return studentRepository.getMarks();
	}

	@Override
	public List<String> getNames() {
		
		return studentRepository.getNames();
	}

}
