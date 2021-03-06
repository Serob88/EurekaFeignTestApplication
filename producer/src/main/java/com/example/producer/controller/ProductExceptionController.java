package com.example.producer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

  @ExceptionHandler({ProductExceptionController.ProductNotfoundException.class})
  public ResponseEntity<Object> exception(ProductExceptionController.ProductNotfoundException exception) {
    return new ResponseEntity("Product not found", HttpStatus.NOT_FOUND);
  }

  public static class ProductNotfoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ProductNotfoundException() {
    }
  }
}
