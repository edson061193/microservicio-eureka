package com.edsonsuarez.apirestmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApirestMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApirestMysqlApplication.class, args);
	}

}
