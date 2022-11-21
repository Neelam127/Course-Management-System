package com.cg1.Controller;

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

import com.cg1.Model.Register;
import com.cg1.Repository.RegisterRepository;
import com.cg1.Service.RegisterService;



@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/reg")
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private RegisterRepository registerRepository;
	
	
	@GetMapping("/Register")
	public List<Register> getAllRegister(){
		return registerService.getAllRegister();
	}
	
	
	
	@PostMapping("/Registers")
	public ResponseEntity<Register> addRegister(@RequestBody Register register) {
		
		Register addUser=registerService.addRegister(register);
		 return new ResponseEntity<>(addUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/Registers/{username}")
	public ResponseEntity<List<Register>> getRegisterById(@PathVariable String username){
		List<Register> user=registerRepository.findByusername(username);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	/*
	@PutMapping("/Register/{userid}")
	public  ResponseEntity < Register >  updateRegister(@PathVariable int userid,@RequestBody Register user){
		Register updatedUser=registerService.updateRegister(userid, user);
		return ResponseEntity.ok(updatedUser);
				
	}
	
	*/
	@DeleteMapping("/Register/{username}")
	public void deleteRegister(@PathVariable String username) {
		registerRepository.deleteByusername(username);
	}
	

}
