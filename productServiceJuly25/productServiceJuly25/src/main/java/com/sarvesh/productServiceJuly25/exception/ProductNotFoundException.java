package com.sarvesh.productServiceJuly25.exception;

import lombok.Data;

@Data

public class ProductNotFoundException extends Exception{
    private Long Id;
    public ProductNotFoundException(String msg,Long Id){
        super(msg);
        this.Id = Id;
    }
}
