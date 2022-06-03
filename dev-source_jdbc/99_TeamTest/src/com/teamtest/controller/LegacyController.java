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
	
	public static void main(String[] args) {
		LegacyController lc = new LegacyController();
		lc.initLegacy();
	}

}
