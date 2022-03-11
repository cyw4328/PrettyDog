package com.pretty.dog.controller;

import java.util.ArrayList;
import java.util.HashMap;

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

import com.pretty.dog.dto.DogDTO;
import com.pretty.dog.service.CommunityService;

@Controller
public class CommnityController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired CommunityService communityService;
	
	
	/*
	@RequestMapping(value = {"/freeList","/categoryList"}, method = RequestMethod.GET)
	public String freeList(Model model) {
		logger.info("list열기" );
		ArrayList<DogDTO> arr1 = communityService.freeList();
		ArrayList<DogDTO> arr2 = communityService.categoryList();
		logger.info("게시물 수: {}",arr1.size());
		model.addAttribute("size",arr1.size());
		model.addAttribute("list",arr1);
		model.addAttribute("category",arr2);
		return "freeList";	
	}
	*/
	
	@RequestMapping(value =  {"/freeList","/categoryList"}, method = RequestMethod.GET)
	   public String home(Model model) {
	      logger.info("리스트 페이지로 이동");
	      ArrayList<DogDTO> arr = communityService.categoryList();
	      model.addAttribute("category",arr);
	      return "freeList";
	   }
	
	   @RequestMapping(value="/listCall", method = RequestMethod.GET)
	   @ResponseBody
	   public HashMap<String, Object> listCall(@RequestParam String page, @RequestParam String cnt) {
	      logger.info("리스트 요청 : {} 페이지, {} 개씩",page,cnt);
	      
	      int currPage = Integer.parseInt(page);
	      int pagePerCnt = Integer.parseInt(cnt);
	      
	      logger.info("현재 페이지 "+currPage+" / 페이지 갯수"+pagePerCnt);
	      
	      HashMap<String, Object> map = new HashMap<String, Object>();

	      map = communityService.listCall(currPage,pagePerCnt);
	      return map;
	   }
	
	
	
	@RequestMapping(value = "/freeSearch")
	   public ModelAndView freeSearch(@RequestParam HashMap<String, String> params) {

	      logger.info("검색 요청");
	      logger.info("params:{}",params);
	      
	      return communityService.freeSearch(params);
	   }
	   
	
	
	
	
}
