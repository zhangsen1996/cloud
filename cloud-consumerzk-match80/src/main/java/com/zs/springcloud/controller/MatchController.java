package com.zs.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class MatchController {


    public static final String Cloud_Url= "http://cloud-provider-match";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/match/zk")
    private String matchInfo(){
        return restTemplate.getForObject(Cloud_Url+"/match/zk",String.class);
    }
}
