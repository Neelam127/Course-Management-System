package com.cg.Service;

import java.util.List;

import com.cg.exception.CourseNotFoundException;
import com.cg.model.Course;




public interface CourseService {

	List<Course> getAllCourses();
	Course getCourseById(int CourseID) throws CourseNotFoundException;
	Course addCourse(Course course);
	Course updateCourse(int CourseID,Course course) throws CourseNotFoundException;
	void deleteCourse(int CourseID);
	public Course getCourseByName(String courseName) throws CourseNotFoundException;
}
