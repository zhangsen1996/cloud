package com.zs.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerMatchMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMatchMain80.class,args);
    }
}
