package com.pretty.dog.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	
	@RequestMapping(value = "/SingoHangmokPage")
	public ModelAndView SingoHangmokPage(HttpSession session) {
		logger.info("신고항목 페이지");

		return service.SingoHangmokPage();
	}
	
	@RequestMapping(value = "/SingoHangmokList", method = RequestMethod.POST) 
	public @ResponseBody HashMap<String, Object> SingoHangmokList(@RequestParam String page,@RequestParam String cnt) {
		logger.info("리스트 요청:{} 페이지, {} 개 씩",page,cnt);
		
		int currPage = Integer.parseInt(page);
		int pagePerCnt = Integer.parseInt(cnt);

		return service.SingoHangmokList(currPage,pagePerCnt);
	}
	
	@RequestMapping(value = "/SingoHangmokAdd")
	public ModelAndView SingoHangmokAdd(@RequestParam String SingoSub,RedirectAttributes rAttr) {

		return service.SingoHangmokAdd(SingoSub,rAttr);
	}
	
	@RequestMapping(value = "/HangmokReUse")
	public ModelAndView HangmokReUse(@RequestParam String decO_num,RedirectAttributes rAttr) {

		return service.HangmokReUse(decO_num,rAttr);
	}
	
	@RequestMapping(value = "/HangmokDel")
	public ModelAndView HangmokDel(@RequestParam String decO_num,RedirectAttributes rAttr) {

		return service.HangmokDel(decO_num,rAttr);
	}
	
	@RequestMapping(value = "/SingoListPage")
	public ModelAndView SingoListPage(HttpSession session) {
		logger.info("신고리스트 페이지");

		return service.SingoListPage();
	}
	
	@RequestMapping(value = "/SingoNoCheckList", method = RequestMethod.POST) 
	public @ResponseBody HashMap<String, Object> SingoNoCheckList(@RequestParam String page,@RequestParam String cnt) {
		logger.info("리스트 요청:{} 페이지, {} 개 씩",page,cnt);
		
		int currPage = Integer.parseInt(page);
		int pagePerCnt = Integer.parseInt(cnt);

		return service.SingoNoCheckList(currPage,pagePerCnt);
	}
	
	@RequestMapping(value = "/SingoProcess")
	public ModelAndView SingoProcess(HttpSession session,@RequestParam String decl_num,RedirectAttributes rAttr) {
		logger.info("신고처리",decl_num);
		
		/* String loginId = (String) session.getAttribute("loginId"); */
		
		String loginId = "dud";
		
		return service.SingoProcess(decl_num,rAttr,loginId);
	}
	
	@RequestMapping(value = "/SingoProcessListPage")
	public ModelAndView SingoProcessListPage(HttpSession session) {
		logger.info("신고리스트 페이지");

		return service.SingoProcessListPage();
	}
	
	@RequestMapping(value = "/SingoProcessList", method = RequestMethod.POST) 
	public @ResponseBody HashMap<String, Object> SingoProcessList(@RequestParam String page,@RequestParam String cnt) {
		logger.info("리스트 요청:{} 페이지, {} 개 씩",page,cnt);
		
		int currPage = Integer.parseInt(page);
		int pagePerCnt = Integer.parseInt(cnt);

		return service.SingoProcessList(currPage,pagePerCnt);
	}
	
	@RequestMapping(value = "/AdminServicePage")
	public ModelAndView AdminServicePage(HttpSession session) {
		logger.info("추가서비스항목 페이지");

		return service.AdminServicePage();
	}
	
	@RequestMapping(value = "/ServiceHangmokList", method = RequestMethod.POST) 
	public @ResponseBody HashMap<String, Object> ServiceHangmokList(@RequestParam String page,@RequestParam String cnt) {
		logger.info("리스트 요청:{} 페이지, {} 개 씩",page,cnt);
		
		int currPage = Integer.parseInt(page);
		int pagePerCnt = Integer.parseInt(cnt);

		return service.ServiceHangmokList(currPage,pagePerCnt);
	}
	
	@RequestMapping(value = "/UseServiceChange")
	public ModelAndView UseServiceChange(HttpSession session,@RequestParam String add_num,RedirectAttributes rAttr) {
		logger.info("서비스 사용으로 바꾸기");

		return service.UseServiceChange(add_num,rAttr);
	}
	
	@RequestMapping(value = "/NoUseServiceChange")
	public ModelAndView NoUseServiceChange(HttpSession session,@RequestParam String add_num,RedirectAttributes rAttr) {
		logger.info("서비스 사용으로 바꾸기");

		return service.NoUseServiceChange(add_num,rAttr);
	}
	
	@RequestMapping(value = "/ServiceHangmokAdd")
	public ModelAndView ServiceHangmokAdd(HttpSession session,@RequestParam String ServiceDog,@RequestParam String ServiceSub,RedirectAttributes rAttr) {
		logger.info("서비스 추가");

		return service.ServiceHangmokAdd(ServiceDog,ServiceSub,rAttr);
	}
	
	
	@RequestMapping(value = "/ChangeListPage")
	public ModelAndView ChangeListPage(HttpSession session) {
		logger.info("환전신청목록 페이지");

		return service.ChangeListPage();
	}
	
	@RequestMapping(value = "/ChangeList", method = RequestMethod.POST) 
	public @ResponseBody HashMap<String, Object> ChangeList(@RequestParam String page,@RequestParam String cnt) {
		logger.info("리스트 요청:{} 페이지, {} 개 씩",page,cnt);
		
		int currPage = Integer.parseInt(page);
		int pagePerCnt = Integer.parseInt(cnt);

		return service.ChangeList(currPage,pagePerCnt);
	}
	
	@RequestMapping(value = "/ChangeMoneyCheck")
	public ModelAndView ChangeMoneyCheck(HttpSession session,@RequestParam String poch_num,RedirectAttributes rAttr) {
		logger.info("환전신청완료하기");

		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		return service.ChangeMoneyCheck(poch_num,rAttr,loginId);
	}
	
	@RequestMapping(value = "/ChangeOkListPage")
	public ModelAndView ChangeOkListPage(HttpSession session) {
		logger.info("환전완료목록 페이지");

		return service.ChangeOkListPage();
	}

	@RequestMapping(value = "/ChangeOkList", method = RequestMethod.POST) 
	public @ResponseBody HashMap<String, Object> ChangeOkList1(@RequestParam String page,@RequestParam String cnt) {
		logger.info("리스트 요청:{} 페이지, {} 개 씩",page,cnt);
		
		int currPage = Integer.parseInt(page);
		int pagePerCnt = Integer.parseInt(cnt);

		return service.ChangeOkList(currPage,pagePerCnt);
	}
	
	@RequestMapping(value = "/TEST1")
	public ModelAndView TEST1() {
		ModelAndView mavAndView = new ModelAndView();
		
		mavAndView.setViewName("cywTest");
		
		return mavAndView;
	}
	
	
//	마이페이지 쪽 -----------------------------------------------------------------------------
	
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
		logger.info("마이페이지일반회원예약목록페이지");
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		
		return service.MyPageReserPage(loginId);
	}
	
	@RequestMapping(value = "/MyReserPageList", method = RequestMethod.GET) 
	public @ResponseBody HashMap<String, Object> MyReserPageList(@RequestParam String page,@RequestParam String cnt,HttpSession session) {
		logger.info("리스트 요청:{} 페이지, {} 개 씩",page,cnt);
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		
		int currPage = Integer.parseInt(page);
		int pagePerCnt = Integer.parseInt(cnt);

		return service.MyReserPageList(currPage,pagePerCnt,loginId);
	}
	
	@RequestMapping(value = "/reserDel")
	public ModelAndView reserDel(HttpSession session,@RequestParam String reser_num,
			RedirectAttributes rAttr,@RequestParam String reser_money,@RequestParam String busin_num,@RequestParam String reserDay,@RequestParam String reserTime) {
		//logger.info("마이페이지일반회원예약취소:{}",reser_num);
		//logger.info("마이페이지일반회원예약취소금액:{}",reser_money);
		logger.info("마이페이지예약취소사업자번호:{}",busin_num);
		//logger.info("마이페이지예약취소예약방문날짜:{}",reserDay);
		//logger.info(reserTime);
		
		String canReserTime = "$."+reserTime;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		//로컬데이터를 이용한 날짜 추출
		LocalDate reser = LocalDate.parse(reserDay, formatter);
		
		LocalDate now = LocalDate.now(); 	
		LocalDate oneDay = now.plusDays(1);
		LocalDate threeDay = now.plusDays(3);
		LocalDate fiveDay = now.plusDays(5);
		LocalDate sevenDay = now.plusDays(7);
		LocalDate freeDay = now.plusDays(15);
		
		//최종적으로 처리할 환불금에 대한 정보를 담을 변수
		int normalChange = 0;
		int businChange = 0;
		
		/*
		 * int normalEx; int BusinEx;
		 */
		
		int servicePrice = Integer.parseInt(reser_money);

		if(reser.isEqual(now)){
			
			businChange = servicePrice;
			normalChange = servicePrice*0;
			
			System.out.println("환불금 0%");
			System.out.println("업주 한테 :"+businChange);
		}else if(reser.isBefore(threeDay) && reser.isAfter(oneDay) || reser.isEqual(oneDay)){
			
			businChange = servicePrice*90/100;
			normalChange = servicePrice*10/100;
					
			System.out.println("환불금 10%");
			System.out.println("업주 한테 :"+businChange);
			System.out.println("일반 한테 :"+normalChange);
		}else if(reser.isBefore(fiveDay) && reser.isAfter(threeDay) || reser.isEqual(threeDay)){
			
			businChange = servicePrice*70/100;
			normalChange = servicePrice*30/100;

			System.out.println("환불금 30%");
			System.out.println("업주 한테 :"+businChange);
			System.out.println("일반 한테 :"+normalChange);
		}else if(reser.isBefore(sevenDay) && reser.isAfter(fiveDay) || reser.isEqual(fiveDay)){

			businChange = servicePrice*50/100;
			normalChange = servicePrice*50/100;
			
			System.out.println("환불금 50%");
			System.out.println("업주 한테 :"+businChange);
			System.out.println("일반 한테 :"+normalChange);
		}else if(reser.isBefore(freeDay) && reser.isAfter(sevenDay) || reser.isEqual(sevenDay)){
			
			businChange = servicePrice*30/100;
			normalChange = servicePrice*30/100;
			
			System.out.println("환불금 70%");
			System.out.println("업주 한테 :"+businChange);
			System.out.println("일반 한테 :"+normalChange);
		}else if(reser.isAfter(freeDay) || reser.isEqual(freeDay)){
			
			businChange = servicePrice*0;
			normalChange = servicePrice;
			
			System.out.println("환불금 100%");
			System.out.println("일반 한테 :"+servicePrice);
		}

		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		
		// 업주 회원 noPoint 에서 차감 할 포인트 변수명  businChange
		// 일반 호원 point 에서 적립 될 포인트 변수명 normalChange
		// 예약 상태를 변경하기 위해서 보내야 할 변수명 2개  1.날짜 reserDay, 2.시간 canReserTime
		
		return service.reserDel(reser_num,loginId,rAttr,busin_num,businChange,normalChange,reserDay,canReserTime);
	}
	
	@RequestMapping(value = "/OwnerReserPage")
	public ModelAndView OwnerReserPageList(HttpSession session) {
		logger.info("마이페이지업주회원예약목록페이지");
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		
		return service.OwnerReserPage(loginId);
	}
	@RequestMapping(value = "/OwnerReserPageList", method = RequestMethod.GET) 
	public @ResponseBody HashMap<String, Object> OwnerReserPageList(@RequestParam String page,@RequestParam String cnt,HttpSession session) {
		logger.info("리스트 요청:{} 페이지, {} 개 씩",page,cnt);
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		
		int currPage = Integer.parseInt(page);
		int pagePerCnt = Integer.parseInt(cnt);

		return service.OwnerReserPageList(currPage,pagePerCnt,loginId);
	}
	
	@RequestMapping(value = "/NoShowChange")
	public ModelAndView NoShowChange(HttpSession session,@RequestParam String reser_num,
			RedirectAttributes rAttr,@RequestParam String busin_num,@RequestParam String reser_money) {
		logger.info("마이페이지예약노쇼처리:{}",reser_num);
		logger.info("마이페이지예약노쇼사업자번호:{}",busin_num);
		logger.info("마이페이지예약노쇼 금액:{}",reser_money);
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		
		return service.NoShowChange(reser_num,loginId, rAttr,busin_num,reser_money);
	}
	
	@RequestMapping(value = "/SuccessChange")
	public ModelAndView SuccessChange(HttpSession session,@RequestParam String reser_num,
			RedirectAttributes rAttr,@RequestParam String busin_num,@RequestParam String reser_money) {
		logger.info("마이페이지예약이용완료처리:{}",reser_num);
		logger.info("마이페이지예약이용완료사업자번호:{}",busin_num);
		logger.info("마이페이지예약이용완료 금액:{}",reser_money);
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		
		return service.SuccessChange(reser_num,loginId, rAttr,busin_num,reser_money);
	}
	
	@RequestMapping(value = "/OwnerReserLogPage")
	public ModelAndView OwnerReserLogPage(HttpSession session) {
		logger.info("마이페이지업주회원예약목록페이지");
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		
		return service.OwnerReserLogPage(loginId);
	}
	
	@RequestMapping(value = "/ReserLogList", method = RequestMethod.GET) 
	public @ResponseBody HashMap<String, Object> ReserLogList(@RequestParam String page,@RequestParam String cnt,HttpSession session) {
		logger.info("리스트 요청:{} 페이지, {} 개 씩",page,cnt);
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "dud";
		
		int currPage = Integer.parseInt(page);
		int pagePerCnt = Integer.parseInt(cnt);

		return service.ReserLogList(currPage,pagePerCnt,loginId);
	}
	
	@RequestMapping(value = "/ShopServicePage")
	public ModelAndView ShopServicePage(HttpSession session) {
		logger.info("매장 추가 서비스 설정 페이지");
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "cyw4328";
		
		return service.ShopServicePage(loginId);
	}
	
	@RequestMapping(value = "/addShopSmallService")
	public ModelAndView addShopSmallService(HttpSession session,@RequestParam String inputText1,
			@RequestParam String serviceName1,@RequestParam String busin_num,RedirectAttributes rAttr) {
		logger.info("매장 소형견 서비스추가:{}",busin_num);
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "cyw4328";
		
		return service.addShopSmallService(inputText1,serviceName1,busin_num,rAttr);
	}
	
	@RequestMapping(value = "/addShopMiddleService")
	public ModelAndView addShopMiddleService(HttpSession session,@RequestParam String inputText2,
			@RequestParam String serviceName2,@RequestParam String busin_num,RedirectAttributes rAttr) {
		logger.info("매장 중형견 서비스추가");
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "cyw4328";
		
		return service.addShopMiddleService(inputText2,serviceName2,busin_num,rAttr);
	}
	
	@RequestMapping(value = "/addShopBigService")
	public ModelAndView addShopBigService(HttpSession session,@RequestParam String inputText3,
			@RequestParam String serviceName3,@RequestParam String busin_num,RedirectAttributes rAttr) {
		logger.info("매장 대형견 서비스추가");
		
		//String loginId = (String) session.getAttribute("loginId");
		String loginId = "cyw4328";
		
		return service.addShopBigService(inputText3,serviceName3,busin_num,rAttr);
	}
	
	@RequestMapping(value = "/SreviceDel")
	public ModelAndView SreviceDel(HttpSession session,@RequestParam String price_num,RedirectAttributes rAttr) {
		logger.info("매장 추가 서비스 삭제");
		
		//String loginId = (String) session.getAttribute("loginId");
		//String loginId = "cyw4328";
		
		return service.SreviceDel(price_num,rAttr);
	}
	
}
