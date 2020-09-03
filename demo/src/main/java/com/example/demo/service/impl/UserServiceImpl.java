package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<User> findAll () {
        redisUtil.get("all");
        return userDao.findAll();
    }

    @Override
    public int insertUser (String name, int age) {
        return userDao.insertUser(name,age);
    }

    @Override
    public int deleteById (int id) {
        return userDao.deleteById(id);
    }

    @Override
    public int updateUser (int id, String name, int age) {
        return userDao.updateUser(id,name,age);
    }

    public User save(User user){
        return userDao.save(user);
    }

    public int delete(int id){
        return userDao.deleteById(id);
    }

    public User update(User user){
        return userDao.save(user);
    }
}
