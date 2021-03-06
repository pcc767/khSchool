package com.teamtest.controller;

import java.util.List;

import com.teamtest.api.PalaceApiManager;
import com.teamtest.model.vo.Palace;
import com.teamtest.service.PFacilityService;
import com.teamtest.service.PalaceService;

public class PalaceController {

	private PalaceService ps = new PalaceService();
	private PFacilityService pfs = new PFacilityService();
	
	public void initPalace() {
		
		List<Palace> list = PalaceApiManager.callPalaceByXML();
		
		for (Palace palace : list) {
			ps.insert(palace);
		}
	}

	public List<Palace> selectAll(){
		return ps.selectAll();
	}

	public Palace selectOne(String palaceName){
		return ps.selectOne(palaceName);
	}

//	PFacilityService-----------------------------------------------------------------------

	public List<Palace>	selectByPNo(int palace_no){
		return pfs.selectByPNo(palace_no);
	}

	
	public static void main(String[] args) {
		PalaceController pc = new PalaceController();
		pc.initPalace();
	}
}
