package seoul.legacy.run;

import seoul.legacy.controller.LegacyController;
import seoul.legacy.controller.FacilityController;

public class InitDBRun {
	public static void main(String[] args) {
		FacilityController pc = new FacilityController();
		pc.initFacility();
		
		LegacyController lc = new LegacyController();
		lc.initLegacy();
		
	
	}

}
