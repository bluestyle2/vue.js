package com.happyjob4.study.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyjob4.study.repository.system.NoticeMapper;
import com.happyjob4.study.vo.system.NoticeVo;

@Service
public class NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;
	
	public List<NoticeVo> noticeList(Map<String, Object> paramMap) throws Exception {
		return noticeMapper.noticeList(paramMap);
	}
	
	public NoticeVo noticeDetail(Map<String, Object> paramMap) throws Exception {
		return noticeMapper.noticeDetail(paramMap);
	}
	
	public int noticeCnt(Map<String, Object> paramMap) throws Exception {
		return noticeMapper.noticeCnt(paramMap);
	}
}
