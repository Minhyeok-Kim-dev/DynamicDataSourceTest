package com.test.mink.service;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.test.mink.common.SessionUtil;
import com.test.mink.mapper.LoginMapper;
import com.test.mink.model.DbInfo;
import com.test.mink.model.LoginForm;
import com.test.mink.model.UserInfo;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	DataSourceService dataSourceService;
	
	@Autowired
	BasicDataSource defaultDataSource;
	
	@Override
	public void login(LoginForm loginForm) throws Exception {
		// 로그인 인증 서버 접속
		DataSource certDataSource = dataSourceService.createDataSource(
				"com.microsoft.sqlserver.jdbc.SQLServerDriver",
				"jdbc:sqlserver://nowweb.newgensoft.co.kr:1433;databaseName=test",
				"mink", 
				"1234");
		
		@SuppressWarnings("resource")
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(certDataSource);
		sqlSessionFactoryBean.setMapperLocations(ctx.getResources("classpath*:mapper/*.xml"));
		sqlSessionFactoryBean.setTypeAliasesPackage("com.test.mink.model");
		
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
		
		@SuppressWarnings("resource")
		SqlSessionTemplate sqlSession = new SqlSessionTemplate(sqlSessionFactory);
		LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);

		UserInfo userInfo = loginMapper.selectUserInfoByLoginForm(loginForm);
		
		// 세션 초기화
		SessionUtil.setAttribute("dataSource", null);
		
		// 사용자 있는 경우
		if(userInfo != null) {
			System.out.println(userInfo);
			
			// 사용자의 DB정보 가져옴
			DbInfo dbInfo = loginMapper.selectDbInfoByOrderCompCd(userInfo);
			
			// DB정보 있는 경우 DataSource 생성 후 세션에 추가
			// DB정보 없는경우 Bean에서 가져옴 (Default DB사용)
			if(dbInfo != null) {
				DataSource dataSource = dataSourceService.createDataSource(
						"org.mariadb.jdbc.Driver",
						dbInfo.getUrl(),
						dbInfo.getUserName(), 
						dbInfo.getPassword()); 
				
				SessionUtil.setAttribute("dataSource", dataSource);
			} else {
				SessionUtil.setAttribute("dataSource", defaultDataSource);
			}
		}
		
	}

}
