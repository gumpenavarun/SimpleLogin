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

import com.example.restservice.Domain.User;
import com.example.restservice.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

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

		boolean userExists = userService.findUser(name, password);
		if (!userExists) {
			redirectView.setUrl("/errorPage");
			return redirectView;
		}
		redirectView.setUrl("/loadProducts");
		return redirectView;
	}
	@GetMapping("/errorPage")
	public ModelAndView error(Map<String, Object> model) {
		model.put("errorMessage", "Invalid Credientals ");

		log.info("Entered into error page");
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/loadSignUp")
	public ModelAndView loadSignUp(Map<String, Object> model) {
		model.put("user", new User());
		return new ModelAndView("createUser");
	}

	@PostMapping("/saveUser")
	public ModelAndView saveLogin(Map<String, Object> model, @ModelAttribute("user") User user) {
		log.info("User " + user.toString());
		log.info("I'm going to save product: " + user.getFirstname());
		/*
		 * if(user.getFirstname().length()>25 ) { model.put("message",
		 * "First Name Should not be greater 25 Characters"); return new
		 * ModelAndView("createUser"); }
		 */ // To validate from BackEnd
		userService.saveLoginDetails(user);
		model.put("message", "Saved Login Details Successfully");
		return new ModelAndView("createUser");
	}
}
