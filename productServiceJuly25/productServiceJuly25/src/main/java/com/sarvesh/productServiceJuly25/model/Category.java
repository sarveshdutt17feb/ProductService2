package com.sarvesh.productServiceJuly25.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "categories")
public class Category extends BaseModel{
    private String value;
//    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
//        private List<Product> products;
    private String description;
}
