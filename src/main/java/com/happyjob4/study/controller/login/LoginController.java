package com.happyjob4.study.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@GetMapping("/login")
	public ModelAndView loginPage() throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		
		return mv;
	}
	
}
