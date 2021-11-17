package com.example.karate20211012;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter  
public class Material {

    public Material() {
    }
    
    public Material(String n) {
        name=n;
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;    

    private String name; 
}

