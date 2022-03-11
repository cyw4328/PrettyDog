package com.pretty.dog.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pretty.dog.dao.CommunityDAO;
import com.pretty.dog.dto.DogDTO;

@Service
public class CommunityService {
	
	@Autowired CommunityDAO communityDao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*
	public ArrayList<DogDTO> freeList() {
		logger.info("리스트 불러오기");				
		return communityDao.freeList();
	}
	*/
	
	//카테고리 불러오기
	public ArrayList<DogDTO> categoryList() {		
		return communityDao.categoryList();
	}
	
	//페이징
	 public HashMap<String, Object> listCall(int currPage, int pagePerCnt) {
	      
	      HashMap<String, Object> map = new HashMap<String, Object>(); 
	      
	      int offset = ((currPage-1) * pagePerCnt-1) >=0 ? ((currPage-1) * pagePerCnt-1) : 0; //어디서부터 보여줘야 하는가?
	      
	      int totalCount = communityDao.allCount();
	      
	      int range = totalCount%pagePerCnt>0?	
	    		  (totalCount/pagePerCnt)+1:(totalCount/pagePerCnt);
	      logger.info("총갯수:{}",totalCount);
	      logger.info("만들 수 있는 총 페이지:{}",range);
	      
	      logger.info("리스트 콜 서비스 : DAO 호출");
	      
	      map.put("pages",range);
	      map.put("list",communityDao.listCall(pagePerCnt, offset));
	      
	      logger.info("Map에 담긴 정보"+map);
	      
	      return map;
	   }
	
	//게시판 검색
	public ModelAndView freeSearch(HashMap<String, String> params) {
		ModelAndView mav = new ModelAndView();
		ArrayList<DogDTO> list = communityDao.freeSearch(params);
		mav.addObject("list", list);
		mav.setViewName("freeList");
		return mav;
	}



	
	
	
	
	
	
	
}
