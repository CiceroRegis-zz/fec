package br.com.fec.service;

import java.util.List;

import br.com.fec.model.Student;

public interface StudentService {
	
	Student saveStudent(Student student);
	Student updateStudent(Student student);
	List<Student> getAllStudent();
	Student getStudentById(Integer id);
	void deleteStudent(Integer id);

}
