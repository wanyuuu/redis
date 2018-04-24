package com.wanyu.service;

import com.wanyu.mapper.UserMapper;
import com.wanyu.model.User;
import com.wanyu.redis.dao.RedisEngineer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by samsung on 2018/1/14.
 */
@Service
public class IUserDaoImpl {
    @Autowired
    private UserMapper udao;
    @Autowired
    private RedisEngineer rdao;
    public void add(User user){
        udao.insert(user);
        int id=user.getId();
        rdao.saveHash("user","user"+id,user);//name key filed
    }
    public List<Object> findAll(){
       return rdao.findAll("user");
    }
    public void del(int key){
        //Mysql删除
        udao.deleteByPrimaryKey(key);
        rdao.del("user","user"+key);
    }
    public User findById(int id){//id和上面key一样
        return rdao.findById("user"+id);
    }
    public void update(User user){
        udao.deleteByPrimaryKey(user.getId());
        udao.insert(user);
        rdao.del("user","user"+user.getId());
        rdao.saveHash("user","user"+user.getId(),user);
    }
}
