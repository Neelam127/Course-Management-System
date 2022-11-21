package com.cg1.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



//custom exception
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID=1L;
    
    public UserNotFoundException(String message) {
        super(message);
    }



}