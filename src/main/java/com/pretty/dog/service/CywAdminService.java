package com.pretty.dog.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pretty.dog.dao.CywAdminDAO;
import com.pretty.dog.dto.DogDTO;

@Service
public class CywAdminService {

   Logger logger = LoggerFactory.getLogger(this.getClass());
   @Autowired CywAdminDAO dao;
   
   public ModelAndView categoryPage(String loginId) {
      ModelAndView mav = new ModelAndView();
      
      int categoryPage = dao.SingoHangmokPage(loginId);
      
	  	if (categoryPage == 1) {
			mav.setViewName("cywCateGory");
		}else {
			mav.addObject("loginSuccessAlert", "관리자만 사용할수 있는 페이지입니다.");
			mav.setViewName("Main");
		}
      
      return mav;
   }

   public HashMap<String, Object> categoryListCall(int currPage, int pagePerCnt) {
      HashMap<String, Object> map = new HashMap<String, Object>();
      
      //어디서부터 보여줘야 하는가?
      int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
      logger.info("offset:{}",offset);
      
      int totalCount = dao.categoryListCount(); 
      
      int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
      
      logger.info("총 갯수 : {}",totalCount);
      logger.info("만들수 있는 총 페이지 :{}",range);
      
      map.put("pages", range);
      map.put("list", dao.categoryListCall(pagePerCnt,offset));
      
      return map;
   }

   public ModelAndView cateGoryAdd(String categoryName, String categoryClass, RedirectAttributes rAttr) {
      
      ModelAndView mav = new ModelAndView();
      
      int row = dao.cateGoryAdd(categoryName,categoryClass);
      
      if (row >0) {
         rAttr.addFlashAttribute("msg", "등록이 완료되었습니다.");
         mav.setViewName("redirect:/categoryPage");
      }else {
         rAttr.addFlashAttribute("msg", "등록이 실패했습니다.");
         mav.setViewName("redirect:/categoryPage");
      }
      
      return mav;
   }

   public ModelAndView categoryDel(String category_num, RedirectAttributes rAttr) {
      ModelAndView mav = new ModelAndView();
      
      int row = dao.categoryDel(category_num);
      if (row>0) {
         rAttr.addFlashAttribute("msg1", "삭제에 성공하였습니다.");
         mav.setViewName("redirect:/categoryPage");
      }else {
         rAttr.addFlashAttribute("msg1", "삭제에 실패하였습니다.");
         mav.setViewName("redirect:/categoryPage");
      }
      
      return mav;
   }
   
   
//   마이페이지 부분 -------------------------------------------------------------------------------

   public ModelAndView MyPageAlarm(String loginId) {
      ModelAndView mav = new ModelAndView();

      ArrayList<DogDTO> memInfo = dao.AlarmMem(loginId);
      
      mav.addObject("loginId", loginId);
      mav.addObject("memInfo", memInfo);
      mav.setViewName("cywMyPageAlram");
      
      return mav;
   }

   public HashMap<String, Object> AlrimPageList(int currPage, int pagePerCnt, String loginId) {
      HashMap<String, Object> map = new HashMap<String, Object>();
      
      //어디서부터 보여줘야 하는가?
      int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
      logger.info("offset:{}",offset);
      
      int totalCount = dao.AlrimPageListCount(loginId); 
      
      int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
      
      logger.info("총 갯수 : {}",totalCount);
      logger.info("만들수 있는 총 페이지 :{}",range);
      
      map.put("pages", range);
      map.put("list", dao.AlrimPageList(pagePerCnt,offset,loginId));
      
      return map;
   }

   public ModelAndView alarmDel(String alarm_num, RedirectAttributes rAttr) {
      ModelAndView mav =new ModelAndView();
      
      int row = dao.alarmDel(alarm_num);
      
      if (row > 0) {
         rAttr.addFlashAttribute("msg", "삭제가 완료되었습니다.");
         mav.setViewName("redirect:/MyPageAlarm");
      }else {
         rAttr.addFlashAttribute("msg", "삭제가 불가능합니다.");
         mav.setViewName("redirect:/MyPageAlarm");
      }
      
      return mav;
   }

   public ModelAndView MyPageBoard(String loginId) {
      ModelAndView mav = new ModelAndView();
      
      if (loginId != null) {
    	  ArrayList<DogDTO> memInfo = dao.MyBoard(loginId);
    	  
    	  mav.addObject("loginId", loginId);
    	  mav.addObject("memInfo", memInfo);
    	  mav.setViewName("cywMyPageBoard");
	}else {
//		mav.setViewName("redirect:/loginPage");
		mav.setViewName("cywMyPageBoard");
	}
      
      return mav;
   }

   public HashMap<String, Object> MyBoardPageList(int currPage, int pagePerCnt, String loginId) {
      HashMap<String, Object> map = new HashMap<String, Object>();
      
      //어디서부터 보여줘야 하는가?
      int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
      logger.info("offset:{}",offset);
      
      int totalCount = dao.MyBoardPageListCount(loginId); 
      
      int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
      
      logger.info("총 갯수 : {}",totalCount);
      logger.info("만들수 있는 총 페이지 :{}",range);
      
      map.put("pages", range);
      map.put("list", dao.MyBoardPageList(pagePerCnt,offset,loginId));
      
      return map;
   }

   public ModelAndView boardDel(String community_boardnum, String loginId, RedirectAttributes rAttr) {
      ModelAndView mav =new ModelAndView();
      
      int row = dao.boardDel(community_boardnum,loginId);
      
      if (row > 0) {
         rAttr.addFlashAttribute("msg", "삭제가 완료되었습니다.");
         mav.setViewName("redirect:/MyPageBoard");
      }else {
         rAttr.addFlashAttribute("msg", "삭제가 불가능합니다.");
         mav.setViewName("redirect:/MyPageBoard");
      }
      
      return mav;
   }

   public ModelAndView MyPageComment(String loginId) {
      ModelAndView mav = new ModelAndView();
      
      ArrayList<DogDTO> memInfo = dao.MyComment(loginId);
      
      mav.addObject("loginId", loginId);
      mav.addObject("memInfo", memInfo);
      mav.setViewName("cywMyPageComment");
      
      return mav;
   }

   public HashMap<String, Object> CommentPageList(int currPage, int pagePerCnt, String loginId) {
      HashMap<String, Object> map = new HashMap<String, Object>();
      
      //어디서부터 보여줘야 하는가?
      int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
      logger.info("offset:{}",offset);
      
      int totalCount = dao.CommentPageListCount(loginId); 
      
      int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
      
      logger.info("총 갯수 : {}",totalCount);
      logger.info("만들수 있는 총 페이지 :{}",range);
      
      map.put("pages", range);
      map.put("list", dao.CommentPageList(pagePerCnt,offset,loginId));
      
      return map;
   }

   public ModelAndView commentDel(String bcomment_num, String loginId, RedirectAttributes rAttr) {
      ModelAndView mav =new ModelAndView();
      
      int row = dao.commentDel(bcomment_num,loginId);
      
      if (row > 0) {
         rAttr.addFlashAttribute("msg", "삭제가 완료되었습니다.");
         mav.setViewName("redirect:/MyPageBoard");
      }else {
         rAttr.addFlashAttribute("msg", "삭제가 불가능합니다.");
         mav.setViewName("redirect:/MyPageBoard");
      }
      
      return mav;
   }

   public ModelAndView MyPageLikeShop(String loginId) {
      
      ModelAndView mav = new ModelAndView();
      
      ArrayList<DogDTO> memInfo = dao.MyLikeShop(loginId);
      
      mav.addObject("loginId", loginId);
      mav.addObject("memInfo", memInfo);
      mav.setViewName("cywMyPageLikeShop");
      
      return mav;
   }

   public HashMap<String, Object> MyLikeShopList(int currPage, int pagePerCnt, String loginId) {
      HashMap<String, Object> map = new HashMap<String, Object>();
      
      //어디서부터 보여줘야 하는가?
      int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
      logger.info("offset:{}",offset);
      
      int totalCount = dao.MyLikeShopListCount(loginId); 
      
      int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
      
      logger.info("총 갯수 : {}",totalCount);
      logger.info("만들수 있는 총 페이지 :{}",range);
      
      map.put("pages", range);
      map.put("list", dao.MyLikeShopList(pagePerCnt,offset,loginId));
      
      
      return map;
   }

   public ModelAndView LikeShopDel(String interestshop_num, String loginId, RedirectAttributes rAttr) {
      ModelAndView mav =new ModelAndView();
      
      int success = dao.shopLikeCount(interestshop_num,loginId);
      int row = dao.LikeShopDel(interestshop_num,loginId);
      
      if (row > 0) {
         rAttr.addFlashAttribute("msg", "삭제가 완료되었습니다.");
         mav.setViewName("redirect:/MyPageBoard");
      }else {
         rAttr.addFlashAttribute("msg", "삭제가 불가능합니다.");
         mav.setViewName("redirect:/MyPageBoard");
      }
      
      return mav;
   }

   public ModelAndView MyPageReserPage(String loginId) {
      ModelAndView mav = new ModelAndView();
      
      ArrayList<DogDTO> memInfo = dao.MyPageReserPage(loginId);
      
      mav.addObject("loginId", loginId);
      mav.addObject("memInfo", memInfo);
      mav.setViewName("cywMyPageReser");
      
      return mav;
   }

   public HashMap<String, Object> MyReserPageList(int currPage, int pagePerCnt, String loginId) {
      HashMap<String, Object> map = new HashMap<String, Object>();
      
      //어디서부터 보여줘야 하는가?
      int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
      logger.info("offset:{}",offset);
      
      int totalCount = dao.MyReserPageListCount(loginId); 
      
      int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
      
      logger.info("총 갯수 : {}",totalCount);
      logger.info("만들수 있는 총 페이지 :{}",range);
      
      map.put("pages", range);
      map.put("list", dao.MyReserPageList(pagePerCnt,offset,loginId));
      
      
      return map;
   }

   public ModelAndView reserDel(String reser_num, String loginId, RedirectAttributes rAttr, String busin_num, int businChange, int normalChange, String reserDay, String canReserTime) {
      ModelAndView mav =new ModelAndView();
   
      int row = dao.reserDel(reser_num,loginId);
      logger.info("마이페이지예약취소사업자번호:{}",busin_num);
      if (row > 0) {
         // 예약취소 후의 데이터 불러오기
         HashMap<String, Object> list = dao.reserData(reser_num,loginId);
         logger.info("예약취소 후의 데이터 불러오기?:{}",list);
         // 예약취소 후 예약히스토리 등록
         int success = dao.reserLogInsert(list);
         logger.info("예약취소 후 예약히스토리 등록?:{}",success);
         // 알람등록(일반회원)
         int Alarm = dao.reserCancleInsert(list);
         logger.info("알람등록(일반회원)?:{}",Alarm);
         // 알람등록(업주회원)
         int OwnerAlarm = dao.OwnerCancleInsert(list);
         logger.info("알람등록(업주회원)?:{}",OwnerAlarm);
         // 회원포인트 추가
         int reserDelMemPointAdd = dao.reserDelMemPointAdd(loginId,normalChange);
         logger.info("회원포인트 추가?:{}",reserDelMemPointAdd);
         // 회원포인트 추가 포인트테이블등록
         int reserDelMemPointTable = dao.reserDelMemPointTable(loginId,normalChange);
         logger.info("회원포인트 추가 포인트테이블등록?:{}",reserDelMemPointTable);
         // 업주회원 노포인트 차감
         int reserDelOwnerPointDel = dao.reserDelOwnerPointDel(normalChange,busin_num);
         logger.info("업주회원 노포인트 차감?:{}",reserDelOwnerPointDel);
         // 업주회원포인트 차감 포인트테이블 등록
         int reserDelOwnerPointTable = dao.reserDelOwnerPointTable(normalChange,busin_num);
         logger.info("업주회원포인트 차감 포인트테이블 등록?:{}",reserDelOwnerPointTable);
         // 업주 회원 노포인트에서 포인트로 이동
         int reserDelOwnerPointChange = dao.reserDelOwnerPointChange(businChange,busin_num);
         logger.info("업주 회원 노포인트에서 포인트로 이동?:{}",reserDelOwnerPointChange);
         // 업주 회원 포인트 더하기
         int reserDelOwnerPointAdd = dao.reserDelOwnerPointAdd(businChange,busin_num);
         logger.info("업주 회원 포인트 더하기?:{}",reserDelOwnerPointAdd);
         // 예약가능 상태로 변경
         int reserStateChange = dao.reserStateChange(busin_num,reserDay,canReserTime);
         logger.info("예약가능 상태로 변경?:{}",reserStateChange);
         
         rAttr.addFlashAttribute("msg", "예약취소가 완료되었습니다.");
         mav.setViewName("redirect:/MyPageReserPage");
      }else {
         rAttr.addFlashAttribute("msg", "예약취소가 불가능합니다.");
         mav.setViewName("redirect:/MyPageReserPage");
      }
      return mav;
   }

   public ModelAndView OwnerReserPage(String loginId) {
      ModelAndView mav = new ModelAndView();
      
      ArrayList<DogDTO> memInfo = dao.OwnerReserPage(loginId);
      
      mav.addObject("loginId", loginId);
      mav.addObject("memInfo", memInfo);
      mav.setViewName("cywMyPageOwnerReser");
      
      return mav;
   }

   public HashMap<String, Object> OwnerReserPageList(int currPage, int pagePerCnt, String loginId) {
      HashMap<String, Object> map = new HashMap<String, Object>();
      
      //어디서부터 보여줘야 하는가?
      int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
      logger.info("offset:{}",offset);
      
      int totalCount = dao.OwnerReserPageListCount(loginId); 
      
      int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
      
      logger.info("총 갯수 : {}",totalCount);
      logger.info("만들수 있는 총 페이지 :{}",range);
      
      map.put("pages", range);
      map.put("list", dao.OwnerReserPageList(pagePerCnt,offset,loginId));
      
      
      return map;
   }

   public ModelAndView NoShowChange(String reser_num, String loginId, RedirectAttributes rAttr, String busin_num,String reser_money) {
      ModelAndView mav =new ModelAndView();
      
      int row = dao.NoShowChange(reser_num,loginId);
      
      if (row > 0) {
         HashMap<String, Object> list = dao.reserData(reser_num,loginId);
         logger.info("노쇼처리하고 정보해쉬맵?:{}",list);
         // 노쇼처리 후 예약히스토리 등록
         int success = dao.reserLogNoshow(list);
         logger.info("노쇼처리하고 예약히스토리 등록?:{}",success);
         // 노쇼처리 후 업주 노포인트에서 차감 
         int NoShopNoPoint = dao.NoShopNoPoint(busin_num,reser_num,reser_money);
         logger.info("노쇼처리 후 업주 노포인트에서 차감 ?:{}",NoShopNoPoint);
         // 노쇼처리 후 업주 포인트에서 가감
         int NoShowPointAdd = dao.NoShowPointAdd(busin_num,reser_money);
         logger.info("노쇼처리 후 업주 포인트에서 가감?:{}",NoShowPointAdd);
         
         rAttr.addFlashAttribute("msg", "노쇼처리가 완료되었습니다.");
         mav.setViewName("redirect:/OwnerReserPage");
      }else {
         rAttr.addFlashAttribute("msg", "노쇼처리가 불가능합니다.");
         mav.setViewName("redirect:/OwnerReserPage");
      }
      return mav;
   }

   public ModelAndView SuccessChange(String reser_num, String loginId, RedirectAttributes rAttr, String busin_num, String reser_money) {
      ModelAndView mav =new ModelAndView();
      
      int row = dao.SuccessChange(reser_num,loginId);
      
      if (row > 0) {
         HashMap<String, Object> list = dao.reserData(reser_num,loginId);
         logger.info("이용완료처리하고 정보해쉬맵?:{}",list);
         // 예약취소 후 예약히스토리 등록
         int success = dao.reserLogSuccess(list);
         // 일반회원 알림서비스
         int AlarmInsert = dao.AlarmInsert(list);
         
         // 이용완료 후 업주 노포인트에서 차감 
         int UseSuccessNoPoint = dao.UseSuccessNoPoint(busin_num,reser_num,reser_money);
         logger.info("이용완료 후 업주 노포인트에서 차감 ?:{}",UseSuccessNoPoint);
         // 이용완료 후 업주 포인트에서 가감
         int UseSuccessPointAdd = dao.UseSuccessPointAdd(busin_num,reser_money);
         logger.info("이용완료 후 업주 포인트에서 가감?:{}",UseSuccessPointAdd);
         
         rAttr.addFlashAttribute("msg", "이용완료처리가 완료되었습니다.");
         mav.setViewName("redirect:/OwnerReserPage");
      }else {
         rAttr.addFlashAttribute("msg", "이용완료처리가 불가능합니다.");
         mav.setViewName("redirect:/OwnerReserPage");
      }
      return mav;
   }

   public ModelAndView OwnerReserLogPage(String loginId) {
      ModelAndView mav = new ModelAndView();
      
      ArrayList<DogDTO> memInfo = dao.OwnerReserLogPage(loginId);
      
      mav.addObject("loginId", loginId);
      mav.addObject("memInfo", memInfo);
      mav.setViewName("cywMyPageReserLog");
      
      return mav;
   }

   public HashMap<String, Object> ReserLogList(int currPage, int pagePerCnt, String loginId) {
      HashMap<String, Object> map = new HashMap<String, Object>();
      
      //어디서부터 보여줘야 하는가?
      int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
      logger.info("offset:{}",offset);
      
      int totalCount = dao.ReserLogListCount(loginId); 
      
      int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
      
      logger.info("총 갯수 : {}",totalCount);
      logger.info("만들수 있는 총 페이지 :{}",range);
      
      map.put("pages", range);
      map.put("list", dao.ReserLogList(pagePerCnt,offset,loginId));
      
      
      return map;
   }

   // -----------------------------------------------------------------------------------------
   
   // 밑에부터 신고 부분
   
/*   public ModelAndView SingoHangmokPage() {
      
      ModelAndView mav = new ModelAndView();
      
      mav.setViewName("cywAdminSingoHangmok");
      
      return mav;
   }*/

   public HashMap<String, Object> SingoHangmokList(int currPage, int pagePerCnt) {
      HashMap<String, Object> map = new HashMap<String, Object>();
      
      //어디서부터 보여줘야 하는가?
      int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
      logger.info("offset:{}",offset);
      
      int totalCount = dao.SingoHangmokListCount(); 
      
      int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
      
      logger.info("총 갯수 : {}",totalCount);
      logger.info("만들수 있는 총 페이지 :{}",range);
      
      map.put("pages", range);
      map.put("list", dao.SingoHangmokList(pagePerCnt,offset));
      
      
      return map;
   }

   public ModelAndView SingoHangmokAdd(String singoSub, RedirectAttributes rAttr) {
      ModelAndView mav = new ModelAndView();
      
      int row = dao.SingoHangmokAdd(singoSub);
      
      if (row > 0) {
         rAttr.addFlashAttribute("msg", "신고항목이 등록되었습니다.");
         mav.setViewName("redirect:/SingoHangmokPage");
      }else {
         rAttr.addFlashAttribute("msg", "등록에 실패했습니다.");
         mav.setViewName("redirect:/SingoHangmokPage");
      }
      
      return mav;
   }

   public ModelAndView HangmokReUse(String decO_num, RedirectAttributes rAttr) {
      ModelAndView mav = new ModelAndView();
      
      int row = dao.HangmokReUse(decO_num);
      
      if (row > 0) {
         rAttr.addFlashAttribute("msg", "신고항목이 상태변경되었습니다.");
         mav.setViewName("redirect:/SingoHangmokPage");
      }else {
         rAttr.addFlashAttribute("msg", "상태변경에 실패했습니다.");
         mav.setViewName("redirect:/SingoHangmokPage");
      }
      
      return mav;
   }

   public ModelAndView HangmokDel(String decO_num, RedirectAttributes rAttr) {
      ModelAndView mav = new ModelAndView();
      
      int row = dao.HangmokDel(decO_num);
      
      if (row > 0) {
         rAttr.addFlashAttribute("msg", "신고항목이 상태변경되었습니다.");
         mav.setViewName("redirect:/SingoHangmokPage");
      }else {
         rAttr.addFlashAttribute("msg", "상태변경에 실패했습니다.");
         mav.setViewName("redirect:/SingoHangmokPage");
      }
      
      return mav;
   }

   public ModelAndView SingoListPage(String loginId) {
      
      ModelAndView mav = new ModelAndView();
  	
	  	int AdminCheck = dao.SingoHangmokPage(loginId);
	  	if (AdminCheck == 1) {
	  		mav.setViewName("cywAdminSingoList");
	  	}else {
	  		mav.addObject("loginSuccessAlert", "관리자만 사용할수 있는 페이지입니다.");
	  		mav.setViewName("Main");
	  	}
      
      return mav;
   }

   public HashMap<String, Object> SingoNoCheckList(int currPage, int pagePerCnt) {
      HashMap<String, Object> map = new HashMap<String, Object>();
      
      //어디서부터 보여줘야 하는가?
      int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
      logger.info("offset:{}",offset);
      
      int totalCount = dao.SingoNoCheckListCount(); 
      
      int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
      
      logger.info("총 갯수 : {}",totalCount);
      logger.info("만들수 있는 총 페이지 :{}",range);
      
      map.put("pages", range);
      map.put("list", dao.SingoNoCheckList(pagePerCnt,offset));
      
      
      return map;
   }

   public ModelAndView SingoProcess(String decl_num, RedirectAttributes rAttr, String loginId) {
      ModelAndView mav = new ModelAndView();
      
//      예약상태 변경
      int row = dao.SingoProcess(decl_num);
      
      if (row > 0) {
         // 예약처리테이블 등록
         int success = dao.decAdminInsert(decl_num,loginId);
         
         rAttr.addFlashAttribute("msg", "신고가 처리상태가 되었습니다.");
         mav.setViewName("redirect:/SingoListPage");
      }else {
         rAttr.addFlashAttribute("msg", "상태변경에 실패했습니다.");
         mav.setViewName("redirect:/SingoListPage");
      }
      
      return mav;
   }
   
   public ModelAndView SingoProcessListPage(String loginId) {
      ModelAndView mav = new ModelAndView();
    	
	  	int AdminCheck = dao.SingoHangmokPage(loginId);
	  	if (AdminCheck == 1) {
	  		mav.setViewName("cywAdminSingoProcess");
	  	}else {
	  		mav.addObject("loginSuccessAlert", "관리자만 사용할수 있는 페이지입니다.");
	  		mav.setViewName("Main");
	  	}
      
      return mav;
   }

   public HashMap<String, Object> SingoProcessList(int currPage, int pagePerCnt) {
      HashMap<String, Object> map = new HashMap<String, Object>();
      
      //어디서부터 보여줘야 하는가?
      int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
      logger.info("offset:{}",offset);
      
      int totalCount = dao.SingoProcessListCount(); 
      
      int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
      
      logger.info("총 갯수 : {}",totalCount);
      logger.info("만들수 있는 총 페이지 :{}",range);
      
      map.put("pages", range);
      map.put("list", dao.SingoProcessList(pagePerCnt,offset));
      
      
      return map;
   }

   public ModelAndView AdminServicePage(String loginId) {
      ModelAndView mav = new ModelAndView();
      
      int AdminCheck = dao.SingoHangmokPage(loginId);
	  	if (AdminCheck == 1) {
	  		mav.setViewName("cywAdminAddService");
	  	}else {
	  		mav.addObject("loginSuccessAlert", "관리자만 사용할수 있는 페이지입니다.");
	  		mav.setViewName("Main");
	  	}
      
      
      return mav;
   }

   public HashMap<String, Object> ServiceHangmokList(int currPage, int pagePerCnt) {
      HashMap<String, Object> map = new HashMap<String, Object>();
      
      //어디서부터 보여줘야 하는가?
      int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
      logger.info("offset:{}",offset);
      
      int totalCount = dao.ServiceHangmokListCount(); 
      
      int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
      
      logger.info("총 갯수 : {}",totalCount);
      logger.info("만들수 있는 총 페이지 :{}",range);
      
      map.put("pages", range);
      map.put("list", dao.ServiceHangmokList(pagePerCnt,offset));
      
      
      return map;
   }

   public ModelAndView UseServiceChange(String add_num, RedirectAttributes rAttr) {
      ModelAndView mav = new ModelAndView();
      
      int row = dao.UseServiceChange(add_num);
      
      if (row > 0) {
         
         rAttr.addFlashAttribute("msg", "사용상태로 변경 되었습니다.");
         mav.setViewName("redirect:/AdminServicePage");
      }else {
         rAttr.addFlashAttribute("msg", "상태변경에 실패했습니다.");
         mav.setViewName("redirect:/AdminServicePage");
      }
      
      return mav;
   }

   public ModelAndView NoUseServiceChange(String add_num, RedirectAttributes rAttr) {
      ModelAndView mav = new ModelAndView();
      
      int row = dao.NoUseServiceChange(add_num);
      
      if (row > 0) {
         
         rAttr.addFlashAttribute("msg", "미사용상태로 변경 되었습니다.");
         mav.setViewName("redirect:/AdminServicePage");
      }else {
         rAttr.addFlashAttribute("msg", "상태변경에 실패했습니다.");
         mav.setViewName("redirect:/AdminServicePage");
      }
      
      return mav;
   }

   public ModelAndView ServiceHangmokAdd(String serviceDog, String serviceSub, RedirectAttributes rAttr) {
      ModelAndView mav = new ModelAndView();
      
      int row = dao.ServiceHangmokAdd(serviceDog,serviceSub);
      
      if (row > 0) {
         
         rAttr.addFlashAttribute("msg", "서비스가 추가되었습니다.");
         mav.setViewName("redirect:/AdminServicePage");
      }else {
         rAttr.addFlashAttribute("msg", "서비스추가에 실패했습니다.");
         mav.setViewName("redirect:/AdminServicePage");
      }
      
      return mav;
   }

   public ModelAndView ChangeListPage(String loginId) {
      ModelAndView mav = new ModelAndView();

      int AdminCheck = dao.SingoHangmokPage(loginId);
	  	if (AdminCheck == 1) {
	  		mav.setViewName("cywAdminChangeList");
	  	}else {
	  		mav.addObject("loginSuccessAlert", "관리자만 사용할수 있는 페이지입니다.");
	  		mav.setViewName("Main");
	  	} 
      
      return mav;
   }

   public HashMap<String, Object> ChangeList(int currPage, int pagePerCnt) {
      HashMap<String, Object> map = new HashMap<String, Object>();
      
      //어디서부터 보여줘야 하는가?
      int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
      logger.info("offset:{}",offset);
      
      int totalCount = dao.ChangeListCount(); 
      
      int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
      
      logger.info("총 갯수 : {}",totalCount);
      logger.info("만들수 있는 총 페이지 :{}",range);
      
      map.put("pages", range);
      map.put("list", dao.ChangeList(pagePerCnt,offset));
      
      
      return map;
   }

   public ModelAndView ChangeMoneyCheck(String poch_num, RedirectAttributes rAttr, String loginId) {
      ModelAndView mav = new ModelAndView();
      
      int row = dao.ChangeMoneyCheck(poch_num);
      
      if (row > 0) {
         dao.pointChOkAdd(poch_num,loginId);
         
         rAttr.addFlashAttribute("msg", "환전 신청이 완료처리 되었습니다.");
         mav.setViewName("redirect:/ChangeListPage");
      }else {
         rAttr.addFlashAttribute("msg", "환전 신청이 완료처리에 실패했습니다.");
         mav.setViewName("redirect:/ChangeListPage");
      }
      
      return mav;
   }

   public ModelAndView ChangeOkListPage(String loginId) {
      ModelAndView mav = new ModelAndView();
      int AdminCheck = dao.SingoHangmokPage(loginId);
	  	if (AdminCheck == 1) {
	  		mav.setViewName("cywAdminChangeOk");
	  	}else {
	  		mav.addObject("loginSuccessAlert", "관리자만 사용할수 있는 페이지입니다.");
	  		mav.setViewName("Main");
	  	}  
      return mav;
   }

   public HashMap<String, Object> ChangeOkList(int currPage, int pagePerCnt) {
      HashMap<String, Object> map = new HashMap<String, Object>();
      
      //어디서부터 보여줘야 하는가?
      int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
      logger.info("offset:{}",offset);
      
      int totalCount = dao.ChangeOkListCount(); 
      
      int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
      
      logger.info("총 갯수 : {}",totalCount);
      logger.info("만들수 있는 총 페이지 :{}",range);
      
      map.put("pages", range);
      map.put("list", dao.ChangeOkList(pagePerCnt,offset));
      
      
      return map;
   }

   public ModelAndView ShopServicePage(String loginId) {
      ModelAndView mav = new ModelAndView();
      
      // 해당 아이디의 매장 정보
      ArrayList<DogDTO> ShopServiceList = dao.ShopServiceList(loginId);
      
      // 해당 매장 서비스 목록 과 추가항목 리스트
      ArrayList<DogDTO> ServiceInfoList = dao.ShopService(loginId);
      // 소형견 서비스
      ArrayList<DogDTO> AddSmallServiceName = dao.AddSmallServiceName();
      // 중형견 서비스
      ArrayList<DogDTO> AddMiddleServiceName = dao.AddMiddleServiceName();
      // 대형견 서비스
      ArrayList<DogDTO> AddBigServiceName = dao.AddBigServiceName();
      logger.info("서비스 가져오냐?{}",AddSmallServiceName);
      
      mav.addObject("loginId", loginId);
      mav.addObject("AddSmallServiceName", AddSmallServiceName);
      mav.addObject("AddMiddleServiceName", AddMiddleServiceName);
      mav.addObject("AddBigServiceName", AddBigServiceName);
      mav.addObject("ShopServiceList", ShopServiceList);
      mav.addObject("ServiceInfoList", ServiceInfoList);
      mav.setViewName("cywShopService");
      
      return mav;
   }

   public ModelAndView SreviceDel(String price_num, RedirectAttributes rAttr) {
      ModelAndView mav = new ModelAndView();
      
      int row = dao.SreviceDel(price_num);
      
      if (row > 0) {
         rAttr.addFlashAttribute("msg", "서비스가 삭제 되었습니다.");
         mav.setViewName("redirect:/ShopServicePage");
      }else {
         rAttr.addFlashAttribute("msg", "서비스삭제에 실패했습니다.");
         mav.setViewName("redirect:/ShopServicePage");
      }
      
      return mav;
   }

   public ModelAndView addShopSmallService(String inputText1, String serviceName1, String busin_num, RedirectAttributes rAttr) {
      ModelAndView mav = new ModelAndView();
      
      int row = dao.addShopSmallService(inputText1,serviceName1,busin_num);
      
      if (row > 0) {
         rAttr.addFlashAttribute("msg", "서비스가 추가 되었습니다.");
         mav.setViewName("redirect:/ShopServicePage");
      }else {
         rAttr.addFlashAttribute("msg", "서비스추가에 실패했습니다.");
         mav.setViewName("redirect:/ShopServicePage");
      }
      
      return mav;
   }

   public ModelAndView addShopMiddleService(String inputText2, String serviceName2, String busin_num,
         RedirectAttributes rAttr) {
      ModelAndView mav = new ModelAndView();
      
      int row = dao.addShopMiddleService(inputText2,serviceName2,busin_num);
      
      if (row > 0) {
         rAttr.addFlashAttribute("msg", "서비스가 추가 되었습니다.");
         mav.setViewName("redirect:/ShopServicePage");
      }else {
         rAttr.addFlashAttribute("msg", "서비스추가에 실패했습니다.");
         mav.setViewName("redirect:/ShopServicePage");
      }
      
      return mav;
   }

   public ModelAndView addShopBigService(String inputText3, String serviceName3, String busin_num,
         RedirectAttributes rAttr) {
      ModelAndView mav = new ModelAndView();
      
      int row = dao.addShopBigService(inputText3,serviceName3,busin_num);
      
      if (row > 0) {
         rAttr.addFlashAttribute("msg", "서비스가 추가 되었습니다.");
         mav.setViewName("redirect:/ShopServicePage");
      }else {
         rAttr.addFlashAttribute("msg", "서비스추가에 실패했습니다.");
         mav.setViewName("redirect:/ShopServicePage");
      }
      
      return mav;
   }

public ModelAndView SingoHangmokPage(String loginId) {
	
	ModelAndView mav = new ModelAndView();
	
	int AdminCheck = dao.SingoHangmokPage(loginId);
	if (AdminCheck == 1) {
		mav.setViewName("cywAdminSingoHangmok");
	}else {
		mav.addObject("loginSuccessAlert", "관리자만 사용할수 있는 페이지입니다.");
		mav.setViewName("Main");
	}
	
	return mav;
}

   
   
   
   
}