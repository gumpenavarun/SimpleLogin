package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ViewResolver viewresolver() {
    	
    	final InternalResourceViewResolver r= new InternalResourceViewResolver();
    	r.setPrefix("/WEB-INF/jsp/");
    	r.setSuffix(".jsp");
		return r;
    	
    }
}
