package seoul.legacy.controller;

import java.util.List;

import seoul.legacy.model.service.ZzimService;
import seoul.legacy.model.vo.Zzim;

public class ZzimController {

	// 1. 개인 찜 목록
	// 2. 문화재 별 찜 횟수
	// 3. 찜 추가

	private ZzimService zs = new ZzimService();

	public List<Zzim> searchPrivZzim(String id) {
		return zs.selectById(id);
	}

	public int countZzim(int lNo) {
		return zs.countZzim(lNo);
	}

	public boolean addZzim(String id, int lNo) {
		return zs.insert(new Zzim(id, lNo)) > 0 ? true : false;
	}
}
