package com.example.restservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="login")
@Data
public class LoginEntity {
	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	private String name;
	private String password;
	
	public LoginEntity() {
		
	}
	
	
}
