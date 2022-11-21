package com.cg1.Service;

import java.util.List;

import com.cg1.exception.TrainerNotFoundException;

import com.cg1.model.Trainer;




public interface TrainerService {
	List<Trainer> getAllTrainer();
	Trainer getTrainerById(int trainerId) throws TrainerNotFoundException;
	Trainer addTrainer(Trainer trainer);
	Trainer updateTrainer(int trainerId,Trainer trainer) throws TrainerNotFoundException;
	void deleteTrainer(int trainerId);
	

}
