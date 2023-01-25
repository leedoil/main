package kr.co.led.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import kr.co.led.beans.ReviewBean;
import kr.co.led.beans.UserBean;
import kr.co.led.dao.ReviewDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class ReviewService {

	@Autowired
	private ReviewDao reviewDao;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	@Value("${path.upload}")
	private String path_upload;

	@Value("${page.listcnt}")
	private int page_listcnt;

	@Value("${page.paginationcnt}")
	private int page_paginationcnt;

	public void addReviewInfo(ReviewBean writeReviewBean) {
		writeReviewBean.setUser_idx(loginUserBean.getUser_idx());
		// writeReviewBean.setOrder_idx();
		reviewDao.addReviewInfo(writeReviewBean);
	}

	/*
	 * //페이지 당 번호 public List<ReviewBean> getReviewList(int page){ int start = (page
	 * -1) * page_listcnt; RowBounds rowBounds = new RowBounds(start, page_listcnt);
	 * 
	 * return reviewDao.getReviewList(rowBounds); }
	 */

	// 상품 리뷰 가져오기
	public List<ReviewBean> getReviewList(int product_idx) {

		return reviewDao.getReviewList(product_idx);
	}

	// 선택한 리뷰 가져오기
	public ReviewBean getReviewInfo(int review_idx) {
		return reviewDao.getReviewInfo(review_idx);
	}

	// 수정
	public void modifyReviewInfo(ReviewBean modifyReviewBean) {
		reviewDao.modifyReviewInfo(modifyReviewBean);
	}

	// 삭제
	public void deleteReviewInfo(int review_idx) {
		reviewDao.deleteReviewInfo(review_idx);
	}

	// 카운트
	public int getReviewCnt(int product_idx) {
		return reviewDao.getReviewCnt(product_idx);
	}

}
