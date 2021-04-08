package com.maxrabets.periodicals.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.maxrabets.periodicals.controller.AuthController;

@Configuration
public class ApplicationContextConfig {
	@Bean
	public AuthController createAuthController() {
		return new AuthController();
	}
}
