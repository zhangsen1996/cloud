package com.zs.springcould.dao;


import com.zs.springcloud.entities.GameServer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MatchDao {

    int create(GameServer gameServer);

    GameServer getGameServerById(@Param("id") Long id);
}
