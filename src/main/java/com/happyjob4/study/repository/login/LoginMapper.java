package com.happyjob4.study.repository.login;

import org.apache.ibatis.annotations.Mapper;

import com.happyjob4.study.vo.login.LoginVo;
import com.happyjob4.study.vo.login.UserVo;

@Mapper
public interface LoginMapper {

	UserVo login(LoginVo vo);
	
}
