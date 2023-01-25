package kr.co.led.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import kr.co.led.beans.NoticeBean;

public interface NoticeMapper {

   
@SelectKey(statement="select ntc_seq.nextval from dual", keyProperty = "notice_idx", before=true, resultType=int.class)
   
   //글작성 writeNotice
   //★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★admin_id 1로 적어놓음 ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
   @Insert ("insert into notice (notice_idx, notice_type, notice_title, "
         + "notice_context, notice_date) "
         + "values (#{notice_idx}, #{notice_type}, #{notice_title}, "
         + "#{notice_context}, sysdate)")
         //유저 연동전
         //+ "#{notice_context}, #{notice_img, jdbcType=VARCHAR}, 1, sysdate)")
   void addNoticeInfo(NoticeBean writeNoticeBean);
   
   
   
   //notice 리스트 보기 
   //★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★ 500에러가 나서 전체 수정 ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
   @Select("select a1.notice_idx, a1.notice_title, a2.user_idx, to_char(a1.notice_date, 'yyyy-mm-dd') as notice_date "
         + "from notice a1, user_table a2 "
         + "where a2.user_idx = 1 and a1.notice_type=#{notice_type} "
         + "order by a1.notice_idx desc")
   List<NoticeBean> getNoticeList(String notice_type, RowBounds rowBounds);
   
   //유저 연동전
   //@Select("select a1.notice_idx, a1.notice_title, a1.admin_id, to_char(a1.notice_date, 'yyyy-mm-dd') as notice_date"
   //      + " from notice a1 "
   //      + "where a1.admin_id='1' and a1.notice_type=#{notice_type}"
   //      + "order by a1.notice_idx desc")
   //List<NoticeBean> getNoticeList(String notice_type, RowBounds rowBounds);
   
   
   
   //글 하나 읽기
   //★★★★★★★★★★★★★★★★★★원래대로면 작성자에 따라서 게시물에대한 수정, 삭제 권한을 주기 위해서 where에 admin이 와야하는데 지금 그게 없으니까 idx로 조건을 걸어둔거임★★★★★★★★★★★★★★★★★★
   @Select("select a1.notice_type, a1.notice_title, to_char(a1.notice_date, 'yyyy-mm-dd') as notice_date, a1.notice_context "
         + "from notice a1 "
         + "where a1.notice_idx=#{notice_idx}")
   NoticeBean getNoticeInfo(int notice_idx);
   
   //유저 연동 전
   //@Select("select a1.notice_type, a1.notice_title, a1.admin_id, to_char(a1.notice_date, 'yyyy-mm-dd') as notice_date, a1.notice_img, a1.notice_context "
   //      + "from notice a1 "
   //      + "where a1.notice_idx=#{notice_idx}")
   //NoticeBean getNoticeInfo(int notice_idx);
   
   
   
   //게시물 수정
   @Update("update notice "
         + "set notice_title=#{notice_title}, "
         + "notice_context=#{notice_context} "
         + "where notice_idx=#{notice_idx}")
   void modifyNoticeInfo(NoticeBean modifyNoticeBean);
   
   
   
   //게시물 삭제
   @Delete("delete from notice "
         + "where notice_idx=#{notice_idx}")
//   + "where notice_idx=#{notice_idx} and notice_type=#{notice_type}")
   void deleteNoticeInfo(int notice_idx);
   
   
   //전체 게시물 개수
   @Select("select count(*) from notice where notice_type=#{notice_type}")
   int getNoticeCnt(String notice_type);
   
}