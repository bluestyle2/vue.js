package com.happyjob4.study.repository.login;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.happyjob4.study.vo.login.UsrMnuAtrtVo;
import com.happyjob4.study.vo.login.UsrMnuChildAtrtVo;
import com.happyjob4.study.vo.login.LoginVo;
import com.happyjob4.study.vo.login.UserVo;

@Mapper
public interface LoginMapper {

	UserVo login(LoginVo vo);
	List<UsrMnuAtrtVo> usrMnuAtrtList(UserVo userVo);
	List<UsrMnuChildAtrtVo> usrChildMnuAtrtList(Map<String, Object> params);
}
