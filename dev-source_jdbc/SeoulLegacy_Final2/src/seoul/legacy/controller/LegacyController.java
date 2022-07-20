package seoul.legacy.controller;

import java.util.List;

import seoul.legacy.api.LegacyApiManager;
import seoul.legacy.model.service.LegacyService;
import seoul.legacy.model.vo.Legacy;


public class LegacyController {
	
	private Legacy legacy = null;
	
	private LegacyService legacyService = new LegacyService();
	private ZzimController zc  = new ZzimController();
	
	public void initLegacy() {
		
		List<Legacy> list = LegacyApiManager.callLegacyByXML();
		
		for (Legacy legacy : list) {
			legacyService.insert(legacy);
		}
	}
	
	
	public List<Legacy> selectByLegacyName(String legency_name_kor) {
		return legacyService.selectByLegacyName(legency_name_kor);
	}
	
	public List<Legacy> searchByCategory(String category) {
		return legacyService.selectByCategory(category);
	}
	
	public List<Legacy> selectByLegacyArea(String area){
		return legacyService.selectByLegacyArea(area);
	}
	
	public List<Legacy> selectByEra(String legency_era) {
		return legacyService.selectByEra(legency_era);
	}
	
	
	public static void main(String[] args) {
		LegacyController lc = new LegacyController();
		lc.initLegacy();
	}


	// 추가 - 0606 / 구기혁
	public List<Legacy> topTen() {
		return legacyService.topTen();
	}

	
}




