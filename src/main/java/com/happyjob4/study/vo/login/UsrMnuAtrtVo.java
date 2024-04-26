package com.happyjob4.study.vo.login;

import java.util.ArrayList;
import java.util.List;

public class UsrMnuAtrtVo {
	// 메뉴 ID
	private String mnuId;
	// 부모 메뉴 ID
	private String hirMnuId;
	// 메뉴 명
	private String mnuNm;
	// 메뉴 URL
	private String mnuUrl;
	// 메뉴 구분 코드
	private String mnuDvsCod;
	// 그룹 번호
	private String grpNum;
	// 메뉴 순번
	private String odr;
	// 메뉴 레벨
	private String lvl;
	// 메뉴 아이콘 코드
	private String mnuIcoCod;
	// 자식 node List
	private List<UsrMnuChildAtrtVo> nodeList = new ArrayList<UsrMnuChildAtrtVo>();

	public String getMnuId() {
		return mnuId;
	}

	public void setMnuId(String mnuId) {
		this.mnuId = mnuId;
	}

	public String getHirMnuId() {
		return hirMnuId;
	}

	public void setHirMnuId(String hirMnuId) {
		this.hirMnuId = hirMnuId;
	}

	public String getMnuNm() {
		return mnuNm;
	}

	public void setMnuNm(String mnuNm) {
		this.mnuNm = mnuNm;
	}

	public String getMnuUrl() {
		return mnuUrl;
	}

	public void setMnuUrl(String mnuUrl) {
		this.mnuUrl = mnuUrl;
	}

	public String getMnuDvsCod() {
		return mnuDvsCod;
	}

	public void setMnuDvsCod(String mnuDvsCod) {
		this.mnuDvsCod = mnuDvsCod;
	}

	public String getGrpNum() {
		return grpNum;
	}

	public void setGrpNum(String grpNum) {
		this.grpNum = grpNum;
	}

	public String getOdr() {
		return odr;
	}

	public void setOdr(String odr) {
		this.odr = odr;
	}

	public String getLvl() {
		return lvl;
	}

	public void setLvl(String lvl) {
		this.lvl = lvl;
	}

	public String getMnuIcoCod() {
		return mnuIcoCod;
	}

	public void setMnuIcoCod(String mnuIcoCod) {
		this.mnuIcoCod = mnuIcoCod;
	}

	public List<UsrMnuChildAtrtVo> getNodeList() {
		return nodeList;
	}

	public void setNodeList(List<UsrMnuChildAtrtVo> nodeList) {
		this.nodeList = nodeList;
	}
		
}
