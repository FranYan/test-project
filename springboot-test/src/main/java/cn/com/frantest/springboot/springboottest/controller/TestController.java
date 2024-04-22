package cn.com.frantest.springboot.springboottest.controller;

import cn.com.frantest.springboot.springboottest.ds1.Ds1Service;
import cn.com.frantest.springboot.springboottest.ds2.Ds2Service;
import cn.com.frantest.springboot.springboottest.ds2.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private Ds1Service ds1Service;

    @Autowired
    private Ds2Service ds2Service;


    private long i =3L;

    @RequestMapping("/dstest" )
    public String test() {

        String s = ds1Service.getAll() + " " + ds2Service.getAll();

        return s;
    }

    @RequestMapping("/insert")
    public String test2(){

        Users users = new Users();
        users.setId(i++);
        users.setUsername("yanshihao1234");
        ds2Service.insertUser(users);
        return "ok!";
    }

}
