package cn.com.frantest.springboot.springboottest.ds1.mapper;

import cn.com.frantest.springboot.springboottest.ds1.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> findAll();
}
