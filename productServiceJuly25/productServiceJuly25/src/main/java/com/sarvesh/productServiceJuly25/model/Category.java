package com.sarvesh.productServiceJuly25.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "categories")
public class Category extends BaseModel{
    private String value;
}
