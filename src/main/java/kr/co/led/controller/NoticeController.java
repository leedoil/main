package kr.co.led.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.led.beans.NoticeBean;
import kr.co.led.beans.PageBean;
import kr.co.led.beans.UserBean;
import kr.co.led.service.NoticeService;

@Controller
public class NoticeController {

   @Autowired
   private NoticeService noticeService;
   
   @Resource(name="loginUserBean")
   private UserBean loginUserBean; 
   
   @GetMapping("/notice_list")
   public String list(@RequestParam("notice_type") String notice_type, 
                  @RequestParam(value="page", defaultValue="1") int page,
                  Model model) {

      
      List<NoticeBean> noticeList=noticeService.getNoticeList(notice_type, page);
      
      int admin_idx = loginUserBean.getUser_idx();
      //System.out.println(admin_idx);
      PageBean pageBean=noticeService.getNoticeCnt(notice_type, page);
      
      model.addAttribute("admin_idx", admin_idx);
      model.addAttribute("notice_type", notice_type);
      model.addAttribute("noticeList", noticeList);
      model.addAttribute("pageBean", pageBean);
      model.addAttribute("page", page);
      
      
      return "notice/list";
   }
   
   //글 하나보기
   @GetMapping("/notice_read")
   public String read(@RequestParam("notice_idx") int notice_idx, 
                  @ModelAttribute("getNoticeInfo") NoticeBean getNoticeInfo, 
                  @RequestParam(value="page", defaultValue="1") int page, Model model) {
      
      NoticeBean readNoticeBean = noticeService.getNoticeInfo(notice_idx);
      
      int admin_idx = loginUserBean.getUser_idx();
      System.out.println(admin_idx);
      model.addAttribute("admin_idx", admin_idx);
      model.addAttribute("notice_idx", notice_idx);
      model.addAttribute("readNoticeBean", readNoticeBean);
      model.addAttribute("loginUserBean", loginUserBean);
      model.addAttribute("page", page);   
      
      return "notice/read";
   }
   
   
   @GetMapping("/notice_write")
   public String write(@ModelAttribute("writeNoticeBean") NoticeBean writeNoticeBean,
                  @RequestParam("notice_type") String notice_type) {
                        
      writeNoticeBean.setNotice_type(notice_type);
                        
      return "notice/write";
   }
   
   
   @PostMapping("/notice_write_pro")
   public String write_pro(@Valid @ModelAttribute("writeNoticeBean") NoticeBean writeNoticeBean, BindingResult result) {
      
      if(result.hasErrors()) {
         return "notice/write";
      }
      noticeService.addNoticeInfo(writeNoticeBean);
      
      return "notice/write_success";
   }
   
   
   @GetMapping("/not_writer")
   public String not_writer() {
      return "notice/not_writer";
   }
   
   
   @GetMapping("/notice_modify")
   public String modify(@RequestParam("notice_idx") int notice_idx,
                   @RequestParam("page") int page, 
                    @ModelAttribute("modifyNoticeBean") NoticeBean modifyNoticeBean, Model model) {
   
      model.addAttribute("notice_idx", notice_idx);
      model.addAttribute("page", page);
      
      //게시물 정보 불러오기 
      NoticeBean tempNoticeBean=noticeService.getNoticeInfo(notice_idx);
      
      //modifyNoticeBean.setAdmin_id(tempNoticeBean.getAdmin_id());
      modifyNoticeBean.setNotice_date(tempNoticeBean.getNotice_date());
      modifyNoticeBean.setNotice_title(tempNoticeBean.getNotice_title());
      modifyNoticeBean.setNotice_context(tempNoticeBean.getNotice_context());
      modifyNoticeBean.setNotice_img(tempNoticeBean.getNotice_img());
      
      //modifyNoticeBean.setNotice_type(notice_type);
      modifyNoticeBean.setNotice_idx(notice_idx);
      
      return "notice/modify";
   }
   
   
   
   @PostMapping("/notice_modify_pro")
   public String modify_pro(@Valid @ModelAttribute("modifyNoticeBean")NoticeBean modifyNoticeBean, BindingResult result, 
                         @RequestParam("page") int page, Model model) {
      
      model.addAttribute("page", page);
      
      if(result.hasErrors()) {
         return "notice/modify";
      }
      
      noticeService.modifyNoticeInfo(modifyNoticeBean);
      
      return "notice/modify_success";
   }
   
   
   
   
   @GetMapping("/notice_delete")
   public String delete(@RequestParam("notice_idx") int notice_idx,
                  Model model) {
//      @RequestParam("notice_type") String notice_type, Model model) {
      
      noticeService.deleteNoticeInfo(notice_idx);

      model.addAttribute("notice_idx", notice_idx);
      //model.addAttribute("notice_type", notice_type);
      
      
      
      return "notice/delete";
   }
      
}