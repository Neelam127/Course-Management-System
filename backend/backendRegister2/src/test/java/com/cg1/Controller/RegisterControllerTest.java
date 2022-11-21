package com.cg1.Controller;

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

import com.cg1.Model.Register;
import com.cg1.Service.RegisterService;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(MockitoExtension.class)
public class RegisterControllerTest {
	
    @Autowired
    private MockMvc mockMvc;
	
    @Mock
    private RegisterService registerService;
    private Register register;
    private List<Register> registerList;

    @InjectMocks
    private RegisterController registerController;
    
    @BeforeEach
    public void setUp(){
        register = new Register(7,"Shivani","Java","Josh","21 Hours");
        mockMvc= MockMvcBuilders.standaloneSetup(registerController).build();
    }
    
    
    @Test
    @DisplayName("Test for course register")
    public void saveRegisterControllerTest() throws Exception {
        when(registerService.addRegister(any())).thenReturn(register);
        mockMvc.perform(post("/reg/Registers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(register)))
                .andExpect(status().isCreated());
        verify(registerService, times(1)).addRegister(any());

    }
    
    @Test
    @DisplayName("Test to get all course")
    public void getAllRegisterControllerTest() throws Exception{
        when(registerService.getAllRegister()).thenReturn(registerList);
        mockMvc.perform(MockMvcRequestBuilders.get("/reg/Register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(register)))
                .andDo(MockMvcResultHandlers.print());
        verify(registerService, times(1)).getAllRegister();

    }
    


	public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}