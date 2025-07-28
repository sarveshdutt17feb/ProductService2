package com.sarvesh.productServiceJuly25.inheritancedemo.joinedtable;

import com.sarvesh.productServiceJuly25.inheritancedemo.mappedsuperclass.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_mentors")
public class Mentor extends User {
private String company;
}
