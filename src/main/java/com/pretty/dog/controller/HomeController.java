package com.pretty.dog.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pretty.dog.service.DogService;
import com.pretty.dog.service.HomeService;


@Controller
public class HomeController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired DogService service;
	@Autowired HomeService homeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("메인페이지");
		

		return "Main";
	}
	
	
	@RequestMapping(value = "/idRankChk")
	@ResponseBody
	public HashMap<String, Object> idRankChk(Model model, @RequestParam HashMap<String, Object> loginId) {
		
		//logger.info("아이디 랭크 체크 컨단 도착 : ");
		//System.out.println(loginId);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		

		System.out.println(homeService.idRankChk(loginId));
		
		int rankLoinChk = homeService.idRankChk(loginId).size();
		
		if(rankLoinChk == 0) {
			map.put("loginId", "null");
		}else {
			map.put("mem_rank", homeService.idRankChk(loginId).get(0).get("mem_rank"));
			map.put("loginId", homeService.idRankChk(loginId).get(0).get("mem_id"));
			map.put("mem_point", homeService.idRankChk(loginId).get(0).get("mem_point"));
		}
		

		return map;
	}
	
	
}
