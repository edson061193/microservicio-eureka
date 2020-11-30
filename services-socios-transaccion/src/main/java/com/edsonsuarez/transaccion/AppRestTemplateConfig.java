package com.edsonsuarez.transaccion;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppRestTemplateConfig {

	@Bean("sociosmanRest")
	@LoadBalanced
	public RestTemplate restSociosmanRest() {
		return new RestTemplate();
	}
}
