package com.example.restservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.entity.LoginEntity;

public interface LoginI extends JpaRepository<LoginEntity, Long>{

}