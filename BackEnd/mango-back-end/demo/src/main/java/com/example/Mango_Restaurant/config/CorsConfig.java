package com.example.Mango_Restaurant.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class CorsConfig {

	public WebMvcConfigurer costConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedMethods("GET","POST","PUT","DELETE")
				.allowedHeaders("*")
				.allowedOrigins("*");
				
				
			}
		};
	}
}
