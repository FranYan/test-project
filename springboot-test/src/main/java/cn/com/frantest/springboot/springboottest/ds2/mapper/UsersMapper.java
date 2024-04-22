package cn.com.frantest.springboot.springboottest.ds2.mapper;

import cn.com.frantest.springboot.springboottest.ds2.entity.Users;

import java.util.List;

public interface UsersMapper {

    List<Users> findAll();

    void insertUsers(Users users);
}
