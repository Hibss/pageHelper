package com.jfz.pageHelper.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/14 17:33
 */
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "erpDb")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource1() {
        return new DruidDataSource();
    }


    @Bean
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("erpDb") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
