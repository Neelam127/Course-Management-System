package com.cg.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.model.Course;

@ExtendWith(SpringExtension.class)
@DataMongoTest
class CoursesRepositoryTest {


	@Autowired
	private CoursesRepository courseRepo;
	
	@Test
	public void givenCourseshouldReturnCourseObject() {
		
		Course c1 = new Course(11,"Python","2300 INR","Josh","21 Hours","Details"); //User input
		courseRepo.save(c1); //Data is saved into Database
		Course c2 = courseRepo.findById(c1.getCourseID()).get(); // Data is retrieved from Database
		assertNotNull(c2);
		assertEquals(c1.getCourseName(), c2.getCourseName());
			
	}

	@Test
	public void getAllmustReturnAllCourses() {
		Course c3 = new Course(10,"Angular","5500 INR","Sonali Yadhav","16 Hours","Details");//User Input
		Course c4 = new Course(12,"C++","1200 INR","Amit K","24 Hours","Details"); // User Input
		courseRepo.save(c3); //save the Data in database
		courseRepo.save(c4); // save the Data in Database
		List <Course> courseList = (List<Course>) courseRepo.findAll();
		System.out.println(courseList);
		for(int i=0;i<courseList.size();i++) {
			Course coursetemp=courseList.get(i);
			if(("C++").equals(coursetemp.getCourseName())) {
				assertEquals("C++",courseList.get(i).getCourseName());
			}
		
			
		}}

}
