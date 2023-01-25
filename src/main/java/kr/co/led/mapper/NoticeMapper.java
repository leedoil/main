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
   
   //���ۼ� writeNotice
   //�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�admin_id 1�� ������� �ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
   @Insert ("insert into notice (notice_idx, notice_type, notice_title, "
         + "notice_context, notice_date) "
         + "values (#{notice_idx}, #{notice_type}, #{notice_title}, "
         + "#{notice_context}, sysdate)")
         //���� ������
         //+ "#{notice_context}, #{notice_img, jdbcType=VARCHAR}, 1, sysdate)")
   void addNoticeInfo(NoticeBean writeNoticeBean);
   
   
   
   //notice ����Ʈ ���� 
   //�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ� 500������ ���� ��ü ���� �ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
   @Select("select a1.notice_idx, a1.notice_title, a2.user_idx, to_char(a1.notice_date, 'yyyy-mm-dd') as notice_date "
         + "from notice a1, user_table a2 "
         + "where a2.user_idx = 1 and a1.notice_type=#{notice_type} "
         + "order by a1.notice_idx desc")
   List<NoticeBean> getNoticeList(String notice_type, RowBounds rowBounds);
   
   //���� ������
   //@Select("select a1.notice_idx, a1.notice_title, a1.admin_id, to_char(a1.notice_date, 'yyyy-mm-dd') as notice_date"
   //      + " from notice a1 "
   //      + "where a1.admin_id='1' and a1.notice_type=#{notice_type}"
   //      + "order by a1.notice_idx desc")
   //List<NoticeBean> getNoticeList(String notice_type, RowBounds rowBounds);
   
   
   
   //�� �ϳ� �б�
   //�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڿ�����θ� �ۼ��ڿ� ���� �Խù������� ����, ���� ������ �ֱ� ���ؼ� where�� admin�� �;��ϴµ� ���� �װ� �����ϱ� idx�� ������ �ɾ�а��ӡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
   @Select("select a1.notice_type, a1.notice_title, to_char(a1.notice_date, 'yyyy-mm-dd') as notice_date, a1.notice_context "
         + "from notice a1 "
         + "where a1.notice_idx=#{notice_idx}")
   NoticeBean getNoticeInfo(int notice_idx);
   
   //���� ���� ��
   //@Select("select a1.notice_type, a1.notice_title, a1.admin_id, to_char(a1.notice_date, 'yyyy-mm-dd') as notice_date, a1.notice_img, a1.notice_context "
   //      + "from notice a1 "
   //      + "where a1.notice_idx=#{notice_idx}")
   //NoticeBean getNoticeInfo(int notice_idx);
   
   
   
   //�Խù� ����
   @Update("update notice "
         + "set notice_title=#{notice_title}, "
         + "notice_context=#{notice_context} "
         + "where notice_idx=#{notice_idx}")
   void modifyNoticeInfo(NoticeBean modifyNoticeBean);
   
   
   
   //�Խù� ����
   @Delete("delete from notice "
         + "where notice_idx=#{notice_idx}")
//   + "where notice_idx=#{notice_idx} and notice_type=#{notice_type}")
   void deleteNoticeInfo(int notice_idx);
   
   
   //��ü �Խù� ����
   @Select("select count(*) from notice where notice_type=#{notice_type}")
   int getNoticeCnt(String notice_type);
   
}