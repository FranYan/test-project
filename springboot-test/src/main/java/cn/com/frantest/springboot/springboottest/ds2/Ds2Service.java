package cn.com.frantest.springboot.springboottest.ds2;

import cn.com.frantest.springboot.springboottest.ds2.entity.Users;
import cn.com.frantest.springboot.springboottest.ds2.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Ds2Service {

    @Autowired
    private UsersMapper usersMapper;

    public List<Users> getAll() {

        return usersMapper.findAll();
    }

    @Transactional(value = "transaction2")
    public void insertUser(Users users) {
        usersMapper.insertUsers(users);
        if (users.getId() % 2 == 0) {
            throw new RuntimeException("事务测试");
        }
    }

}
