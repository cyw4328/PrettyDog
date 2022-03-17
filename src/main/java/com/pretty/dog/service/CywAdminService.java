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
	
	public ModelAndView categoryPage() {
		ModelAndView mav = new ModelAndView();
		
		/*
		 * ArrayList<DogDTO> list = dao.categoryPage();
		 * 
		 * mav.addObject("list", list);
		 */
		mav.setViewName("cywCateGory");
		
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
	
	
//	마이페이지 부분 -------------------------------------------------------------------------------

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
		
		ArrayList<DogDTO> memInfo = dao.MyBoard(loginId);
		
		mav.addObject("loginId", loginId);
		mav.addObject("memInfo", memInfo);
		mav.setViewName("cywMyPageBoard");
		
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

	public ModelAndView reserDel(String reser_num, String loginId, RedirectAttributes rAttr) {
		ModelAndView mav =new ModelAndView();
		
		int row = dao.reserDel(reser_num,loginId);
		
		if (row > 0) {
			// 예약취소 후의 데이터 불러오기
			HashMap<String, Object> list = dao.reserData(reser_num,loginId);
			logger.info("예약취소하고 정보해쉬맵?:{}",list);
			// 예약취소 후 예약히스토리 등록
			int success = dao.reserLogInsert(list);
			// 알람등록(일반회원)
			int Alarm = dao.reserCancleInsert(list);
			// 알람등록(업주회원)
			int OwnerAlarm = dao.OwnerCancleInsert(list);
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

	public ModelAndView NoShowChange(String reser_num, String loginId, RedirectAttributes rAttr) {
		ModelAndView mav =new ModelAndView();
		
		int row = dao.NoShowChange(reser_num,loginId);
		
		if (row > 0) {
			HashMap<String, Object> list = dao.reserData(reser_num,loginId);
			logger.info("노쇼처리하고 정보해쉬맵?:{}",list);
			// 예약취소 후 예약히스토리 등록
			int success = dao.reserLogNoshow(list);

			rAttr.addFlashAttribute("msg", "노쇼처리가 완료되었습니다.");
			mav.setViewName("redirect:/OwnerReserPage");
		}else {
			rAttr.addFlashAttribute("msg", "노쇼처리가 불가능합니다.");
			mav.setViewName("redirect:/OwnerReserPage");
		}
		return mav;
	}

	public ModelAndView SuccessChange(String reser_num, String loginId, RedirectAttributes rAttr) {
		ModelAndView mav =new ModelAndView();
		
		int row = dao.SuccessChange(reser_num,loginId);
		
		if (row > 0) {
			HashMap<String, Object> list = dao.reserData(reser_num,loginId);
			logger.info("이용완료처리하고 정보해쉬맵?:{}",list);
			// 예약취소 후 예약히스토리 등록
			int success = dao.reserLogSuccess(list);
			// 일반회원 알림서비스
			int AlarmInsert = dao.AlarmInsert(list);
			
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
	
	public ModelAndView SingoHangmokPage() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("cywAdminSingoHangmok");
		
		return mav;
	}

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

	public ModelAndView SingoListPage() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("cywAdminSingoList");
		
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
		
//		예약상태 변경
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
	
	public ModelAndView SingoProcessListPage() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("cywAdminSingoProcess");
		
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

	public ModelAndView AdminServicePage() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("cywAdminAddService");
		
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

	
	
	
	
}
