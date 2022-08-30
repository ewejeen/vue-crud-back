package com.example.common.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = {"com.example.board.mapper"})
public class MyBatisConfig {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private MyBatisSetting properties;

	public SqlSessionFactory sqlSessionFactoryForMyBatis(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setConfigLocation(properties.getConfigLocation());
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(properties.getMapperLocations()));
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SqlSession sqlSessionForMyBatis(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(this.dataSource);
	}
}
