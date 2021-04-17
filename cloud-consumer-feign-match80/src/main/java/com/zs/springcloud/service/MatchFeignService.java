package com.zs.springcloud.service;

import com.zs.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-MATCH-SERVICE")
public interface MatchFeignService {


    @GetMapping(value = "/gameserver/get/{id}")
    public CommonResult getGameServerById(@PathVariable("id") Long id);

    @GetMapping(value = "/timeout")
    public String timeOut();
}
