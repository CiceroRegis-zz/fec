package br.com.fec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fec.model.Course;
import br.com.fec.model.exception.ResourceNotFoundException;
import br.com.fec.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		Optional<Course> courseDb = this.courseRepository.findById(course.getId());
		if(courseDb.isPresent()) {
			Course courseUpdate = courseDb.get();
			courseUpdate.setId(course.getId());
			courseUpdate.setName(course.getName());
			courseUpdate.setDescription(course.getDescription());
			courseUpdate.setLevel(course.getLevel());
			courseUpdate.setPrice(course.getPrice());
			courseUpdate.setStatus(course.getStatus());
			courseUpdate.setUpdatedAt(course.getUpdatedAt());
			courseUpdate.setUpdatedAt(course.getUpdatedAt());
			//falta coisa ainda
			courseRepository.save(courseUpdate);
			return courseUpdate;			
		}else {
			throw new ResourceNotFoundException("Record not found with id: " + course.getId());
		}
	}

	@Override
	public List<Course> getAllCourse() {		 
		return courseRepository.findAll();
	}

	@Override
	public Course getCourseById(Integer courseId) {
		Optional<Course> courseDb = this.courseRepository.findById(courseId);
		if (courseDb.isPresent()) {

			return courseDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id :" + courseId);
		}
	}

	@Override
	public void deleteCourse(Integer courseId) {
		Optional<Course> courseDb = this.courseRepository.findById(courseId);
		if(courseDb.isPresent()) {
			this.courseRepository.delete(courseDb.get());			
		}else {
			throw new ResourceNotFoundException("Record not found with id :" + courseId);
		}
		
	}	
	
	

}
