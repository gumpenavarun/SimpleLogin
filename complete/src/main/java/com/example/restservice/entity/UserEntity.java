package com.example.restservice.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="user")
@Data
public class UserEntity {
	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	private String username;
	private String email;
	private String firstname;
	private String lastname;
	private Date createddate;
	private String password;
	
	public UserEntity() {
		
	}
	
	
}
