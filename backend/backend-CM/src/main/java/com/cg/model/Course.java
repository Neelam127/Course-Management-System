package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses")
public class Course {
  @Id
  private int courseID;

  private String courseName;
  private String trainer;
  
  private String courseDuration;
  private String details;
  
  private String cost;
  
  
public Course() {
	
}




public Course(int courseID, String courseName, String cost, String trainer, String courseDuration, String details) {
	super();
	this.courseID = courseID;
	this.courseName = courseName;
	this.trainer = trainer;
	this.courseDuration = courseDuration;
	this.details = details;
	this.cost = cost;
}




public String getCourseName() {
	return courseName;
}

public void setCourseName(String courseName) {
	this.courseName = courseName;
}

public int getCourseID() {
	return courseID;
}

public void setCourseID(int courseID) {
	this.courseID = courseID;
}

public String getTitle() {
	return courseName;
}

public void setTitle(String courseName) {
	this.courseName = courseName;
}

public String getTrainer() {
	return trainer;
}

public void setTrainer(String trainer) {
	this.trainer = trainer;
}

public String getDetails() {
	return details;
}

public void setDetails(String details) {
	this.details = details;
}

public String getCourseDuration() {
	return courseDuration;
}

public void setCourseDuration(String courseDuration) {
	this.courseDuration = courseDuration;
}

public String getCost() {
	return cost;
}

public void setCost(String cost) {
	this.cost = cost;
} 
  
  
  
 

   
}
  