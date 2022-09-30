package com.school.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.school.dto.StudentDTO;
import com.school.entity.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@PersistenceContext
	private EntityManager entityManager;
@Override
	public void addStudent(StudentDTO studentDTO) {
	 Student student=new Student();
	 student.setRoll(studentDTO.getRoll());
	 student.setName(studentDTO.getName());
	 student.setMarks(studentDTO.getMarks());
     entityManager.persist(student);
	}

	@Override
	public StudentDTO getStudent(int id) {
		Student student = entityManager.find(Student.class, id);
		StudentDTO studentDTO=null;
		if(student!=null) {
			studentDTO=new StudentDTO();
			studentDTO.setRoll(student.getRoll());
			studentDTO.setName(student.getName());
			studentDTO.setMarks(student.getMarks());
		}
		return studentDTO;
	}

	@Override
	public int updateStudent(int id, int marks) {
		Student student=entityManager.find(Student.class, id);
		student.setMarks(marks);
		return student.getRoll();
	}

	@Override
	public int deleteStudent(int id) {
		Student student=entityManager.find(Student.class, id);
		entityManager.remove(student);
		return student.getRoll();
	}

}
