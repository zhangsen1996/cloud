package com.zs.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zs.springcloud.service.MatchHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "defaultGameServerFailHandler")
public class controller {


    @Resource
    private MatchHystrixService matchHystrixService;


    @GetMapping("/consumer/hystrix/success/{id}")
    public String gameServerSuccess(@PathVariable("id") Integer id){
        return matchHystrixService.gameServerSuccess(id);
    }

    @GetMapping("/consumer/hystrix/fail/{id}")
//    @HystrixCommand(fallbackMethod = "gameServerFailHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="1500")
//    })
    @HystrixCommand
    public String gameServerFail(@PathVariable("id") Integer id){
        int i = 10 / 0;
        String s = matchHystrixService.gameServerFail(id);
        System.out.println("-------------"+s);
        return s;
    }


    public String gameServerFailHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"failHandler80,id:"+id;
    }

    public String defaultGameServerFailHandler(){
        return "线程池："+Thread.currentThread().getName()+"defaultGameServerFailHandler80";
    }
}
