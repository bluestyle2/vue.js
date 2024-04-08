package com.happyjob4.study.controller.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.happyjob4.study.service.login.LoginService;
import com.happyjob4.study.vo.login.LoginVo;
import com.happyjob4.study.vo.login.UserVo;
import com.happyjob4.study.vo.login.UsrMnuAtrtVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	private LoginService service;

	
	@GetMapping("/login")
	public ModelAndView loginPage() throws Exception {
		logger.info("login start page!!");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		
		return mv;
	}
	
	/** 
	 * 로그인
	 * @param vo
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	@ResponseBody
	public Map<String, Object> login(LoginVo vo, HttpSession session ) throws Exception {
		
		logger.info("======login start ======");
		logger.info(vo.getId() + "/" + vo.getPw());
		
		Map<String, Object> resultMap = new HashMap<>();
		UserVo userVo = service.login(vo);
		
		if(userVo == null) {
			//로그인 실패
			resultMap.put("resCode", "F");
			resultMap.put("resMsg", "로그인 실패");
		} else {
			//로그인 성공
			resultMap.put("resCode", "S");
			resultMap.put("resMsg", "로그인 성공");
			
			session.setAttribute("loginId", userVo.getUserId());
			session.setAttribute("userNm", userVo.getUserName());
			
		}
		
		return resultMap;
	}
	
	@PostMapping("/loginProc.do")
	@ResponseBody
	public Map<String, Object> loginProc(LoginVo vo, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {

	      logger.info("+ Start LoginController.loginProc.do");
		  logger.info("   - ParamMap : " + vo);
		    
		  // 사용자 로그인
		  String result;
		  String resultMsg;
		  Map<String, Object> resultMap = new HashMap<String, Object>();
		  
		  try {
			  UserVo userVo = service.login(vo);
			  //logger.info("   - userVo : " + userVo.toString());
			  if (userVo != null) {
				 result = "SUCCESS";
				 resultMsg = "사용자 로그인 정보가 일치 합니다.";
		  	       
		  	     // 메뉴 목록 조회 0depth
		  	     List<UsrMnuAtrtVo> usrMnuAtrtList = service.usrMnuAtrtList(userVo);
		  	     // 메뉴 목록 조회 1depth
		  	     for(UsrMnuAtrtVo list : usrMnuAtrtList){
		  	        Map<String, Object> resultMapSub = new HashMap<String, Object>();
		  	        resultMapSub.put("lgnId", userVo.getUserId()); 
		  	        resultMapSub.put("hirMnuId", list.getMnuId());
		  	        resultMapSub.put("userType",userVo.getUserType());
		  	        list.setNodeList(service.usrChildMnuAtrtList(resultMapSub));
		  	     }
		  	     
		  	     session.setAttribute("loginId",userVo.getUserId());                     //   로그인 ID
		  	     session.setAttribute("userNm",userVo.getUserName());                  // 사용자 성명
		  	     session.setAttribute("usrMnuAtrt", usrMnuAtrtList);
		  	     session.setAttribute("userType", userVo.getUserType());            // 로그린 사용자 권란       A: 관리자 G:일반회원
		  	     session.setAttribute("serverName", request.getServerName());
		  	
		  	     resultMap.put("loginId",userVo.getUserId()); 
		  	     resultMap.put("userNm",userVo.getUserName()); 
		  	     resultMap.put("usrMnuAtrt", usrMnuAtrtList);
		  	     resultMap.put("userType", userVo.getUserType());
		  	     resultMap.put("serverName", request.getServerName());
		  	       
			} else {
		         result = "FALSE";
		         resultMsg = "사용자 로그인 정보가 일치하지 않습니다.";
		    }

		    resultMap.put("result", result);
		    resultMap.put("resultMsg", resultMsg);
		    resultMap.put("serverName", request.getServerName());
	  
		  } catch (Exception e) {
			    e.printStackTrace();
		  }	  
	  
	    logger.info("+ End LoginController.loginProc.do");

	    return resultMap;
	}
	
	/**
	 * 로그아웃
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/loginOut.do")
	public ModelAndView loginOut(HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView();
		session.invalidate();
		//mav.setViewName("redirect:/login");
		
		return mav;
	}

}
