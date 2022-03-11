package com.pretty.dog.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pretty.dog.dao.PointManagementDAO;
import com.pretty.dog.dto.DogDTO;

@Service
public class PointManageService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired PointManagementDAO dao;
	
	public ModelAndView pointInsert(String point, String loginId, RedirectAttributes rArrt) {
		
		ModelAndView mav = new ModelAndView();
		
		int row = dao.pointInsert(point,loginId);
		if (row > 0) {
			dao.memPointAdd(point,loginId);
		}
		logger.info("포인트들어갔니?:{}",row);
		rArrt.addFlashAttribute("success", row);
		
		mav.setViewName("redirect:/ShopList");
		
		return mav;
	}

	public ModelAndView pointListPage(String loginId) {
		
		ModelAndView mav = new ModelAndView();
		
		ArrayList<DogDTO> memPoint = dao.memPointSelect(loginId);
		
		mav.addObject("memInfo", memPoint);
		mav.setViewName("cywPointListPage");
		
		
		return mav;
	}

	public HashMap<String, Object> memPointList(int currPage, int pagePerCnt, String loginId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		
		int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
		logger.info("offset:{}",offset);	 
		int totalCount = dao.allCountMemPointList(loginId); 
		logger.info("totalCount:{}",totalCount);	 
		int range = totalCount%pagePerCnt > 0 ? (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
		
		 map.put("pages", range); 
		 map.put("list",dao.memPointList(pagePerCnt,offset,loginId));
		 map.put("totalCount", totalCount);
	 
		return map;
	}
	
	
	
}
