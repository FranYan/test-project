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

import javax.sql.DataSource;

@Configuration
public class MybatisDs2Config {

    @Bean(name = "ds2")
    @ConfigurationProperties(prefix = "testdata.datasource.ds2")
    public DataSource ds2Datasource() {
        return new HikariDataSource();
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory2(@Qualifier("ds2") DataSource dataSource) {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer2(){

        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setSqlSessionFactoryBeanName("sqlSessionFactory2");
        msc.setBasePackage("cn.com.frantest.springboot.springboottest.ds2.mapper");
        return msc;
    }

    @Bean("transaction2")
    public DataSourceTransactionManager transactionManager1(@Qualifier("ds2") DataSource dataSource) {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource);
        return manager;
    }
}
