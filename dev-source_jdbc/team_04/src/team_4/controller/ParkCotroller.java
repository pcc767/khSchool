package controller;

import java.util.List;

import api.ApiManager;
import service.ParkService;
import vo.ParkVO;

public class ParkCotroller {
	private ApiManager api = new ApiManager();
	private ParkService ps = new ParkService();
	
	public void initPark() {
		List<ParkVO> list = api.parkApi();
	
		for(ParkVO park : list) {
			ps.insert(park);
		}
	}
	
	public List<ParkVO> searchByAddr(String addr) {
		
		return ps.searchByPkAdd(addr);
	}
	
	public List<ParkVO> searchByName(String name) {
		
		return ps.searchByPkName(name);
	}
}
	
