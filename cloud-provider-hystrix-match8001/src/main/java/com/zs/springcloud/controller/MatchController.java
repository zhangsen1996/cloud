package com.zs.springcloud.controller;

import com.zs.springcloud.service.MatchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MatchController {

    @Resource
    private MatchService matchService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/match/hystrix/success/{id}")
    public String gameServerSuccess(@PathVariable("id") Integer id){
        return matchService.gameServerSuccess(id);
    }

    @GetMapping("/match/hystrix/fail/{id}")
    public String gameServerFail(@PathVariable("id") Integer id){
        return matchService.gameServerFail(id);
    }

    @GetMapping("/match/hystrix/circuit/{id}")
    public String gameServerCircuitFail(@PathVariable("id") Integer id){
        return matchService.paymentCircuitBreaker(id);
    }
}
