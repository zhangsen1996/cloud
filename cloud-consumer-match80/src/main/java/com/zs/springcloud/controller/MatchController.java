package com.zs.springcloud.controller;

import com.zs.springcloud.entities.CommonResult;
import com.zs.springcloud.entities.GameServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class MatchController {

    @Autowired
    private RestTemplate restTemplate;
    public static final String Url= "http://127.0.0.1:8001";
    public static final String Cloud_Url= "http://CLOUD-MATCH-SERVICE";

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/match/create")
    public CommonResult<GameServer> create(GameServer gameServer){
        return restTemplate.postForObject(Cloud_Url+"/gameserver/create", gameServer,CommonResult.class);
    }

    @GetMapping("/gameserver/get/{id}")
    public CommonResult<GameServer> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(Cloud_Url+"/gameserver/get/"+id,CommonResult.class);
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
