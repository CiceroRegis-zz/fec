package br.com.fec.service;

import java.util.List;

import br.com.fec.model.Course;

public interface CourseService {
	
	Course saveCourse(Course course);
	Course updateCourse(Course course);
	List<Course> getAllCourse();
	Course getCourseById(Integer id);
	void deleteCourse(Integer id);

}
