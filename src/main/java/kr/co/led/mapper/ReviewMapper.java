package kr.co.led.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import kr.co.led.beans.ReviewBean;

public interface ReviewMapper {
	
	//값 입력
	@SelectKey(statement="select rev_seq.nextval from dual", keyProperty = "review_idx", before=true, resultType=int.class)
	@Insert("insert into review(review_idx, user_idx, product_idx, review_content, review_date, review_star) " +
			"values (#{review_idx}, #{user_idx}, #{product_idx}, #{review_content}, sysdate, #{review_star})")  
	void addReviewInfo(ReviewBean writeReviewBean);
	
	
	//상품 리뷰 보여주기
	@Select("select p.product_idx, review_idx, user_name, review_content, review_star, to_char(review_date, 'yyyy-mm-dd') as review_date " 
			+ "from review r "
			+ "join user_table u "
			+ "on r.user_idx=u.user_idx "
			+ "join product p "
			+ "on r.product_idx = p.product_idx "
			+ "where p.product_idx = #{product_idx}")
	List<ReviewBean> getReviewList(int product_idx);
	
	/*//리뷰 선택한거만 보기
	@Select("select review_idx, user_idx, product_idx, order_idx, ut.user_name as writer_name, review_title, review_content " +
			"from review re, user_table ut "
			+ "where review_idx=#{review_idx}")
	ReviewBean getReviewInfo(int review_idx);*/
	
	
	//리뷰 선택한거만 보기
	@Select("select review_idx, review_title, ut.user_name as writer_name, to_char(review_date, 'yyyy-mm-dd') as review_date, review_content, review_star " +
			"from review re, user_table ut " +
			"where review_idx=#{review_idx}")
	ReviewBean getReviewInfo(int review_idx);
	
	//수정
	@Update("update review " +
			"set review_content=#{review_content} " +
			"where review_idx=#{review_idx} and order_idx=#{order_idx}")
	void modifyReviewInfo(ReviewBean modifyReviewBean);
	
	//삭제
	@Delete("delete from review " +
			"where review_idx=#{review_idx}")
	void deleteReviewInfo(int review_idx);

	//총 카운트
	@Select("select count(*) "
			+ "from review "
			+ "where product_idx=#{product_idx}")
	int getReviewCnt(int product_idx);
}

