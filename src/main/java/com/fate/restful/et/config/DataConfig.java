//package com.fate.restful.et.config;
//
//import java.sql.SQLException;
//
//import javax.sql.DataSource;
//
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.jdbc.datasource.SimpleDriverDataSource;
//
//@Configuration
//@MapperScan("com.fate.restful.et.persistence")
//public class DataConfig {
//	@Bean
//	public DataSource dataSource() throws SQLException {
//		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
//		dataSource.setDriver(new com.mysql.jdbc.Driver());
//		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/et?useUnicode=true&characterEncoding=utf-8");
//		dataSource.setUsername("root");
//		dataSource.setPassword("dstzhh520");
//		
////		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
////		jdbcTemplate.execute("select 1100 from dual");
//		return dataSource;
//	}
//	
//	@Bean
//	public DataSourceTransactionManager transactionManager() throws SQLException {
//		return new DataSourceTransactionManager(dataSource());
//	}
//	
//	@Bean
//	public SqlSessionFactoryBean sqlSessionFactory() throws Exception{
//		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//		sqlSessionFactory.setDataSource(dataSource());
//		sqlSessionFactory.setTypeAliasesPackage("com.fate.restful.et.domain");
//		return sqlSessionFactory;
//	}
//}
