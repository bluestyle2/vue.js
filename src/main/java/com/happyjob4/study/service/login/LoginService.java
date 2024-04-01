package com.happyjob4.study.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyjob4.study.repository.login.LoginMapper;
import com.happyjob4.study.vo.login.LoginVo;
import com.happyjob4.study.vo.login.UserVo;

@Service
public class LoginService {
	
	@Autowired
	private LoginMapper mapper;
	
	public UserVo login(LoginVo vo) {
		
		return mapper.login(vo);
	}
	
}
