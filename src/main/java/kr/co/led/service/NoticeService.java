package kr.co.led.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import kr.co.led.beans.NoticeBean;
import kr.co.led.beans.PageBean;
import kr.co.led.beans.UserBean;
import kr.co.led.dao.NoticeDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class NoticeService {

   
   @Autowired
   private NoticeDao noticeDao;
   
   @Resource(name="loginUserBean")
   private UserBean loginUserBean;
   
   
   //이미지 경로 업로드 
   @Value("${path.upload}")
   private String path_upload;
   
   
   //페이징처리
   @Value("${page.listcnt}")
   private int page_listcnt;
   
   @Value("${page.paginationcnt}")
   private int page_paginationcnt;
   
   
   
   
   //파일명 붙이기
   /*
   private String saveUploadFile(MultipartFile upload_file) {
      
      String file_name = System.currentTimeMillis() + "_" +                 
            FilenameUtils.getBaseName(upload_file.getOriginalFilename()) + "." +   
            FilenameUtils.getExtension(upload_file.getOriginalFilename());      
      
      try {
         upload_file.transferTo(new File(path_upload + "/" + file_name));
      }catch(Exception e) {
         e.printStackTrace();
      }
      
      return file_name;
      
   }
   */
   
   //글쓰기
   public void addNoticeInfo(NoticeBean writeNoticeBean) {
      /*
      MultipartFile upload_file=writeNoticeBean.getUpload_file();
      
      if(upload_file.getSize() > 0) {
         String file_name=saveUploadFile(upload_file);
         writeNoticeBean.setNotice_img(file_name);
      }
      writeNoticeBean.setAdmin_idx(loginUserBean.getUser_idx());
      */
      noticeDao.addNoticeInfo(writeNoticeBean);
   }
   
   
   //글목록에 글 불러오기 
      public List<NoticeBean> getNoticeList(String notice_type, int page) {
         
         int start = (page -1)*page_listcnt;
         
         RowBounds rowBounds = new RowBounds(start, page_listcnt);
         
         return noticeDao.getNoticeList(notice_type, rowBounds);
      
      }
      
   
   
   //글 하나보기
   public NoticeBean getNoticeInfo(int notice_idx) {
      
      return noticeDao.getNoticeInfo(notice_idx);
   }
         
      
   
   //게시물 수정하기
   public void modifyNoticeInfo(NoticeBean modifyNoticeBean) {
      
      noticeDao.modifyNoticeInfo(modifyNoticeBean);
   }
   
   
   
   //게시물 삭제
      public void deleteNoticeInfo(int notice_idx) {
         noticeDao.deleteNoticeInfo(notice_idx);
      }
      
      
   //전체 게시물 개수
   public PageBean getNoticeCnt(String notice_type, int currentPage) {
      
      int notice_cnt=noticeDao.getNoticeCnt(notice_type);
      
      //PageBean오버로딩 생성자 담기(NoticeCnt > notice_cnt(지금여기에서 선언함), noticePageCnt > page_listcnt(위에 properties끌어옴), paginationCnt > page_paginationcnt) 
      PageBean pageBean=new PageBean(notice_cnt, currentPage, page_listcnt, page_paginationcnt);
      
      return pageBean;
   }
   
}