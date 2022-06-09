package seoul.legacy.controller;

import java.util.List;

import seoul.legacy.model.service.ZzimService;
import seoul.legacy.model.vo.Zzim;

public class ZzimController {
	
	private ZzimService zzimService =  new ZzimService();
	
	public List<Zzim> selectById(String userId){
		return zzimService.selectById(userId);
	}
	
	public boolean insert(String userId, int legacyNo) {
		 int result = zzimService.insert(new Zzim(userId, legacyNo));
		 return result > 0 ? true : false;
	}
	
	public int delete(Zzim zzim) {
		return zzimService.delete(zzim);
	}

}
