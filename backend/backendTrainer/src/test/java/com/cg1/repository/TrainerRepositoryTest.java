package com.cg1.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.cg1.model.Trainer;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TrainerRepositoryTest {
	
	
	@Autowired
	TrainerRepository trainerRepo;
	
	@Test
	public void givenTrainershouldReturnTrainerObject() {
		
		Trainer t1 = new Trainer(4,"Amar Panchal","10 Years", "amarpanchal32@gmail.com"); //User input
		trainerRepo.save(t1); //Data is saved into Database
		Trainer t2 = trainerRepo.findById(t1.getTrainerId()).get(); // Data is retrieved from Database
		assertNotNull(t2);
		assertEquals(t1.getTrainerName(), t2.getTrainerName());
			
	}

	@Test
	public void getAllmustReturnAllTrainers() {
		Trainer t3 = new Trainer(5,"Amit K", "8 Years","amitkr@gmail.com");//User Input
		Trainer t4 = new Trainer(2,"Sagar", "7 Years","sagar@gmail.com"); // User Input
		trainerRepo.save(t3); //save the Data in database
		trainerRepo.save(t4); // save the Data in Database
		List < Trainer> trainerList = (List<Trainer>) trainerRepo.findAll();
		
		assertEquals("Sagar",trainerList.get(1).getTrainerName());
		/*
		for(int i=0;i<trainerList.size();i++) {
			Trainer coursetemp=trainerList.get(i);
			if(("Sonali Yadhav").equals(coursetemp.getTrainerName())) {
				assertEquals("Sonali Yadhav",trainerList.get(i).getTrainerName());
			}
		
			
		}
			*/
	}
	}
	

