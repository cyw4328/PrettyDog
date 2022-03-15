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
	
	
	
	
}
