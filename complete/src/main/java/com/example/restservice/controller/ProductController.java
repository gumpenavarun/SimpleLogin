package com.example.restservice.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.restservice.Domain.Product;
import com.example.restservice.entity.LoginEntity;
import com.example.restservice.service.ProductService;

@RestController
public class ProductController {
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	ProductService saveDomainService;
	
	@RequestMapping("/loadProducts")//loadProducts
	public ModelAndView loadProducts(Map<String, Object> model) {
		log.info("Entered load products method");
		List<Product> productList=saveDomainService.getAllProductDetails();
		log.info("product list: "+productList);
		model.put("productList",productList);
		return new ModelAndView("product");
	}
	
	@RequestMapping("/createProduct")
	public ModelAndView createProduct(Map<String, Object> model) {
		log.info("Going to create product");
		model.put("product", new Product());
		return new ModelAndView("createProduct");
	}
	
	@PostMapping("/saveProduct")
	public ModelAndView saveProduct(Map<String,Object> model, @ModelAttribute("product") Product product) {
		log.info("I'm going to save product: "+product.getName());
		saveDomainService.saveProductDetails(product);
		model.put("successMessage", "Saved Product Details Successfully");
		return new ModelAndView("createProduct");
	}
	
	@RequestMapping(value = "/deleteProduct/{id}")
	public RedirectView deleteProduct(Model model,@PathVariable("id") Long id) {
		log.info("going to Delete Product "+id);
		saveDomainService.deleteProduct(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("/loadProducts");
		return redirectView;
		
	}
	
	@RequestMapping(value="/updateProduct/{id}")
	public ModelAndView updateProduct(Map<String,Object> model, @PathVariable("id") Long id) {
		log.info("I'm going to update product: "+id);
		Product product = saveDomainService.getProductById(id);
		model.put("updateProduct", product);
		return new ModelAndView("updateProduct");
	}
	
	@PostMapping(value="/updateProduct")
	public ModelAndView updateProduct(Map<String,Object> model, @ModelAttribute("updateProduct") Product product) {
		log.info("I'm going to update product: "+product.getId());
		saveDomainService.updateProduct(product);
		model.put("updateSuccess", "updated successfully");
		return new ModelAndView("updateProduct");
	}
	
	
	
}
