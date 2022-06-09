package seoul.legacy.controller;

import java.util.List;

import seoul.legacy.model.service.PalaceService;
import seoul.legacy.model.vo.Palace;

public class PalaceController {
	// 1. 전체 조회

	PalaceService ps = new PalaceService();

	public List<Palace> printAll() {
		return ps.selectAll();
	}
}
