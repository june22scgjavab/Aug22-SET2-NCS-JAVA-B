package com.school.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@Override
	public List<StudentDTO> getStudents() {
		Query query=entityManager.createQuery("select s from Student s");
		List<Student> listStudent=query.getResultList(); 
		List<StudentDTO> studentDTOList=new ArrayList<>();
	listStudent.forEach(student->{
		  StudentDTO studentDTO=new StudentDTO();
		  studentDTO.setRoll(student.getRoll());
		  studentDTO.setName(student.getName());
		  studentDTO.setMarks(student.getMarks());
		  studentDTOList.add(studentDTO);
	});
		return studentDTOList;
	}

	@Override
	public List<Object[]> getStudentsNameAndMarks() {
		Query query=entityManager.createQuery("select s.name,s.marks from Student s");
		List<Object[]> objects=query.getResultList();
		return objects;
	}

	@Override
	public List<Integer> getMarks() {
		Query query=entityManager.createQuery("select s.marks from Student s");
		List<Integer> marks=query.getResultList();
		return marks;
	}

	@Override
	public List<String> getNames() {
		Query query=entityManager.createQuery("select upper(s.name) from Student s");
		List<String> names=query.getResultList();
		return names;
	}

}
