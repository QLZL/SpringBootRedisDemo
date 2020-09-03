package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {

    @Override
    List<User> findAll();

    @Modifying
    @Transactional
    @Query(value = "insert into jpa_user(name,age) values (?,?)", nativeQuery = true)
    int insertUser(@Param("name")String name,@Param("age")int age);

    @Modifying
    @Transactional
    @Query(value = "delete from jpa_user where id=:id")
    int deleteById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "update jpa_user t set t.name=:name,t.age=:age where t.id=:id")
    int updateUser(@Param("id") int id,@Param("name") String name,@Param("age") int age);
}
