package com.zs.springcould.service;


import com.zs.springcloud.entities.GameServer;

public interface IMatchService {
    int create(GameServer gameServer);

    GameServer getGameServerById(Long id);
}
