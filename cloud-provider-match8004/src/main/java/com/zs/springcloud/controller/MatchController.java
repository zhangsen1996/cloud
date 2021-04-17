package com.zs.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class MatchController {




    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/match/zk")
    private String paymentzk(){
        return "springcloud with zookeeper" + serverPort +"\t"+ System.currentTimeMillis();
    }

    @GetMapping(value = "/match/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*************service:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-match-service");
        for (ServiceInstance instance : instances) {
            log.info("*************instance:"+instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort());
        }
        return discoveryClient;
    }
}
