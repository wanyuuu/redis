package com.wanyu.controller;

import com.wanyu.model.User;
import com.wanyu.service.IUserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by samsung on 2018/1/14.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    IUserDaoImpl service;
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody User user){
        service.add(user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public ResponseEntity<List<User>> queryAll(){
        List list=service.findAll();
        return new ResponseEntity<List<User>>(list,HttpStatus.OK);
    }
    @RequestMapping(value = "/del/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> del(@PathVariable int id){
        service.del(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @RequestMapping(value = "/queryid/{id}",method = RequestMethod.GET)
    public ResponseEntity<User> queryById(@PathVariable int id){
        User user=service.findById(id);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseEntity<Void> update(@RequestBody User user){
        service.update(user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
