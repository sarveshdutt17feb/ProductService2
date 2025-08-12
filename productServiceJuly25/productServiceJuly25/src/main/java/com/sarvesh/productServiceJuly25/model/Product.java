package com.sarvesh.productServiceJuly25.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "products")
public class Product extends BaseModel{
//    @Column(unique = true,nullable = false)
    private String title;
    private Double price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;
    private String description;
    private String image;

}
