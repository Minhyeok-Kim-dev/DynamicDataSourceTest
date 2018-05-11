package com.test.mink.service;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.test.mink.common.SessionUtil;
import com.test.mink.mapper.DummyMapper;
import com.test.mink.model.Dummy;

@Service
public class DummyServiceImpl implements DummyService {
	
	@Override
	public List<Dummy> searchDummyList() throws Exception {
		DataSource dataSource = (DataSource) SessionUtil.getAttribute("dataSource");
		if(dataSource == null) {
			return null;
		}
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new XmlWebApplicationContext();
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(ctx.getResources("classpath*:mapper/*.xml"));
		sqlSessionFactoryBean.setTypeAliasesPackage("com.test.mink.model");
		
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
		
		@SuppressWarnings("resource")
		SqlSessionTemplate sqlSession = new SqlSessionTemplate(sqlSessionFactory);
		DummyMapper dummyMapper = sqlSession.getMapper(DummyMapper.class);
		
		return dummyMapper.selectDummyList();
	}

}
