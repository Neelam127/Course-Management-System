package com.cg1.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



//custom exception
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class TrainerAlreadyExistException extends RuntimeException {
    
    private static final long serialVersionUID=1L;
    
    public TrainerAlreadyExistException(String message) {
        super(message);
    }



}