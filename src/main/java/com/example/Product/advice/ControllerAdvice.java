package com.example.Product.advice;

import com.example.Product.exception.ProductNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


@org.springframework.web.bind.annotation.ControllerAdvice

public class ControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> getPrductException(ProductNotFoundException e){
        return new ResponseEntity<>(e.getMessage() , HttpStatusCode.valueOf(400));
    }
}
