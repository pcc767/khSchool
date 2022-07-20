package controller;

import java.util.List;

import service.WalkReviewService;
import vo.WalkReviewVO;

public class WalkReviewController {
	WalkReviewService walkRvwService = new WalkReviewService();
	
	public boolean writeReview(WalkReviewVO walkReview) {
		int result = walkRvwService.insert(walkReview);
		return result > 0 ? true : false; 
	}
	
	public boolean updateReview(int wRevNum, WalkReviewVO walkReview) {
		int result = walkRvwService.update(wRevNum, walkReview);
		return result > 0 ? true : false; 
	}
	
	public boolean deleteReview(int wRevNum) {
		int result = walkRvwService.delete(wRevNum);
		return result > 0 ? true : false; 
	}
		
	public List<WalkReviewVO> getReviewAll(){
		return walkRvwService.selectAll();
	}
	
	public List<WalkReviewVO> getReviewByUnum(int uNum){ 
		return walkRvwService.searchByUserNumber(uNum);
	}
	
	public List<WalkReviewVO> getReviewByTitle(String title) { 
		return walkRvwService.searchByTitle(title);
	}

	public List<WalkReviewVO> getReviewByKeyword(String keyword) { 
		return walkRvwService.searchByKeyword(keyword);
	}
}
