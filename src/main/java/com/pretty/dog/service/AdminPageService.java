package com.pretty.dog.service;


import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pretty.dog.dao.AdminPageDAO;
import com.pretty.dog.dao.DogDAO;
import com.pretty.dog.dto.DogDTO;

@Service
public class AdminPageService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired AdminPageDAO dao;
	
	//관리자 회원리스트
	public ModelAndView apuserlist2(String loginId) {
		ModelAndView mav = new ModelAndView();
		
		int AdminCheck = dao.AdminPageCheck(loginId);
	  	if (AdminCheck == 1) {
	  		mav.setViewName("APuserList2");
	  	}else {
	  		mav.addObject("loginSuccessAlert", "관리자만 사용할수 있는 페이지입니다.");
	  		mav.setViewName("Main");
	  	}  
		return mav;
	}

	public HashMap<String, Object> apuserlist3(int currPage, int pagePerCnt, String a, int b1, int c1) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		//어디서부터 보여줘야 하는가?
		int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
		logger.info("offset:{}",offset);
		
		int totalCount = dao.apuserlist3Count(a,b1,c1); 
		
		int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
		
		logger.info("총 갯수 : {}",totalCount);
		logger.info("만들수 있는 총 페이지 :{}",range);
		
		map.put("pages", range);
		map.put("list", dao.apuserlist3(pagePerCnt,offset,a,b1,c1));
		
		return map;
	}	
	
/*	public HashMap<String, Object> apuserlist30(int currPage, int pagePerCnt, String a, int b1, int c1) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		logger.info("시발:{}",a);
		logger.info("시발:{}",b1);
		logger.info("시발:{}",c1);
		
		//어디서부터 보여줘야 하는가?
		int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
		logger.info("offset:{}",offset);
		
		int totalCount = dao.apuserlist30Count(a,b1,c1); 
		
		int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
		
		logger.info("총 갯수 : {}",totalCount);
		logger.info("만들수 있는 총 페이지 :{}",range);
		
		map.put("pages", range);
		map.put("list", dao.apuserlist30(pagePerCnt,offset,a,b1,c1));
		
		return map;
	}*/
	
	
	

	public DogDTO detail(String id) {
		
		return dao.detail(id);
	}

	public void userupdate(HashMap<String, String> params) {
		
		String id = params.get("id");
		String state = params.get("state");
		String rank = params.get("rank");
		
		logger.info(id+"/"+state+"/"+rank);
		
		int row = dao.userupdate(id,state,rank);
		logger.info("수정 성공 여부 : "+row);
	}

	public void pointupdate(HashMap<String, String> params, RedirectAttributes rArrt) {
		
		String id = params.get("id");
		String CHpoint = params.get("CHpoint");
		String pointstate = params.get("pointstate");
		
		logger.info(id+"/"+CHpoint+"/"+pointstate);
		int row = dao.pointupdate(id,CHpoint,pointstate);
		if (row > 0) {
			dao.adminPointAdd(id,CHpoint,pointstate);
		}
		rArrt.addFlashAttribute("success", row);
		
		logger.info("수정 성공 여부 : "+row);
	}

	//관리자 매장
	public ModelAndView apshoplist2(String loginId) {
		ModelAndView mav = new ModelAndView();
		
		int AdminCheck = dao.AdminPageCheck(loginId);
	  	if (AdminCheck == 1) {
	  		mav.setViewName("APshopList2");
	  	}else {
	  		mav.addObject("loginSuccessAlert", "관리자만 사용할수 있는 페이지입니다.");
	  		mav.setViewName("Main");
	  	}  
		return mav;
	}

	public HashMap<String, Object> apshoplist3(int currPage, int pagePerCnt, String a, int b1) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		//어디서부터 보여줘야 하는가?
		int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
		logger.info("offset:{}",offset);
		
		int totalCount = dao.apshoplist3Count(a,b1); 
		
		int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
		
		logger.info("총 갯수 : {}",totalCount);
		logger.info("만들수 있는 총 페이지 :{}",range);
		
		map.put("pages", range);
		map.put("list", dao.apshoplist3(pagePerCnt,offset,a,b1));
		
		return map;
	}	

	
	
	
	

	public DogDTO adminshopdetail(String shop) {
		
		return dao.shopdetail(shop);
	}

	public int adminshopdetail2(String shop) {
		
		
		int totalCount = dao.shopdetail2(shop);
		logger.info("totalCount:{}",totalCount);
		
		
		return  totalCount;
	}

	public int adminshopdetail3(String shop) {
		
		int totalCount = dao.shopdetail3(shop);
		logger.info("totalCount:{}",totalCount);
		
		return totalCount;
	}

	public int adminshopmoney(String shop) {
		
		int totalCount = dao.shopmoney(shop);
		logger.info("totalCount:{}",totalCount);
		
		return totalCount;
	}

	
	 public int adminshopmoney2(String shop) {
	  
		int totalCount = dao.shopmoney2(shop);
		logger.info("totalCount:{}",totalCount);
		  
		return totalCount; 
	 }

	public int adminshopmoney3(String shop) {
		
		int totalCount = dao.shopmoney3(shop);
		logger.info("totalCount:{}",totalCount);
		  
		return totalCount; 
	}

	public int adminshopmoney4(String shop) {

		int totalCount = dao.shopmoney4(shop);
		logger.info("totalCount:{}",totalCount);
		  
		return totalCount; 
	}

	public void shopdate(HashMap<String, String> params) {

		
		String shop = params.get("shop");
		String calss = params.get("calss");
		
		logger.info(shop+"/"+calss);
		
		int row = dao.shopdate(shop,calss);
		
		logger.info("수정 성공 여부 : "+row);
		
	}
	
	
	//관리자 포인트
	public ModelAndView appointlist2(String loginId) {
		ModelAndView mav = new ModelAndView();
		
		int AdminCheck = dao.AdminPageCheck(loginId);
	  	if (AdminCheck == 1) {
	  		mav.setViewName("APpointList2");
	  	}else {
	  		mav.addObject("loginSuccessAlert", "관리자만 사용할수 있는 페이지입니다.");
	  		mav.setViewName("Main");
	  	}  
		
		return mav;
	}
	
	public HashMap<String, Object> appointlist3(int currPage, int pagePerCnt) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
		logger.info("offset:{}",offset);
		
		int totalCount = dao.appointlist3Count(); 
		
		int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
		
		logger.info("총 갯수 : {}",totalCount);
		logger.info("만들수 있는 총 페이지 :{}",range);
		
		map.put("pages", range);
		map.put("list", dao.appointlist3(pagePerCnt,offset));
		
		return map;
	}
	
	//관리자 예약
	public ModelAndView apreservelist2(String loginId) {
		
		ModelAndView mav = new ModelAndView();
		
		int AdminCheck = dao.AdminPageCheck(loginId);
	  	if (AdminCheck == 1) {
	  		mav.setViewName("APreserveList2");
	  	}else {
	  		mav.addObject("loginSuccessAlert", "관리자만 사용할수 있는 페이지입니다.");
	  		mav.setViewName("Main");
	  	}  
		
		
		return mav;
	}

	public HashMap<String, Object> apreservelist3(int currPage, int pagePerCnt) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		//어디서부터 보여줘야 하는가?
		int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
		logger.info("offset:{}",offset);
		
		int totalCount = dao.apreservelist3Count(); 
		
		int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
		
		logger.info("총 갯수 : {}",totalCount);
		logger.info("만들수 있는 총 페이지 :{}",range);
		
		map.put("pages", range);
		map.put("list", dao.apreservelist3(pagePerCnt,offset));
		
		return map;
	}



	

	

	

	

	
	
	 
	 

	

	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
}
