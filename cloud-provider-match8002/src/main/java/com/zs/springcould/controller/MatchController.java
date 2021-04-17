package com.zs.springcould.controller;


import com.zs.springcloud.entities.CommonResult;
import com.zs.springcloud.entities.GameServer;
import com.zs.springcould.service.IMatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MatchController {

    @Autowired
    private IMatchService matchService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/gameserver/create")
    public CommonResult create(@RequestBody GameServer gameServer) {
        int result = matchService.create(gameServer);
        log.info("*********插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功,serverPort+"+serverPort, result);
        } else {
            return new CommonResult(444, "插入失败", null);
        }
    }

    @GetMapping(value = "/gameserver/get/{id}")
    public CommonResult getGameServerById(@PathVariable("id") Long id) {
        GameServer gameServer = matchService.getGameServerById(id);
        if (gameServer != null) {
            return new CommonResult(200, "查询成功,serverPort+"+serverPort, gameServer);
        } else {
            return new CommonResult(444, "查询失败，没有ID："+id, null);
        }
    }
}
