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
	 * //������ �� ��ȣ public List<ReviewBean> getReviewList(int page){ int start = (page
	 * -1) * page_listcnt; RowBounds rowBounds = new RowBounds(start, page_listcnt);
	 * 
	 * return reviewDao.getReviewList(rowBounds); }
	 */

	// ��ǰ ���� ��������
	public List<ReviewBean> getReviewList(int product_idx) {

		return reviewDao.getReviewList(product_idx);
	}

	// ������ ���� ��������
	public ReviewBean getReviewInfo(int review_idx) {
		return reviewDao.getReviewInfo(review_idx);
	}

	// ����
	public void modifyReviewInfo(ReviewBean modifyReviewBean) {
		reviewDao.modifyReviewInfo(modifyReviewBean);
	}

	// ����
	public void deleteReviewInfo(int review_idx) {
		reviewDao.deleteReviewInfo(review_idx);
	}

	// ī��Ʈ
	public int getReviewCnt(int product_idx) {
		return reviewDao.getReviewCnt(product_idx);
	}

}
