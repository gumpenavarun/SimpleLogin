package com.example.restservice.Domain;

import lombok.Data;
@Data
public class User {
	//private Integer id;
	private String username;
	private String email;
	private String firstname;
	private String lastname;
	//private Date createddate;
	private String password;
	
	public User() {
		
	}
	
	
}
