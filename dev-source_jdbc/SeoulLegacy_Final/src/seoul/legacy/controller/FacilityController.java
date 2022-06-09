package seoul.legacy.controller;

import java.util.List;

import seoul.legacy.api.FacilityApiManager;
import seoul.legacy.model.service.FacilityService;
import seoul.legacy.model.vo.Facility;

public class FacilityController {
	
	private FacilityService facilityService = new FacilityService();
	
	public void initFacility() {
		
		List<Facility> list = FacilityApiManager.callPalaceByXML();
		
		for (Facility facility : list) {
			facilityService.insert(facility);
		}
	}
	
	public static void main(String[] args) {
		FacilityController fc = new FacilityController();
		fc.initFacility();
	}

}
