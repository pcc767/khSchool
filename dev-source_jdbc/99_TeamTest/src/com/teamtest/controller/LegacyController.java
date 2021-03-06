package com.teamtest.controller;

import java.util.List;

import com.teamtest.api.LegacyApiManager;
import com.teamtest.model.vo.Legacy;
import com.teamtest.service.LegacyService;

public class LegacyController {
	
	private LegacyService legacyService = new LegacyService();
	
	public void initLegacy() {
		
		List<Legacy> list = LegacyApiManager.callLegacyByXML();
		
		for (Legacy legacy : list) {
			legacyService.insert(legacy);
		}
	}
	
	// -------------------------------------------------------------
	
	public List<Legacy> selectByLegacyName(String legency_name_kor) {
		return legacyService.selectByLegacyName(legency_name_kor);
	}
	
	public List<Legacy> selectByLegacyNameDetail(String legency_name_kor) {
		return legacyService.selectByLegacyNameDetail(legency_name_kor);
	}
	
	public List<Legacy> selectByCategoryName(String legency_category_name) {
		return legacyService.selectByCategoryName(legency_category_name);
	}
	
	public List<Legacy> selectByCategoryNameDetail(String legency_category_name) {
		return legacyService.selectByCategoryNameDetail(legency_category_name);
	}
	
	public List<Legacy> selectByArea(String legency_area) {
		return legacyService.selectByArea(legency_area);
	}
	
	public List<Legacy> selectByAreaDetail(String legency_area) {
		return legacyService.selectByAreaDetail(legency_area);
	}
	
	public List<Legacy> selectByEra(String legency_era) {
		return legacyService.selectByEra(legency_era);
	}
	
	public List<Legacy> selectByEraDetail(String legency_era) {
		return legacyService.selectByEraDetail(legency_era);
	}
	
	public Legacy selectOne(String legency_no) {
		return legacyService.selectOne(legency_no);
	}
	
	public static void main(String[] args) {
		LegacyController lc = new LegacyController();
		lc.initLegacy();
	}

}
