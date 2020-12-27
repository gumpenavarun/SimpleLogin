package com.example.restservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.entity.ProductEntity;

public interface ProductI extends JpaRepository<ProductEntity,Long>{

}
