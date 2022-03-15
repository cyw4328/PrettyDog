package com.pretty.dog.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pretty.dog.service.CywAdminService;

@Controller
public class CywAdminController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired CywAdminService service;
	
	@RequestMapping(value = "/categoryPage")
	public ModelAndView idSearchPage(Model model,HttpSession session) {
		logger.info("카테고리페이지");

		return service.categoryPage();
	}
	
	
	@RequestMapping(value = "/categoryListCall", method = RequestMethod.GET) 
	public @ResponseBody HashMap<String, Object> categoryListCall(@RequestParam String page,@RequestParam String cnt) {
		logger.info("리스트 요청:{} 페이지, {} 개 씩",page,cnt);
		
		int currPage = Integer.parseInt(page);
		int pagePerCnt = Integer.parseInt(cnt);

		return service.categoryListCall(currPage,pagePerCnt);
	}
	
	
	@RequestMapping(value = "/cateGoryAdd")
	public ModelAndView cateGoryAdd(@RequestParam String categoryName,@RequestParam String categoryClass,RedirectAttributes rAttr) {
		logger.info("카테고리 추가");

		return service.cateGoryAdd(categoryName,categoryClass,rAttr);
	}
	
	@RequestMapping(value = "/categoryDel")
	public ModelAndView categoryDel(@RequestParam String category_num,RedirectAttributes rAttr) {
		logger.info("카테고리 삭제:{}",category_num);

		return service.categoryDel(category_num,rAttr);
	}
	
	@RequestMapping(value = "/TEST1")
	public ModelAndView TEST1() {
		ModelAndView mavAndView = new ModelAndView();

		mavAndView.setViewName("cywTest");
		
		return mavAndView;
	}
	
	
	@RequestMapping(value = "/MyPageAlarm")
	public ModelAndView MyPageAlarm(HttpSession session) {
		logger.info("마이페이지알림페이지");
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		return service.MyPageAlarm(loginId);
	}
	
	@RequestMapping(value = "/AlrimPageList", method = RequestMethod.GET) 
	public @ResponseBody HashMap<String, Object> AlrimPageList(@RequestParam String page,@RequestParam String cnt,HttpSession session) {
		logger.info("리스트 요청:{} 페이지, {} 개 씩",page,cnt);
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		
		int currPage = Integer.parseInt(page);
		int pagePerCnt = Integer.parseInt(cnt);

		return service.AlrimPageList(currPage,pagePerCnt,loginId);
	}
	
	@RequestMapping(value = "/alarmDel")
	public ModelAndView alarmDel(HttpSession session,@RequestParam String alarm_num,RedirectAttributes rAttr) {
		logger.info("마이페이지알림삭제:{}",alarm_num);

		
		return service.alarmDel(alarm_num,rAttr);
	}
	
	@RequestMapping(value = "/MyPageBoard")
	public ModelAndView MyPageBoard(HttpSession session) {
		logger.info("마이페이지게시물페이지");
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		return service.MyPageBoard(loginId);
	}
	
	@RequestMapping(value = "/MyBoardPageList", method = RequestMethod.GET) 
	public @ResponseBody HashMap<String, Object> MyBoardPageList(@RequestParam String page,@RequestParam String cnt,HttpSession session) {
		logger.info("리스트 요청:{} 페이지, {} 개 씩",page,cnt);
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		
		int currPage = Integer.parseInt(page);
		int pagePerCnt = Integer.parseInt(cnt);

		return service.MyBoardPageList(currPage,pagePerCnt,loginId);
	}
	
	@RequestMapping(value = "/boardDel")
	public ModelAndView boardDel(HttpSession session,@RequestParam String community_boardnum,RedirectAttributes rAttr) {
		logger.info("마이페이지게시글삭제:{}",community_boardnum);
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		
		return service.boardDel(community_boardnum,loginId,rAttr);
	}
	
	@RequestMapping(value = "/MyPageComment")
	public ModelAndView MyPageComment(HttpSession session) {
		logger.info("마이페이지댓글페이지");
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		
		return service.MyPageComment(loginId);
	}
	@RequestMapping(value = "/CommentPageList", method = RequestMethod.GET) 
	public @ResponseBody HashMap<String, Object> CommentPageList(@RequestParam String page,@RequestParam String cnt,HttpSession session) {
		logger.info("리스트 요청:{} 페이지, {} 개 씩",page,cnt);
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		
		int currPage = Integer.parseInt(page);
		int pagePerCnt = Integer.parseInt(cnt);

		return service.CommentPageList(currPage,pagePerCnt,loginId);
	}
	
	@RequestMapping(value = "/commentDel")
	public ModelAndView commentDel(HttpSession session,@RequestParam String bcomment_num,RedirectAttributes rAttr) {
		logger.info("마이페이지댓글삭제:{}",bcomment_num);
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		
		return service.commentDel(bcomment_num,loginId,rAttr);
	}
	
	@RequestMapping(value = "/MyPageLikeShop")
	public ModelAndView MyPageLikeShop(HttpSession session) {
		logger.info("마이페이지관심매장페이지");
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		
		return service.MyPageLikeShop(loginId);
	}
	
	@RequestMapping(value = "/MyLikeShopList", method = RequestMethod.GET) 
	public @ResponseBody HashMap<String, Object> MyLikeShopList(@RequestParam String page,@RequestParam String cnt,HttpSession session) {
		logger.info("리스트 요청:{} 페이지, {} 개 씩",page,cnt);
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		
		int currPage = Integer.parseInt(page);
		int pagePerCnt = Integer.parseInt(cnt);

		return service.MyLikeShopList(currPage,pagePerCnt,loginId);
	}
	
	@RequestMapping(value = "/LikeShopDel")
	public ModelAndView LikeShopDel(HttpSession session,@RequestParam String interestshop_num,RedirectAttributes rAttr) {
		logger.info("마이페이지관심매장삭제:{}",interestshop_num);
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		
		return service.LikeShopDel(interestshop_num,loginId,rAttr);
	}
	
	@RequestMapping(value = "/MyPageReserPage")
	public ModelAndView MyPageReserPage(HttpSession session) {
		logger.info("마이페이지예약목록페이지");
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		
		return service.MyPageReserPage(loginId);
	}
	
}
