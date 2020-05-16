package br.com.fec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fec.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

}
