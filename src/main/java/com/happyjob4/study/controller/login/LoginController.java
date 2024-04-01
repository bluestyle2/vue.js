package com.happyjob4.study.controller.login;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.happyjob4.study.service.login.LoginService;
import com.happyjob4.study.vo.login.LoginVo;
import com.happyjob4.study.vo.login.UserVo;

import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {

	private final Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	private LoginService service;
	
	@GetMapping("/login")
	public ModelAndView loginPage() throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		
		return mv;
	}

	@PostMapping("/login")
	@ResponseBody
	public Map<String,Object> login(LoginVo vo, HttpSession session) throws Exception{
		
		UserVo userVo = service.login(vo);

		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		logger.info("====================== login start ====================");
		logger.info(vo.getId() + "/" + vo.getPw());
		if(userVo == null) {
			//로그인 실패
			resultMap.put("resCode", "F");
			resultMap.put("resMsg", "로그인 실패");
		}else{
			//로그인 성공
			resultMap.put("resCode", "S");
			resultMap.put("resMsg", "로그인 성공");
		}
		
		session.setAttribute("loginID", userVo.getUserId());
		session.setAttribute("loginNm", userVo.getUserName());
		
		return resultMap; 
	}
	
}