package com.test.mink.service;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Service;

@Service
public class DataSourceServiceImpl implements DataSourceService {

	@Override
	public DataSource createDataSource(String driverClassName, String url, String userName, String password) {
		System.out.println("########### createDataSource");
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		
		return dataSource;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("########### afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("########### destroy");
	}

}
