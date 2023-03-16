package com.practice.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User1 {
    @Id
    private int id;
    private String name;
}
