package com.zs.springcloud;


import com.zs.springcloud.lb.MyLoadBalancer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RibbonClient(name = "CLOUD-MATCH-SERVICE",configuration = MyLoadBalancer.class)
public class MatchMain80 {
    public static void main(String[] args) {
        SpringApplication.run(MatchMain80.class,args);
    }
}

