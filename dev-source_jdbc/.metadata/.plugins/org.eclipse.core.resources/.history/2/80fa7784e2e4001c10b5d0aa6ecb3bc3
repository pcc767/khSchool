package com.teamtest.controller;

import java.util.List;

import com.teamtest.api.PalaceApiManager;
import com.teamtest.model.vo.Palace;
import com.teamtest.service.PalaceService;

public class PalaceController {
	
	private PalaceService palaceService = new PalaceService();
	
	public void initPalace() {
		
		List<Palace> list = PalaceApiManager.callPalaceByXML();
		
		for (Palace palace : list) {
			palaceService.insert(palace);
		}
	}
	
	public static void main(String[] args) {
		PalaceController pc = new PalaceController();
		pc.initPalace();
	}

}
