package seoul.legacy.controller;

import java.util.List;

import seoul.legacy.api.LegacyApiManager;
import seoul.legacy.model.service.LegacyService;
import seoul.legacy.model.service.ZzimService;
import seoul.legacy.model.vo.Legacy;

public class LegacyController {

	// 1. 이름 검색
	// 2. 종목 검색
	// 3. 시대 검색
	// 4. 지역 검색
	// 5. 상세 정보 출력
	// 6. Top-10

	private LegacyService legacyService = new LegacyService();
	private ZzimService zs = new ZzimService();

	public void initLegacy() {

		List<Legacy> list = LegacyApiManager.callLegacyByXML();

		for (Legacy legacy : list) {
			legacyService.insert(legacy);
		}
	}

	public List<Legacy> selectByLegacyName(String legency_name_kor) {
		return legacyService.selectByName(legency_name_kor);
	}

	public List<Legacy> searchByCategory(String category) {
		return legacyService.selectByCategory(category);
	}

	public List<Legacy> selectByLegacyArea(String area) {
		return legacyService.selectByLegacyArea(area);
	}

	public List<Legacy> searchByEra(String legency_era) {
		return legacyService.selectByEra(legency_era);
	}

	public List<Legacy> topTen() {
		return legacyService.topTen();
	}

	public String printDetail(int lNo) {
		return legacyService.selectOneByNo(lNo).detailToString() + "\n찜 횟수 : " + zs.countZzim(lNo);
	}
	
	public Legacy searchByNo(int lNo) {
		return legacyService.selectOneByNo(lNo);
	}
	

}
