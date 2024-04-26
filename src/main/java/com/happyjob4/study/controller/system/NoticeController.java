package com.happyjob4.study.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.happyjob4.study.service.system.NoticeService;
import com.happyjob4.study.vo.system.NoticeVo;

@Controller
@RequestMapping("/system/")
public class NoticeController {
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private NoticeService noticeService;
	
	// 공지사항 리스트 출력
	@PostMapping("noticeList.do")
	@ResponseBody
	public Map<String, Object> noticeListvue(@RequestParam Map<String, Object> paramMap) throws Exception {

		logger.info("   - paramMap : " + paramMap);
		String title = (String) paramMap.get("title");

		int currentPage = Integer.parseInt((String) paramMap.get("currentPage")); // 현재페이지
		int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
		int pageIndex = (currentPage - 1) * pageSize;

		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		//paramMap.put("title", title);

		// 공지사항 목록 조회
		List<NoticeVo> noticeList = noticeService.noticeList(paramMap);
		// 목록 수 추출해서 보내기
		int noticeCnt = noticeService.noticeCnt(paramMap);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("noticeList", noticeList); // 리스트담기
		resultMap.put("noticeCnt", noticeCnt); // 리턴 값 해쉬맵에 담기
		resultMap.put("pageSize", pageSize);
		resultMap.put("currentPage", currentPage);

		return resultMap;
	}

	@PostMapping("noticeDetail.do")
	@ResponseBody
	public Map<String, Object> noticeDetail(@RequestParam Map<String, Object> paramMap) throws Exception {
		logger.info("noticeDatail start");
		logger.info("   - paramMap : " + paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			NoticeVo noticeDetail = noticeService.noticeDetail(paramMap);
			resultMap.put("result", noticeDetail);
			if(noticeDetail.getNoticeNo()>0) resultMap.put("resultMsg", "SUCCESS");
			else resultMap.put("resultMsg", "ERROR");
		} catch (Exception e) {
			throw e;
		}
		return resultMap;
	}
}
