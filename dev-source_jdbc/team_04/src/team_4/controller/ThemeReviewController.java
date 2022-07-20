package controller;

import java.util.List;

import service.ThemeReviewService;
import vo.ThemeReviewVO;

public class ThemeReviewController {
	ThemeReviewService themeRvwService = new ThemeReviewService();
	
	public boolean writeReview(ThemeReviewVO review) {
		int result = themeRvwService.insert(review);
		return result > 0 ? true : false; 
	}
	
	public boolean deleteThemeReview(int rNo) {
		int result = themeRvwService.delete(rNo);
		return result > 0 ? true : false; 
	}
	
	public boolean updateThemeReview(int tRevNum, ThemeReviewVO themeReview) {
		int result = themeRvwService.update(tRevNum, themeReview);
		return result > 0 ? true : false; 
	}
	
	public List<ThemeReviewVO> getReviewKeyword(String keyword) {
		return themeRvwService.searchByKeyword(keyword);
	}
	
	public List<ThemeReviewVO> getReviewAllList() {
		return themeRvwService.selectAll();
	}
	
	public List<ThemeReviewVO> getReviewUserList(int userNo) {
		return themeRvwService.searchByUserNumber(userNo);
	}
	
	public List<ThemeReviewVO> getReviewTitle(String title) {
		return themeRvwService.searchByTitle(title);
	}
}
