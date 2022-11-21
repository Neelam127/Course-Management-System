package com.cg1.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg1.Model.Register;




public interface RegisterRepository extends MongoRepository<Register, Integer> {
	

	List<Register> findByusername(String username);
	
	Register deleteByusername(String username);
	
	boolean existsByusername(String username);
	
	boolean existsBycourseName(String courseName);
	
	
}
