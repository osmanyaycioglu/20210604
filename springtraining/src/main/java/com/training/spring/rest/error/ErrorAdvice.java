package com.training.spring.rest.error;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleError(final IllegalArgumentException exp) {
        return new ErrorObj().setBoundedContext("b1")
                             .setMicroservice("m1")
                             .setMessage(exp.getMessage())
                             .setErrorCause(100);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleError(final MethodArgumentNotValidException exp) {
        ErrorObj rootError = new ErrorObj().setBoundedContext("b1")
                                           .setMicroservice("m1")
                                           .setMessage("Validasyon Errorü oluştu")
                                           .setErrorCause(150);
        List<ObjectError> allErrorsLoc = exp.getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            rootError.addSubError(new ErrorObj().setBoundedContext("b1")
                                                .setMicroservice("m1")
                                                .setMessage(objectErrorLoc.toString())
                                                .setErrorCause(151));
        }
        return rootError;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleError(final ConstraintViolationException exp) {
        Set<ConstraintViolation<?>> constraintViolationsLoc = exp.getConstraintViolations();
        ErrorObj rootError = new ErrorObj().setBoundedContext("b1")
                                           .setMicroservice("m1")
                                           .setMessage("Validasyon Errorü oluştu")
                                           .setErrorCause(170);
        for (ConstraintViolation<?> objectErrorLoc : constraintViolationsLoc) {
            rootError.addSubError(new ErrorObj().setBoundedContext("b1")
                                                .setMicroservice("m1")
                                                .setMessage(objectErrorLoc.toString())
                                                .setErrorCause(171));
        }
        return rootError;
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleError(final IllegalStateException exp) {
        return new ErrorObj().setBoundedContext("b1")
                             .setMicroservice("m1")
                             .setMessage(exp.getMessage())
                             .setErrorCause(101);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorObj handleError(final Exception exp) {
        //        if (exp instanceof IllegalArgumentException) {
        //            IllegalArgumentException exceptionLoc = (IllegalArgumentException) exp;
        //            return new ErrorObj().setBoundedContext("b1")
        //                    .setMicroservice("m1")
        //                    .setMessage(exceptionLoc.getMessage())
        //                    .setErrorCause(100);
        //
        //        }
        return new ErrorObj().setBoundedContext("b1")
                             .setMicroservice("m1")
                             .setMessage(exp.getMessage())
                             .setErrorCause(205);
    }

}
