package com.example.restservice.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.restservice.entity.LoginEntity;
import com.example.restservice.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	LoginService loginService;

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@GetMapping("/")
	public ModelAndView welcome() {
		log.info("Entered into application");
		return new ModelAndView("login");
	}

	@PostMapping("/login")
	public RedirectView login(Map<String, Object> model, @RequestParam String name, @RequestParam String password) {
		log.info("Entered into Login, name:{}, password:{}", name, password);
		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		if (name == null || name.equals("") || password == null || password.equals("")) {
			model.put("errorMessage", "please provide all Details ");
			redirectView.setUrl("/errorPage");
		}else {
			redirectView.setUrl("/loadProducts");
		}
		return redirectView;
	}
	@GetMapping("/errorPage")
	public ModelAndView error() {
		log.info("Entered into error page");
		return new ModelAndView("error");
	}
	@RequestMapping(value="/loadSignUp")
	public ModelAndView loadSignUp(Map<String,Object> model) {
		model.put("loginEntity", new LoginEntity());
		return new ModelAndView("signUp");
	}
	
	@PostMapping("/saveLogin")
	public ModelAndView saveLogin(Map<String,Object> model, @ModelAttribute("login") LoginEntity loginEntity) {
		log.info("I'm going to save product: "+loginEntity.getName());
		loginService.saveLoginDetails(loginEntity);
		model.put("successMessage", "Saved Login Details Successfully");
		return new ModelAndView("login");
	}
}
