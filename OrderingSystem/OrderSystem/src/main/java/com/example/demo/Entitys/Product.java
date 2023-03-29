package com.example.demo.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @ToString @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Product {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    int id;
	    String name;
	    String description;
	    double price;
	    int quantity;
}
