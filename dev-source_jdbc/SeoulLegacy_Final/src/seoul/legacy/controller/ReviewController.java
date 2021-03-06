package seoul.legacy.controller;

import java.util.List;

import seoul.legacy.model.service.ReviewService;
import seoul.legacy.model.vo.Review;

public class ReviewController {
	
	private ReviewService reviewService = new ReviewService();
	
	public List<Review> selectAll(){
		return reviewService.selectAll();
	}
	
	public List<Review> selectByLegacyNo(int legacy_no) {
		return reviewService.selectByLegacyNo(legacy_no);
	}

	public List<Review> selectByUserId(String userId) {
		return reviewService.selectByUserId(userId);
	}
	
	public int insert(Review riview) {
		return reviewService.insert(riview);
	}
	
	public int delete(Review riview) {
		return reviewService.delete(riview);
	}
	
	
	

}
