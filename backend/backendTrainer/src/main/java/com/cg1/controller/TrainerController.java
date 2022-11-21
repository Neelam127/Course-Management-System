package com.cg1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg1.Service.TrainerService;
import com.cg1.exception.TrainerNotFoundException;
import com.cg1.model.Trainer;
import com.cg1.repository.TrainerRepository;





@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/train")
public class TrainerController {


	@Autowired
	private TrainerService trainerService;
	
	@Autowired
	private TrainerRepository trainerRepositoy;
	
	@GetMapping("/Trainer")
	public List<Trainer> getAllTrainer(){
		return trainerService.getAllTrainer();
	}
	
	@GetMapping("/Trainers/{trainerName}")
	public Trainer getTrainerByName(@PathVariable String trainerName) throws TrainerNotFoundException{
		
		
		
		
		List<Trainer> trainerlist=trainerRepositoy.findAll();
		for(int i=0;i<trainerlist.size();i++) {
			Trainer trainertemp=trainerlist.get(i);
			if(trainerName.equals(trainertemp.getTrainerName())) {
				return trainertemp;
			}
			
		}
		
			throw new TrainerNotFoundException("Course does not exist");
		
	}

	
	
	@PostMapping("/Trainer")
	public ResponseEntity<Trainer> addTrainer(@RequestBody Trainer trainer) {
		Trainer addtrainer=trainerService.addTrainer(trainer);
		return new ResponseEntity<>(addtrainer, HttpStatus.CREATED);
	}
	
	@GetMapping("/Trainer/{trainerId}")
	public ResponseEntity < Trainer > getCourseById(@PathVariable int trainerId){
		Trainer trainer=trainerService.getTrainerById(trainerId);
		return ResponseEntity.ok().body(trainer);
	}
	
	@PutMapping("/Trainer/{trainerId}")
	public  ResponseEntity < Trainer >  updateTrainer(@PathVariable int trainerId,@RequestBody Trainer trainer){
		Trainer updatedTrainer=trainerService.updateTrainer(trainerId, trainer);
		return ResponseEntity.ok(updatedTrainer);
		
		
	}
	
	@DeleteMapping("Trainer/{trainerId}")
	public void deleteTrainer(@PathVariable int trainerId) {
		trainerService.deleteTrainer(trainerId);
	}
    
}
