package com.wanyu.redis.dao;

import com.wanyu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by samsung on 2018/1/14.
 */
//redis 的dao层
@Repository
public class RedisEngineer {
    @Autowired
    private RedisTemplate<Serializable,Serializable> redisTemplate;
    @Autowired
    private RedisTemplate<String,String> redisTemplate1;
    public void saveHash(String name,String key,Object value){
        HashOperations hash= redisTemplate.opsForHash();
        hash.put(name,key,value);
    }
    public List<Object> findAll(String name){
        HashOperations hash=redisTemplate.opsForHash();
        List<Object> list=hash.values(name);
        //hash名 key value    通过hash名得到value  value存的是user对象
        return list;
    }
    public void del(String name,String key)
    {
        HashOperations hash=redisTemplate.opsForHash();
        hash.delete(name,key);
    }
    public User findById(String key){
        HashOperations hash=redisTemplate.opsForHash();
        //根据组合user+id的键找到user对象
        User user=(User)hash.get("user",key);
        return user;
    }
}
