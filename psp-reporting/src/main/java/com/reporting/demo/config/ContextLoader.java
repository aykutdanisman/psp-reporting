package com.reporting.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextLoader {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
