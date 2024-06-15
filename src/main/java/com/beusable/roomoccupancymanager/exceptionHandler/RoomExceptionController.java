package com.beusable.roomoccupancymanager.exceptionHandler;

import com.beusable.roomoccupancymanager.exception.InvalidRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RoomExceptionController {

    @ExceptionHandler(value = InvalidRequestException.class)
    public ResponseEntity<Object> exception(InvalidRequestException exception) {
        return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
    }

}
