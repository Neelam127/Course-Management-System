package com.cg1.Service;

import java.util.List;

import com.cg1.Exception.UserNotFoundException;
import com.cg1.Model.Register;



public interface RegisterService {
	List<Register> getAllRegister();
	
	Register addRegister(Register register);
	

	//Register updateRegister(String userName, Register register);

}
