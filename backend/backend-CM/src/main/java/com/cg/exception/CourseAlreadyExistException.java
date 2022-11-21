package com.cg.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



//custom exception
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class CourseAlreadyExistException extends RuntimeException {
    
    private static final long serialVersionUID=1L;
    
    public CourseAlreadyExistException(String message) {
        super(message);
    }



}