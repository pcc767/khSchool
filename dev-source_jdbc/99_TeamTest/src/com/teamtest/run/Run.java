package com.teamtest.run;

import com.teamtest.controller.LegacyController;
import com.teamtest.controller.PalaceController;

public class Run {
	public static void main(String[] args) {
		PalaceController pc = new PalaceController();
		pc.initPalace();
		
		LegacyController lc = new LegacyController();
		lc.initLegacy();
		
	
	}

}
