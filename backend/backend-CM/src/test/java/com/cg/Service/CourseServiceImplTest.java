
package com.cg.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.exception.CourseAlreadyExistException;
import com.cg.model.Course;
import com.cg.repository.CoursesRepository;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CourseServiceImplTest {
	
	
	@Mock
	private CoursesRepository cr;
	
	@InjectMocks
	private CourseServiceImpl csi;
	
	@Test
	public void TestaddCourse()throws CourseAlreadyExistException{
		Course c1=new Course(10,"Java","5500 INR","Shankar","21 Hours","Details");
		when(cr.save(any())).thenReturn(c1);
		csi.addCourse(c1);
		verify(cr,times(1)).save(any());
				
			
	}

	@Test
	public void TestgetAllCourses() {
		Course c1 = new Course(10,"Java","5500 INR","Shankar","21 Hours","Details");
		
		cr.save(c1);
		Course c2 = new Course(11,"Python","2300 INR","Neha","16 Hours","Details");
		cr.save(c2);
		Course c3 = new Course(12,"C++","1200 INR","Priya","23 Hours","Details");
		cr.save(c3);
		
		List<Course> cList= new ArrayList<>();
		cList.add(c1);
		cList.add(c2);
		cList.add(c3);
		
		when(cr.findAll()).thenReturn(cList);
		List<Course> cList1=csi.getAllCourses();
		assertEquals(cList,cList1);
		verify(cr,times(1)).save(c1);
		//verify(cr.times(1)).findAll();
		verify(cr,times(1)).findAll();
		
	}

}
