package com.cg1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg1.Exception.CourseAlreadyRegisteredException;
import com.cg1.Exception.UserAlreadyExistException;
import com.cg1.Exception.UserNotFoundException;
import com.cg1.Model.Course;
import com.cg1.Model.Register;
import com.cg1.Model.Trainer;

import com.cg1.Repository.RegisterRepository;



@Service
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	private RestTemplate rest;
	
	
	@Autowired
	private RegisterRepository registerrepositoy;
	
	@Override
	public List<Register> getAllRegister() {
		return registerrepositoy.findAll();
	}

	


	@Override
	public Register addRegister(Register register) throws CourseAlreadyRegisteredException {
		String CourseTitle=register.getCourseName();
		
		
		//Trainer tr=this.rest.getForObject("http://localhost:8080/api/v1/Trainers/"+register.getTrainerName(), Trainer.class);
		
		
		Course cs=this.rest.getForObject("http://Course-server/cos/Courses/"+CourseTitle, Course.class);
		
		Register show_register_user=register;
		
		List<Register> listreg=registerrepositoy.findByusername(register.getUsername());
			for(int i=0;i<listreg.size();i++) {
				Register reg=listreg.get(i);
				if(reg.getCourseName().equals(show_register_user.getCourseName())) {
					throw new CourseAlreadyRegisteredException("You have already registered for this course");
				}
			}
		
		/*
		if(registerrepositoy.existsByusername(register.getUsername())&& registerrepositoy.existsBycourseName(register.getCourseName())){
			
			throw new CourseAlreadyRegisteredException("You have already registered for this course");
			
		}*/
		
		show_register_user.setUsername(register.getUsername());
		
		show_register_user.setTrainerName(cs.getTrainer());
		
		show_register_user.setCourseDuration(cs.getCourseDuration());
	
		show_register_user.setCourseID(cs.getCourseID());
		
	
		
		Register newregister=registerrepositoy.save(show_register_user);
		return newregister;
	}
	
	
	
	/*
	@Override
	public Register addRegister(Register register) {
		String CourseTitle=register.getCourseName();
		String trainerName=register.getTrainerName();
		
		Course cs=this.rest.getForObject("http://localhost:8081/api/v1/Courses/"+CourseTitle, Course.class);
		Trainer tr=this.rest.getForObject("http://localhost:8080/api/v1/Trainers/"+trainerName, Trainer.class);
		
		Register show_register_user=register;
		show_register_user.setEmailId(tr.getEmailId());
		show_register_user.setExperience(tr.getExperience());
		
		show_register_user.setCourseDuration(cs.getCourseDuration());
		show_register_user.setDetails(cs.getDetails());
		
		
		
		Register newregister=registerrepositoy.save(show_register_user);
		return newregister;
	}
	

	@Override
	public Register updateRegister(String userName, Register register) {
		Register update_user=registerrepositoy.findByuserName1(userName);
		
		update_user.setUserName(register.getUserName());
		update_user.setCourseName(register.getCourseName());
		update_user.setTrainerName(register.getTrainerName());
		
		
		Register updated= registerrepositoy.save(update_user);
		return updated;
		
	}

	
*/
	

}
