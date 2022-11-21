package com.cg1.Service;

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

import com.cg1.Exception.UserAlreadyExistException;
import com.cg1.Model.Register;
import com.cg1.Repository.RegisterRepository;



@SpringBootTest
@ExtendWith(MockitoExtension.class)
class RegisterServiceTest {

	@Mock
	private RegisterRepository dr;
	
	@InjectMocks
	private RegisterServiceImpl dsi;
	
/*
	@Test
	public void TestsaveRegistered() throws UserAlreadyExistException{
		Register d1 = new Register("Suraj","Java"); //user Input
		when(dr.save(any())).thenReturn(d1);
		dsi.addRegister(d1);
		verify(dr,times(1)).save(any());
    }
	*/

	@Test
	public void testGetAllRegisters() {
		Register d1 = new Register(7,"Neelam","Java","Josh","21 Hours");//user Input
		dr.save(d1);
		Register d2 = new Register(7,"Shivani","Java","Josh","21 Hours"); //user Input
		dr.save(d2);
		Register d3 = new Register(7,"Suraj","Java","Josh","21 Hours"); //user Input
		dr.save(d3);
		
		List<Register> dList = new ArrayList<>(); // List object is created to store Array of Department
		dList.add(d1);         //retrieved from Database
		dList.add(d2);
		dList.add(d3);
		
		when(dr.findAll()).thenReturn(dList);
		List<Register> dList1 = dsi.getAllRegister();
		assertEquals(dList,dList1);
		verify(dr,times(1)).save(d1);
		verify(dr,times(1)).findAll();
		
 }

}
