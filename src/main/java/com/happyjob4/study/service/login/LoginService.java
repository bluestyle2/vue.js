package com.happyjob4.study.service.login;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyjob4.study.vo.login.UsrMnuAtrtVo;
import com.happyjob4.study.vo.login.UsrMnuChildAtrtVo;
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
	
	/** 사용자 메뉴 권한 */
	public List<UsrMnuAtrtVo> usrMnuAtrtList(UserVo userVo) throws Exception {
		return mapper.usrMnuAtrtList(userVo);
	}

	/** 사용자 자식 메뉴 권한 */
	public List<UsrMnuChildAtrtVo> usrChildMnuAtrtList(Map<String, Object> params) throws Exception {
		return mapper.usrChildMnuAtrtList(params);

	}
	
}
