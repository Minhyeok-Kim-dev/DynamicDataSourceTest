package com.test.mink.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public interface DataSourceService extends InitializingBean, DisposableBean{
	DataSource createDataSource(String driverClassName, String url, String userName, String password);
}
