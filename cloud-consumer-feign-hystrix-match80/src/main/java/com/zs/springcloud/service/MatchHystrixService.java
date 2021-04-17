package com.zs.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-MATCH")
public interface MatchHystrixService {

    @GetMapping("/match/hystrix/success/{id}")
    String gameServerSuccess(@PathVariable("id") Integer id);

    @GetMapping("/match/hystrix/fail/{id}")
    String gameServerFail(@PathVariable("id") Integer id);


}
