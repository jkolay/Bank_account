package com.example.transaction.exceptions;

import com.example.transaction.exceptions.BankAccountManagerException;
import com.example.transaction.exceptions.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
public class BankAccountControllerAdvice extends ResponseEntityExceptionHandler {


    /**
     * handles InvalidArgumentExceptions
     *
     * @param e the exception as cause
     */
    @ExceptionHandler(
            IllegalArgumentException.class
    )
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public final ResponseEntity<Object> handleBadRequest2(RuntimeException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);

    }

    /**
     * handles InvalidArgumentExceptions
     *
     * @param ex the exception as cause
     */


    @ExceptionHandler(BankAccountManagerException.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /**
     * handle other exceptions
     *
     * @param e the exception
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<Object> handleGeneric(Exception e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
