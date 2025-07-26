package com.sarvesh.productServiceJuly25.model;

import lombok.Data;

import java.util.Date;

@Data
public class BaseModel {
private Long id;
private Date createdAt;
private Date lastmodifiedAt;
}
