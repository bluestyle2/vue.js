package com.happyjob4.study.controller.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard/")
public class DashboardController {

	@GetMapping("dashboard.do")
	public String dashboardPage() throws Exception {
		
		String returnPage = "/dashboardMgr";
		
		return returnPage;
	}
	
}
