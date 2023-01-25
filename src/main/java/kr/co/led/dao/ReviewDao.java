package kr.co.led.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.led.beans.ReviewBean;
import kr.co.led.mapper.ReviewMapper;

@Repository
public class ReviewDao {

	@Autowired
	private ReviewMapper reviewMapper;

	public void addReviewInfo(ReviewBean writeReviewBean ) {
		reviewMapper.addReviewInfo(writeReviewBean);
	}
	
	//상품 리뷰 가져오기
	public List<ReviewBean> getReviewList(int product_idx) {
		return reviewMapper.getReviewList(product_idx);
	}
	
	//리뷰 선택한 거 가져오기
	public ReviewBean getReviewInfo(int review_idx) {
		return reviewMapper.getReviewInfo(review_idx);
	}
	
	//수정
	public void modifyReviewInfo(ReviewBean modifyReviewBean) {
		reviewMapper.modifyReviewInfo(modifyReviewBean);
	}
	
	//삭제
	public void deleteReviewInfo(int review_idx) {
		reviewMapper.deleteReviewInfo(review_idx);
	}
	
	//총카운트
	public int getReviewCnt(int product_idx) {
		return reviewMapper.getReviewCnt(product_idx);
	}
	
}
