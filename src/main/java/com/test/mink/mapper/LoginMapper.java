package com.test.mink.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.test.mink.model.DbInfo;
import com.test.mink.model.LoginForm;
import com.test.mink.model.UserInfo;

@Mapper
public interface LoginMapper {
	UserInfo selectUserInfoByLoginForm(LoginForm loginForm);
	DbInfo selectDbInfoByOrderCompCd(UserInfo userInfo);
}
