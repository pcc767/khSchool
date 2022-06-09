package seoul.legacy.controller;

import java.util.List;

import seoul.legacy.model.service.ReviewService;
import seoul.legacy.model.vo.Review;

public class ReviewController {

	// 1. ID 검색
	// 2. 문화재 번호 검색
	// 3. 리뷰 작성

	private ReviewService rs = new ReviewService();

	public List<Review> privReviewList(String id) {
		return rs.selectByUserId(id);
	}

	public List<Review> legacyReviewList(int lNo) {
		return rs.selectByLegacyNo(lNo);
	}

	public boolean addReview(Review review) {
		return rs.insert(review) > 0 ? true : false;
	}
}
