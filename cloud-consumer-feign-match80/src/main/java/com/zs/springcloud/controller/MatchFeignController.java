package com.zs.springcloud.controller;

import com.zs.springcloud.entities.CommonResult;
import com.zs.springcloud.entities.GameServer;
import com.zs.springcloud.service.MatchFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MatchFeignController {


    @Resource
    private MatchFeignService matchFeignService;

    @GetMapping(value ="/consumer/gameserver/get/{id}")
    public CommonResult<GameServer> getGameServerById(@PathVariable("id") Long id){
        return matchFeignService.getGameServerById(id);
    }

    @GetMapping(value ="/timeout")
    public String timeOut(){
        return matchFeignService.timeOut();
    }
}
