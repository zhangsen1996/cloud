package com.zs.springcould.service;

import com.zs.springcloud.entities.GameServer;
import com.zs.springcould.dao.MatchDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MatchServiceImpl implements IMatchService{


    @Resource
    private MatchDao paymentDao;

    public int create(GameServer gameServer){
        return paymentDao.create(gameServer);
    }

    public GameServer getGameServerById(Long id){
        return paymentDao.getGameServerById(id);
    }
}
