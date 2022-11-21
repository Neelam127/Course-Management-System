package com.cg1.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses")
public class Course {
  @Id
  private int courseID;

  private String courseName;
  private String trainer;
  private String details;
  private String courseDuration;
  
  
  
  
public Course() {
	
}

public Course(int courseID, String title, String trainer, String details, String courseDuration) {
	super();
	this.courseID = courseID;
	this.courseName = title;
	this.trainer = trainer;
	this.details = details;
	this.courseDuration = courseDuration;
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

public void setTitle(String title) {
	this.courseName = title;
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
  
  
  
 

   
}
  