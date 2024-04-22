package cn.com.frantest.springboot.springboottest.mybatiscfg;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

@Configuration
public class MybatisDs1Config {

    @Bean(name = "ds1")
    @ConfigurationProperties(prefix = "testdata.datasource.ds1")
    public DataSource ds1Datasource() {
        return new HikariDataSource();
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory1(@Qualifier("ds1") DataSource dataSource) {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer1(){

        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setSqlSessionFactoryBeanName("sqlSessionFactory1");
        msc.setBasePackage("cn.com.frantest.springboot.springboottest.ds1.mapper");
        return msc;
    }

    @Bean("transaction1")
    public DataSourceTransactionManager transactionManager1(@Qualifier("ds1") DataSource dataSource) {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource);
        return manager;
    }

}
