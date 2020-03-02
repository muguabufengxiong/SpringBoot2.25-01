package com.example.SpringBoot25.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.SpringBoot25.interceptor.MyInterceptor;

@Configuration
public class MyWebMVCConfig {
	
	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/").setViewName("login");
				registry.addViewController("/index.html").setViewName("login");
				registry.addViewController("/my").setViewName("index");
			}

			
			 @Override 
			 public void addInterceptors(InterceptorRegistry registry) {
				  registry.addInterceptor(new MyInterceptor()) 
				  .addPathPatterns("/**")
				  .excludePathPatterns("/","/index.html","/login");
			 }
			 
		};
	}
}
