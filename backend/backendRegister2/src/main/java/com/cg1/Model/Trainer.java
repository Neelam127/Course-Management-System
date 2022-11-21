package com.cg1.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Trainer")
public class Trainer {
	@Id
	  private int trainerId;

	  private String trainerName;
	  private String experience;
	  private String emailId;
	  
	  
	public Trainer() {
		
	}

	
	

	
	


	public Trainer(int trainerId, String trainerName, String experience, String emailId) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.experience = experience;
		this.emailId = emailId;
	}




	


	public int getTrainerId() {
		return trainerId;
	}


	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}


	public String getTrainerName() {
		return trainerName;
	}


	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	
	
	  
	  
	  


	


	  
	
}
