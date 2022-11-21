package com.cg1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg1.exception.TrainerNotFoundException;
import com.cg1.model.Trainer;
import com.cg1.repository.TrainerRepository;


@Service
public class TrainerServiceImp implements TrainerService{
	
	
	@Autowired
	private TrainerRepository trainerRepositoy;
	
	@Override
	public List<Trainer> getAllTrainer() {
		return trainerRepositoy.findAll();
	}

	@Override
	public Trainer getTrainerById(int trainerId) throws TrainerNotFoundException{
		Trainer trainer=trainerRepositoy.findById(trainerId).orElseThrow(()->new TrainerNotFoundException("Trainer not found"));
		return trainer;
	}

	
	@Override
	public Trainer addTrainer(Trainer trainer) {
		Trainer newtrainer=trainerRepositoy.save(trainer);
		return newtrainer;
	}

	@Override
	public Trainer updateTrainer(int trainerId, Trainer trainer) {
		Trainer update_trainer=trainerRepositoy.findById(trainerId).orElseThrow(()->new TrainerNotFoundException("Trainer not found"));
		update_trainer.setTrainerId(trainer.getTrainerId());
		update_trainer.setTrainerName(trainer.getTrainerName());
		update_trainer.setExperience(trainer.getExperience());
		update_trainer.setEmailId(trainer.getEmailId());
		
		
		
		
		Trainer updated= trainerRepositoy.save(update_trainer);
		return updated;

	}

	@Override
	public void deleteTrainer(int trainerId) {
		trainerRepositoy.deleteById(trainerId);

	}

}
