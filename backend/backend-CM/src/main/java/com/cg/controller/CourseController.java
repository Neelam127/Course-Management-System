package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Service.CourseService;
import com.cg.exception.CourseNotFoundException;
import com.cg.model.Course;




@RestController


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")


@RequestMapping("/cos")
public class CourseController {

	

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/Course")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@GetMapping("/Courses/{courseName}")
	public Course getCourseByName(@PathVariable String courseName) throws CourseNotFoundException{
		return courseService.getCourseByName(courseName);
	}
	
	@PostMapping("/Course")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		Course addCourse=courseService.addCourse(course);
		return new ResponseEntity<>(addCourse, HttpStatus.CREATED);
	}
	
	@GetMapping("/Course/{courseID}")
	public ResponseEntity < Course > getCourseById(@PathVariable int courseID){
		Course course=courseService.getCourseById(courseID);
		return ResponseEntity.ok().body(course);
	}

	
	@PutMapping("/Course/{courseID}")
	public  ResponseEntity < Course >  updateCourse(@PathVariable int courseID,@RequestBody Course course){
		Course updatedCourse=courseService.updateCourse(courseID, course);
		return ResponseEntity.ok(updatedCourse);
		
		
	}
	
	@DeleteMapping("/Course/{courseID}")
	public void deleteCourse(@PathVariable int courseID) {
		courseService.deleteCourse(courseID);
	}
    
}
