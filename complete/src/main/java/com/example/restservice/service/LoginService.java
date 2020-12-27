package com.example.restservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restservice.dao.LoginI;
import com.example.restservice.entity.LoginEntity;

@Service
public class LoginService {
	
	@Autowired
	LoginI loginI;
	
	public void saveLoginDetails(LoginEntity loginEntity) {
		LoginEntity loginEntityy = loginI.save(loginEntity);
		
				
	}

}
