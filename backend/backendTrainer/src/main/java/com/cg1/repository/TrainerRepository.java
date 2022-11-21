package com.cg1.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg1.model.Trainer;




public interface TrainerRepository extends MongoRepository<Trainer, Integer> {
	
	
}
