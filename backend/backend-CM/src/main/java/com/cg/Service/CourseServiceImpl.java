package com.cg.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.exception.CourseNotFoundException;
import com.cg.model.Course;

import com.cg.repository.CoursesRepository;




@Service
public class CourseServiceImpl implements CourseService{
	
	
	@Autowired
	private RestTemplate rest;
	
	
	@Autowired
	private CoursesRepository courserepositoy;
	
	@Override
	public List<Course> getAllCourses() {
		return courserepositoy.findAll();
	}

	@Override
	
		
		public Course getCourseById(int courseId) throws CourseNotFoundException{
			Course course=courserepositoy.findById(courseId).orElseThrow(()->new CourseNotFoundException("Course not found"));
			return course;
		}
		
	
	
	
	
	@Override
	public Course getCourseByName(String courseName) throws CourseNotFoundException{
		List<Course> courselist=courserepositoy.findAll();
		for(int i=0;i<courselist.size();i++) {
			Course coursetemp=courselist.get(i);
			if(courseName.equals(coursetemp.getCourseName())) {
				return coursetemp;
			}
			
		}
		
			throw new CourseNotFoundException("Course does not exist");
		
	}
	

	@Override
	public Course addCourse(Course course) {
		Course newcourse=courserepositoy.save(course);
		return newcourse;
	}

	@Override
	public Course updateCourse(int CourseID, Course course) {
		Course update_course=courserepositoy.findById(CourseID).orElseThrow(()->new CourseNotFoundException("Course not found"));
		update_course.setCourseID(course.getCourseID());
		update_course.setCourseName(course.getCourseName());
		update_course.setTrainer(course.getTrainer());
		update_course.setDetails(course.getDetails());
		update_course.setCourseDuration(course.getCourseDuration());
		update_course.setCost(course.getCost());
		Course updated= courserepositoy.save(update_course);
		return updated;
		
	}

	@Override
	public void deleteCourse(int CourseID) {
		courserepositoy.deleteById(CourseID);

	}
	
}
