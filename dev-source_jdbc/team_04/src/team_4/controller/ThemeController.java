package controller;

import java.util.List;

import api.ApiManager;
import service.ThemeService;
import vo.ThemeVO;

public class ThemeController {
	private ApiManager api = new ApiManager();
	private ThemeService ts = new ThemeService();
	
	public void initTheme() {
		List<ThemeVO> list = api.themeApi();
	
		for(ThemeVO theme : list) {
			ts.insert(theme);
		}
	}
	
	public List<ThemeVO> searchByGu(String gu) {
		
		return ts.searchByGugun(gu);
	}
	
	public List<ThemeVO> searchByCategory(String cate) {
		
		return ts.searchByCategory(cate);
	}
	
	public List<ThemeVO> searchByKeyW(String keyW) {
		
		return ts.searchByKeyword(keyW);
	}
	

	public List<ThemeVO> getAllThemeList() {
		
		return ts.selectAll();
	}

}
