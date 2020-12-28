package com.example.restservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.restservice.entity.UserEntity;

public interface UserI extends JpaRepository<UserEntity, Long>{
	@Query("select count(*) from UserEntity where username=:username AND password=:password")
	public int findUserByUsernameAndPassword(String username,String password) ;

}