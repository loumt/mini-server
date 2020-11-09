package com.mini.config;

import com.github.pagehelper.PageInterceptor;
import com.mini.utils.AutoEnumTypeHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class MybatisConfig
{
	
	// =============================================主数据库的配置=============================================//

	private static final String MAPPER1_PATH = "classpath*:mapper1/**.xml";

	@Bean("mybatisCfg1")
	@ConfigurationProperties(prefix = "mybatis.configuration")
	public org.apache.ibatis.session.Configuration mybatisCfg1()
	{
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		// 取得类型转换注册器
		TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
		// 注册默认枚举转换器
		typeHandlerRegistry.setDefaultEnumTypeHandler(AutoEnumTypeHandler.class);
		return configuration;
	}
	
	@Bean(name = "db1SessionFactory")
	public SqlSessionFactoryBean db1SqlSessionFactory(@Qualifier("ds1") DataSource dataSource,
			@Qualifier("mybatisCfg1") org.apache.ibatis.session.Configuration configuration) throws IOException
	{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		Resource[] resources = new PathMatchingResourcePatternResolver().getResources(MybatisConfig.MAPPER1_PATH);
		sqlSessionFactoryBean.setMapperLocations(resources);
		sqlSessionFactoryBean.setConfiguration(configuration);
		// 配置分页插件
		PageInterceptor pageInterceptor = new PageInterceptor();
		pageInterceptor.setProperties(new Properties());
		Interceptor[] plugins = {pageInterceptor};
		sqlSessionFactoryBean.setPlugins(plugins);
		return sqlSessionFactoryBean;
	}

	@Bean
	public MapperScannerConfigurer db1MapperScannerConfigurer()
	{
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.mini.dao1");
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("db1SessionFactory");
		return mapperScannerConfigurer;
	}

	// =============================================从数据库的配置=============================================//

	private static final String MAPPER2_PATH = "classpath*:mapper2/**.xml";

	@Bean("mybatisCfg2")
	@ConfigurationProperties(prefix = "mybatis.configuration")
	public org.apache.ibatis.session.Configuration mybatisCfg2()
	{
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		// 取得类型转换注册器
		TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
		// 注册默认枚举转换器
		typeHandlerRegistry.setDefaultEnumTypeHandler(AutoEnumTypeHandler.class);
		return configuration;
	}
	
	@Bean(name = "db2SessionFactory")
	public SqlSessionFactoryBean db2SqlSessionFactory(@Qualifier("ds2") DataSource dataSource,
			@Qualifier("mybatisCfg2") org.apache.ibatis.session.Configuration configuration) throws IOException
	{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		Resource[] resources = new PathMatchingResourcePatternResolver().getResources(MybatisConfig.MAPPER2_PATH);
		sqlSessionFactoryBean.setMapperLocations(resources);
		sqlSessionFactoryBean.setConfiguration(configuration);
		// 配置分页
		PageInterceptor pageInterceptor = new PageInterceptor();
		pageInterceptor.setProperties(new Properties());
		Interceptor[] plugins = {pageInterceptor};
		sqlSessionFactoryBean.setPlugins(plugins);
		return sqlSessionFactoryBean;
	}

	@Bean
	public MapperScannerConfigurer db2MapperScannerConfigurer()
	{
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.mini.dao2");
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("db2SessionFactory");
		return mapperScannerConfigurer;
	}
	
}
