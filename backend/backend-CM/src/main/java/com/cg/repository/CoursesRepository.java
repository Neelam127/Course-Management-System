package com.cg.repository;


import org.springframework.data.mongodb.repository.MongoRepository;


import com.cg.model.Course;

public interface CoursesRepository extends MongoRepository<Course, Integer> {
	String findBycourseName();
	
}
