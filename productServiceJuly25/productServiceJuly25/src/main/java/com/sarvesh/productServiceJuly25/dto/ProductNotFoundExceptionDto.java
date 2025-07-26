package com.sarvesh.productServiceJuly25.dto;

import lombok.Data;

@Data
public class ProductNotFoundExceptionDto {
    private String message;
    private String resolution;
}
