package org.example.exception;

import org.example.model.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDto>
    handleUserNotFound(UserNotFoundException ex){

        return new ResponseEntity<>(
                new ErrorResponseDto(ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ExpenseNotFoundException.class)
    public ResponseEntity<ErrorResponseDto>
    handleExpenseNotFound(
            ExpenseNotFoundException ex){

        return new ResponseEntity<>(
                new ErrorResponseDto(ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto>
    handleGenericException(Exception ex){

        return new ResponseEntity<>(
                new ErrorResponseDto("Something went wrong"),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
