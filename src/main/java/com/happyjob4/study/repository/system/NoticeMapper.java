package com.happyjob4.study.repository.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.happyjob4.study.vo.system.NoticeVo;

@Mapper
public interface NoticeMapper {
	List<NoticeVo> noticeList(Map<String, Object> paramMap);
	NoticeVo noticeDetail(Map<String, Object> paramMap);
	int noticeCnt(Map<String, Object> paramMap);
}
