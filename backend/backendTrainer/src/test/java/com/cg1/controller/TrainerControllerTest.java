package com.cg1.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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

import com.cg1.Service.TrainerService;
import com.cg1.model.Trainer;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class TrainerControllerTest {
	
    @Autowired
    private MockMvc mockMvc; //use for running servlet related test. through this we can snd http request to controller to check whether they are responding as exp
	
    @Mock
    private TrainerService trainerService;
    private Trainer trainer;
    private List<Trainer> trainerList;

    @InjectMocks
    private TrainerController trainerController;
    
    @BeforeEach
    public void setUp(){
        trainer = new Trainer(4,"Amar Panchal","10 Years", "amarpanchal32@gmail.com");
        mockMvc= MockMvcBuilders.standaloneSetup(trainerController).build();  //used for creating instance of mockmvc
    }
    
    
    @Test
    @DisplayName("Saving Courses")
    public void saveTrainerControllerTest() throws Exception {
        when(trainerService.addTrainer(any())).thenReturn(trainer);
        mockMvc.perform(post("/train/Trainer")
                .contentType(MediaType.APPLICATION_JSON) 
                .content(asJsonString(trainer)))   
                .andExpect(status().isCreated()); //checks the response type of the endpoint
        verify(trainerService, times(1)).addTrainer(any());

    }
    
    @Test
    @DisplayName("Testing to get list of all courses")
    public void getAllTrainerControllerTest() throws Exception{
        when(trainerService.getAllTrainer()).thenReturn(trainerList);
        mockMvc.perform(MockMvcRequestBuilders.get("/train/Trainer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(trainer)))
                .andDo(MockMvcResultHandlers.print());
        verify(trainerService, times(1)).getAllTrainer();

    }
    


	public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}