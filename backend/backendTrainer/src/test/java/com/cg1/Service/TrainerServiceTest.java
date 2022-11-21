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

import com.cg1.exception.TrainerAlreadyExistException;
import com.cg1.model.Trainer;
import com.cg1.repository.TrainerRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

class TrainerServiceTest {
	@InjectMocks  //This allows to inject mock object in TrainerServiceImpl
	private TrainerServiceImp tsi;

	@Mock
	private TrainerRepository tr;
	
	
	

	@Test
	public void TestsaveTrainer() throws TrainerAlreadyExistException{
		Trainer d1 = new Trainer(10, "Sagar", "5Years","trainer@gmail.com"); //user Input
		//if save method of trainerrepo is called then it should return trainer obj
		when(tr.save(any())).thenReturn(d1);
		tsi.addTrainer(d1);
		verify(tr,times(1)).save(any());  //save method of trainerrepo should be called one time
    }
	
	

	@Test
	public void testGetAllTrainers() {
		Trainer t1 = new Trainer(10, "Sagar", "5Years","trainer@gmail.com");//user Input
		tr.save(t1);
		Trainer td2 = new Trainer(20, "Sameer", "7 Years","sameer@gmail.com"); //user Input
		tr.save(td2);
		Trainer t3 = new Trainer(30, "Admin", "19 Years","admin@gmail"); //user Input
		tr.save(t3);
		
		List<Trainer> dList = new ArrayList<>(); // List object is created to store Array of Trainer
		dList.add(t1);         //retrieved from Database
		dList.add(td2);
		dList.add(t3);
		
		when(tr.findAll()).thenReturn(dList);
		List<Trainer> dList1 = tsi.getAllTrainer();
		assertEquals(dList,dList1);
		verify(tr,times(1)).save(t1);
		verify(tr,times(1)).findAll();
		
 }

}
