package com.mini.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.UserTransaction;
import java.util.Arrays;

/**
 * @Filename: DataBaseConfig
 * @Description: DataBaseConfig
 * @Version: 1.0.0
 * @Author: louMT
 * @Email: LouMT@keeson.com
 * @Date: 2020-11-09 19:52
 */

@Configuration
public class DataBaseConfig
{
    @Value("${db.driver}")
    private String jdbcDriver;

    @Value("${db1.url}")
    private String db1Url;

    @Value("${db1.username}")
    private String db1UserName;

    @Value("${db1.password}")
    private String db1Password;

    @Bean(name = "ds1", initMethod = "init", destroyMethod = "close")
    public DataSource ds1()
    {
        DruidXADataSource ds = new DruidXADataSource();
        ds.setDriverClassName(jdbcDriver);
        ds.setUrl(db1Url);
        ds.setUsername(db1UserName);
        ds.setPassword(db1Password);
        ds.setDefaultAutoCommit(false);
        ds.setConnectionInitSqls(Arrays.asList("set names utf8mb4;"));
        ds.setRemoveAbandoned(true);
        ds.setRemoveAbandonedTimeout(180);
        ds.setValidationQuery("SELECT 1");
        ds.setTestWhileIdle(true);
        ds.setTestOnBorrow(false);
        ds.setTestOnReturn(false);
        AtomikosDataSourceBean atomikosDsBean = new AtomikosDataSourceBean();
        atomikosDsBean.setXaDataSource(ds);
        atomikosDsBean.setUniqueResourceName("ds1");
        atomikosDsBean.setMaintenanceInterval(60);
        atomikosDsBean.setTestQuery("SELECT 1");
        atomikosDsBean.setMinPoolSize(5);
        atomikosDsBean.setMaxPoolSize(20);
        return atomikosDsBean;
    }

    // =============================================�����ݿ������=============================================//

    @Value("${db2.url}")
    private String db2Url;

    @Value("${db2.username}")
    private String db2UserName;

    @Value("${db2.password}")
    private String db2Password;

    @Bean(name = "ds2", initMethod = "init", destroyMethod = "close")
    public DataSource ds2()
    {
        DruidXADataSource ds = new DruidXADataSource();
        ds.setDriverClassName(jdbcDriver);
        ds.setUrl(db2Url);
        ds.setUsername(db2UserName);
        ds.setPassword(db2Password);
        ds.setDefaultAutoCommit(false);
        ds.setConnectionInitSqls(Arrays.asList("set names utf8mb4;"));
        ds.setRemoveAbandoned(true);
        ds.setRemoveAbandonedTimeout(180);
        ds.setValidationQuery("SELECT 1");
        ds.setTestWhileIdle(true);
        ds.setTestOnBorrow(false);
        ds.setTestOnReturn(false);
        AtomikosDataSourceBean atomikosDsBean = new AtomikosDataSourceBean();
        atomikosDsBean.setXaDataSource(ds);
        atomikosDsBean.setUniqueResourceName("ds2");
        atomikosDsBean.setMaintenanceInterval(60);
        atomikosDsBean.setTestQuery("SELECT 1");
        atomikosDsBean.setMinPoolSize(5);
        atomikosDsBean.setMaxPoolSize(20);
        return atomikosDsBean;
    }

    // =============================================������Դ����������=============================================//

    @Bean
    public JtaTransactionManager regTransactionManager()
    {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        UserTransaction userTransaction = new UserTransactionImp();
        return new JtaTransactionManager(userTransaction, userTransactionManager);
    }
}

