package com.sarvesh.productServiceJuly25.model;


import lombok.Data;

@Data
public class Product extends BaseModel{
private String title;
private Double price;
private Category category;
private String description;
private String image;

}
