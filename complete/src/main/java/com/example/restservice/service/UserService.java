package com.example.restservice.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restservice.Domain.User;
import com.example.restservice.dao.UserI;
import com.example.restservice.entity.UserEntity;

@Service
public class UserService {
	
	@Autowired
	UserI userI;
	
	public void saveLoginDetails(User user) {
		//User -> front End object
		//UserEntity -> backend
		
		UserEntity userEntity = new  UserEntity();
		userEntity.setEmail(user.getEmail());
		userEntity.setFirstname(user.getFirstname());
		userEntity.setLastname(user.getLastname());
		userEntity.setPassword(user.getPassword());
		userEntity.setCreateddate(new Date());
		userEntity.setUsername(user.getUsername());
		userI.save(userEntity);
	}
	
	public boolean findUser(String name,String password) {
		int count=userI.findUserByUsernameAndPassword(name, password);
		if(count>=1) {
			return true;
		}
		return false;
		
	}

}
