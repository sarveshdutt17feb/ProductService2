package com.sarvesh.productServiceJuly25.inheritancedemo.joinedtable;

import com.sarvesh.productServiceJuly25.inheritancedemo.mappedsuperclass.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_instructors")
public class Instructor extends User {
    private String specialization;
    private double avgRating;
}
