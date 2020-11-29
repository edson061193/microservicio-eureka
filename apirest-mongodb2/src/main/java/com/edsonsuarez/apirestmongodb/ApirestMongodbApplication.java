package com.edsonsuarez.apirestmongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApirestMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApirestMongodbApplication.class, args);
    }

}
