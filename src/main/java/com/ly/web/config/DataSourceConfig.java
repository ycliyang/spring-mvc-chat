package com.ly.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.logging.Logger;

/**
 * Created by liyang on 15/3/25.
 */
@Configuration
//加载资源文件
@PropertySource({"classpath:persistence-mysql.properties"})
public class DataSourceConfig {
    private static final Logger logger = Logger.getLogger(String.valueOf(DataSourceConfig.class));
    /*
     * 绑定资源属性
     */
    @Value("${jdbc.driverClassName}")
    String driverClass;
    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.user}")
    String userName;
    @Value("${jdbc.pass}")
    String passWord;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        logger.info("DataSource");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(passWord);
        return dataSource;
    }
}