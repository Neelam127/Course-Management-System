package com.cg1.Repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg1.Model.Register;




@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RegisterRepositoryTest {
	
	
	@Autowired
	RegisterRepository registerRepo;
	
	@Test
	public void shouldReturnRegisterObject() {
		
		Register r1 = new Register(7,"Shivani","Java","Josh","21 Hours"); //User input
		registerRepo.save(r1); //Data is saved into Database
		List<Register> t2 = registerRepo.findByusername(r1.getUsername()); // Data is retrieved from Database
		assertNotNull(t2);
		for(int i=0;i<t2.size();i++) {
			Register reg=t2.get(i);
			if(reg.getUsername().equals(r1.getUsername())) {
				assertEquals(r1.getUsername(), reg.getUsername());
				break;
			}
		}
		
			
	}

	@Test
	public void getAllmustReturnAllRegisters() {
		Register r3 = new Register(7,"Shivani","Java","Josh","21 Hours");//User Input
		Register r4 = new Register(7,"Neelam","Java","Josh","21 Hours"); // User Input
		registerRepo.save(r3); //save the Data in database
		registerRepo.save(r4); // save the Data in Database
		List < Register> registerList = (List<Register>) registerRepo.findAll();
		
		assertEquals("Shivani",registerList.get(0).getUsername());
		
		/*for(int i=0;i<registerList.size();i++) {
			Register coursetemp=registerList.get(i);
			if(("NeelamSk").equals(coursetemp.getUsername())) {
				assertEquals("NeelamSk",registerList.get(i).getUsername());
			}
		
			
		}*/
		
		}
			
	}
	

