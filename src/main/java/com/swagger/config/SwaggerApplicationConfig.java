package com.swagger.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.swagger.service.PersonRegistrationService;
import com.swagger.service.impl.PersonRegistrationServiceImpl;

@Configuration
@ComponentScan(basePackages = { "com.swagger" })
public class SwaggerApplicationConfig {
	private static Logger logger = LoggerFactory.getLogger(SwaggerApplicationConfig.class);

	@Bean
	public PersonRegistrationService personRegistrationServiceImpl() {
		return new PersonRegistrationServiceImpl();
	}

}
