package controller;

import java.util.List;

import api.ApiManager;
import service.WalkService;
import vo.WalkVO;

public class WalkCotroller {
	private ApiManager api = new ApiManager();
	private WalkService ws = new WalkService();
	
	public void initWalk() {
		List<WalkVO> list = api.walkApi();
	
		for(WalkVO walk : list) {
			ws.insert(walk);
		}
	}
	
	public List<WalkVO> searchByKeyW(String keyW) {
		
		return ws.searchByKeyword(keyW);
	}
	public List<WalkVO> searchByCtegory(String cate) {
		
		return ws.searchByCtegory(cate);
	}
	
	public List<WalkVO> getAllWalkList() {
		
		return ws.selectAll();
	}

}
	
