package com.lvnr.demo.micro.compraventa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CompraVentaCocheConfig {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
