package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/insert")
    public String insert(@RequestParam("name") String name, @RequestParam("age") int age){
        int result=userService.insertUser(name,age);
        if(result>=1){
            return "添加成功";
        }else{
            return "添加失败";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id")int id){
        int result=userService.deleteById(id);
        if(result>=1){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }

    @GetMapping("/update")
    public String update(@RequestParam("id")int id,@RequestParam("name")String name,@RequestParam("age")int age){
        int result=userService.updateUser(id, name, age);
        if(result>=1){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

    @PostMapping("/save")
    public User save(User user){
        return userService.save(user);
    }

    @DeleteMapping("/deleteById")
    public String deleteById(int id){
        int result=userService.delete(id);
        if(result>=1){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }

    @PutMapping("/updateById")
    public User updateById(User user){
        return userService.update(user);
    }

    @GetMapping("/redisAll")
    public List<User> RedisAll(){
        redisUtil.set("all", userService.findAll().toString());
        return userService.findAll();
    }

}
