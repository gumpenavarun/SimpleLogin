package com.example.restservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="savedomain")
public class ProductEntity {
	private String name;
	private String brand;
	private String madein;
	private float price;
	private Long id;
	 
    public ProductEntity() {
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

}
