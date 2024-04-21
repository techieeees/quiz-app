package com.naveen.questionservice.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class BeanConfig {
	@Bean
	@Lazy
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
