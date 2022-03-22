package com.pretty.dog.controller;

import java.util.ArrayList;
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

import com.pretty.dog.dto.DogDTO;
import com.pretty.dog.service.ShopListService;

@Controller
public class ShopListController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired ShopListService service;
	
	
//	@RequestMapping(value = "/ShopList", method = RequestMethod.GET)
//	public ModelAndView home(Model model) {
//		logger.info("메인페이지");
//	return  service.shopList();
//	}
	
	
	/*
	 * @RequestMapping(value = "/addService", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public HashMap<String, Object> addService(Model model){
	 * 
	 * return service.addService(); }
	 */
	
	@RequestMapping(value = {"/shopSerch","/ShopList"})
	public ModelAndView shopSerch(@RequestParam HashMap<String, Object> params) {
		logger.info("검색:{}",params);
		return  service.shopSerch(params);
	}
	
	@RequestMapping(value = "/shopListAjax", method = RequestMethod.POST) 
	public @ResponseBody HashMap<String, Object> AlrimPageList(@RequestParam HashMap<String, Object> params) {
		
		return service.shopSearchAjax(params);
	}
	
/*	@ResponseBody
	@RequestMapping(value = "/updateLike", method = RequestMethod.GET)
	public HashMap<String, Object> updateLike (@RequestParam String busin_num, HttpSession session) {

			HashMap<String, Object> map = new HashMap<String, Object>();
			
			String loginId = (String) session.getAttribute("loginId");
			//String loginId = "dud";
			
			if (loginId != null) {
				int LikeCheck = service.LikeCheck(busin_num, loginId);
				
				if (LikeCheck == 1) {
					service.deleteLike(busin_num, loginId);
					service.CancelBLike(busin_num);
				}else {
					service.insertLike(busin_num, loginId);
					service.updateBLike(busin_num);
				}
				map.put("LikeCheck", LikeCheck);
			} else { 
				map.put("msg", "로그인이 필요한 기능입니다."); 
			}
			
		
		return map;
	}*/
	
	@ResponseBody
	@RequestMapping(value = "/serviceScopeSelect", method = RequestMethod.GET)
	public HashMap<String, Object> serviceScopeSelect (@RequestParam String serviceNum) {
			
		HashMap<String, Object> map = new HashMap<String, Object>();
		logger.info("serviceNum:{}",serviceNum);
		ArrayList<DogDTO> list = service.serviceScopeSelect(serviceNum);
		
		map.put("serviceList", list);
		return map;
	}
	
	

	
	
	
	
}
