package kr.co.led.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import kr.co.led.beans.QuestionBean;

public interface QuestionMapper {

	
	@SelectKey(statement="select question_seq.nextval from dual", keyProperty = "question_idx", before=true, resultType=int.class)
	//jdbcType=VARCHAR : 이미지를 입력하지 않았을때 null값이 아닌 error가 발생하므로 varchar로 항상 설정한다.
	@Insert("insert into question(question_idx, user_idx, question_type, question_title, question_content, question_date) " +
			"values (#{question_idx}, #{user_idx}, #{question_type, jdbcType=VARCHAR}, #{question_title}, #{question_content}, sysdate)")
	void addQuestionInfo(QuestionBean writeQuestionBean);
	
	
	//게시판 모두 가져오기
	@Select("select question_idx, question_title, ut.user_name as user_name, to_char(question_date, 'yyyy-mm-dd') as question_date " +
            "from question qt, user_table ut "
            + "where qt.user_idx=ut.user_idx and qt.user_idx = #{user_idx}")
	List<QuestionBean> getQuestionList(int user_idx, RowBounds rowBounds);
	
	
	//게시판 하나 가져오기
	@Select("select to_char(qt.question_date, 'yyyy-mm-dd') as question_date, "
			+ "qt.question_title, qt.question_content "
			+ "from question qt "
			+ "where question_idx = #{question_idx}")
	QuestionBean getQuestionInfo(int question_idx);
	
	//수정
	@Update("update question " +
			"set question_title=#{question_title}, question_content=#{question_content} " +
			"where question_idx=#{question_idx}")
	void modifyQuestionInfo(QuestionBean modifyQuestionBean);
	
	//삭제
	@Delete("delete from question where question_idx=${question_idx}")
	void deleteQuestionInfo(int question_idx);		
	
	//카운트 나누기? 
	@Select("select count(*) from question")
	int getQuestionCnt(int question_idx);
	
}
