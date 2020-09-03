package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    int insertUser(String name, int age);

    int deleteById(int id);

    int updateUser(int id, String name, int age);
}
