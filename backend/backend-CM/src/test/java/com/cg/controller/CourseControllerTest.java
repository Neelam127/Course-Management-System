package com.cg.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.Service.CourseService;
import com.cg.model.Course;

import com.fasterxml.jackson.databind.ObjectMapper;
@ExtendWith(MockitoExtension.class)
class CourseControllerTest {


    @Autowired
    private MockMvc mockMvc;
	
    @Mock
    private CourseService courseService;
    private Course cs;
    private List<Course> courseList;

    @InjectMocks
    private CourseController courseController;
    
    @BeforeEach
    public void setUp(){
        
        mockMvc= MockMvcBuilders.standaloneSetup(courseController).build();
    }
    
    
    @Test
    public void saveDeptControllerTest() throws Exception {
    	cs = new Course(11,"Python","4000 INR","Josh","21 Hours","Details");
        when(courseService.addCourse(any())).thenReturn(cs);
        mockMvc.perform(post("/cos/Course")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(cs)))
                .andExpect(status().isCreated());
        verify(courseService, times(1)).addCourse(any());

    }
    
    @Test
    public void getAllCoursesTest() throws Exception{
        when(courseService.getAllCourses()).thenReturn(courseList);
        mockMvc.perform(MockMvcRequestBuilders.get("/cos/Course")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(cs)))
                .andDo(MockMvcResultHandlers.print());
        verify(courseService, times(1)).getAllCourses();

    }
    
    
 


	public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}

