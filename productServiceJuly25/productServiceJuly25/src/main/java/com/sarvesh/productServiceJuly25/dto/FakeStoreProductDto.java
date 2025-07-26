package com.sarvesh.productServiceJuly25.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class FakeStoreProductDto {
private Long id;
private String title;
private Double price;
private String description;
private String category;
private String image;
}
