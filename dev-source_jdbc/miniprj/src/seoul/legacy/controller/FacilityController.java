package seoul.legacy.controller;

import java.util.List;

import seoul.legacy.model.service.FacilityService;
import seoul.legacy.model.vo.Facility;

public class FacilityController {

	// 1. 시설 List 출력
	// 2. 시설 상세 조회
	public List<Facility> searchByPNo(int palaceNo) {
		return new FacilityService().selectByPalaceNO(palaceNo);
	}

	public String printDetail(int fNo) {

		return new FacilityService().selectOneByFacilityNO(fNo).detailToString();
	}
}
