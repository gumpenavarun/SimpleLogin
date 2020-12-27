package com.example.restservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restservice.Domain.Product;
import com.example.restservice.dao.ProductI;
import com.example.restservice.entity.ProductEntity;


@Service
public class ProductService {
	@Autowired
	ProductI saveProductI;
	
	public void saveProductDetails(Product product) {
		ProductEntity productEntity = copyProductToProductEntity(product);
		saveProductI.save(productEntity);
	}

	private ProductEntity copyProductToProductEntity(Product product) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setName(product.getName());
		productEntity.setBrand(product.getBrand().toUpperCase());
		productEntity.setId(product.getId());
		productEntity.setMadein(product.getMadein());
		productEntity.setPrice(product.getPrice());
		return productEntity;
	}
	
	public List<Product> getAllProductDetails(){
		List<ProductEntity> productEntityList = saveProductI.findAll();
		List<Product> productList = new ArrayList<Product>();
		Product saveDomain = null;
		if(productEntityList!=null && productEntityList.size()>0) {
			for(ProductEntity productEntity: productEntityList) {
				saveDomain= new Product();
				saveDomain.setId(productEntity.getId());
				saveDomain.setBrand(productEntity.getBrand());
				saveDomain.setMadein(productEntity.getMadein());
				saveDomain.setName(productEntity.getName());
				saveDomain.setPrice(productEntity.getPrice());
				productList.add(saveDomain);
			}
		}
		return productList;
	}
	
	public void deleteProduct(Long id) {
		saveProductI.deleteById(id);
	}
	
	public Product getProductById(Long id) {
		ProductEntity productEntity = saveProductI.getOne(id);
		Product product = new Product();
		product.setBrand(productEntity.getBrand());
		product.setId(productEntity.getId());
		product.setMadein(productEntity.getMadein());
		product.setName(productEntity.getName());
		product.setPrice(productEntity.getPrice());
		return product;
	}
	public void updateProduct(Product product) {
		ProductEntity productEntity = copyProductToProductEntity(product);
		saveProductI.save(productEntity);
		
	}
}
