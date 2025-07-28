package com.sarvesh.productServiceJuly25.model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "products")
public class Product extends BaseModel{
private String title;
private Double price;
@ManyToOne
private Category category;
private String description;
private String image;

}
