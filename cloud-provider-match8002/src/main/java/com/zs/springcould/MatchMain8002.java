package com.zs.springcould;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MatchMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(MatchMain8002.class,args);
    }
}
