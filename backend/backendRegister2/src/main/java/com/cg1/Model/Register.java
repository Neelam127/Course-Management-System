package com.cg1.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document("Register")
public class Register {
	@Id
	private String id;
	
	private int courseID;
	private String username;
	
	private String courseName;
	private String trainerName;
 
	
	private String courseDuration;
	 
	
	  
	
	
	public Register() {
		
	}
	
	public Register(String username, String courseName) {
		
		this.username = username;
		this.courseName = courseName;
		
	}
	
	




	public Register(int courseID, String username, String courseName, String trainerName, String courseDuration) {
		super();
		this.courseID = courseID;
		this.username = username;
		this.courseName = courseName;
		this.trainerName = trainerName;
		this.courseDuration = courseDuration;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCourseID() {
		return courseID;
	}






	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}







	public String getCourseDuration() {
		return courseDuration;
	}






	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}










	public String getCourseName() {
		return courseName;
	}



	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



	public String getTrainerName() {
		return trainerName;
	}



	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	
	
	

}
