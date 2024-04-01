package com.happyjob4.study.controller.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard/")
public class DashboardController {

	@RequestMapping("dashboard.do")
	public String dashboardPage() throws Exception {
		
		String returnPage = "";
		
		return returnPage = "/dashboardMgr";
	}
	
}
