package com.sarvesh.productServiceJuly25.controllerAdvice;

import com.sarvesh.productServiceJuly25.dto.ProductNotFoundExceptionDto;
import com.sarvesh.productServiceJuly25.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException exception){
        ProductNotFoundExceptionDto dto = new ProductNotFoundExceptionDto();
        dto.setMessage(exception.getMessage());
        dto.setResolution("Please provide valid productId");
        return new ResponseEntity<>(dto, HttpStatus.UNAUTHORIZED);
    }

}
