package cn.com.frantest.springboot.springboottest.ds1;

import cn.com.frantest.springboot.springboottest.ds1.entity.User;
import cn.com.frantest.springboot.springboottest.ds1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ds1Service {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAll() {

        return userMapper.findAll();
    }

}
