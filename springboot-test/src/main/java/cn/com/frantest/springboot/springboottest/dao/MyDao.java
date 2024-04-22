package cn.com.frantest.springboot.springboottest.dao;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//@Repository
public class MyDao implements InitializingBean {

    @Autowired
    @Qualifier("ds1")
    private DataSource dataSource;

    @Override
    public void afterPropertiesSet() throws Exception {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.executeQuery("select * from user");
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void main(String[] args) {

    }
}
