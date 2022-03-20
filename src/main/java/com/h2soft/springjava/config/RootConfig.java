package com.h2soft.springjava.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//@Configuration Bean을 등록할때 싱글톤(singleton)이 되도록 보장해준다. 스프링컨테이너에서 Bean을 관리할수있게 됨.

@Configuration
@ComponentScan(basePackages = {"com.h2soft.sample"})
@MapperScan(basePackages = {"com.h2soft.mapper"})
public class RootConfig {
	
	//DataSource 연결
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		
		//hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		//hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:xe");
		hikariConfig.setUsername("scott");
		hikariConfig.setPassword("tiger");
		
		/*
		hikariConfig.setDriverClassName("org.mariadb.jdbc.Driver");
		//hikariConfig.setJdbcUrl("jdbc:mariadb://localhost:3306/groupware");
		hikariConfig.setJdbcUrl("jdbc:mariadb://52.78.27.249:3306/groupware");
		hikariConfig.setUsername("scott");
		hikariConfig.setPassword("tiger");
		*/
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
	}
	
	//Mybatis 연결
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());		
		
		return (SqlSessionFactory)sqlSessionFactory.getObject();
	}
	
}
