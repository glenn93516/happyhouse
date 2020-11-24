package com.ssafy.happyhouse;

import com.ssafy.happyhouse.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HappyHouseWebSpringDaejeon3KimminhyukAutumnleeApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(HappyHouseWebSpringDaejeon3KimminhyukAutumnleeApplication.class, args);
	}

	@Autowired
	private JwtInterceptor jwtInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor)
					.addPathPatterns("/qna/add")
					.addPathPatterns("/qna/modify");

	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("*")
				.allowedHeaders("*")
				.exposedHeaders("auth-token");
	}
}
