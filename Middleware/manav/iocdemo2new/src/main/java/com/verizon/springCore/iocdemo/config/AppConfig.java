package com.verizon.springCore.iocdemo.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.verizon.springCore.iocdemo.service")
public class AppConfig {
	@Bean
	public LocalDate today(){
		return LocalDate.now();
	}
}
