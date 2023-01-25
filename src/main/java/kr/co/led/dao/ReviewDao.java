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
	
	//��ǰ ���� ��������
	public List<ReviewBean> getReviewList(int product_idx) {
		return reviewMapper.getReviewList(product_idx);
	}
	
	//���� ������ �� ��������
	public ReviewBean getReviewInfo(int review_idx) {
		return reviewMapper.getReviewInfo(review_idx);
	}
	
	//����
	public void modifyReviewInfo(ReviewBean modifyReviewBean) {
		reviewMapper.modifyReviewInfo(modifyReviewBean);
	}
	
	//����
	public void deleteReviewInfo(int review_idx) {
		reviewMapper.deleteReviewInfo(review_idx);
	}
	
	//��ī��Ʈ
	public int getReviewCnt(int product_idx) {
		return reviewMapper.getReviewCnt(product_idx);
	}
	
}
