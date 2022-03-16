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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pretty.dog.dto.DogDTO;
import com.pretty.dog.service.AdminPageService;



@Controller
public class AdminPageController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired AdminPageService service;
	
	
	//회원 조회 및 관리
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String aphome(Model model, HttpSession session) {
		logger.info("관리자페이지");
		
		ArrayList<DogDTO> userlist = service.userlist();
		model.addAttribute("userlist", userlist);

		return "APuserList";
	}
	
	//회원 상세보기
	@RequestMapping(value="/apuserdetail", method = RequestMethod.GET)
	public String apdetail(Model model,@RequestParam String id) {
		logger.info("클릭한 아이디 : {}",id);
		
		DogDTO dto = service.detail(id);
		model.addAttribute("info", dto);
		
		return "APuserView";
	}
	
	//회원 상태 및 등급 수정
	@RequestMapping(value="/apuserupdate", method = RequestMethod.POST)
	public String apupdate(Model model,@RequestParam HashMap<String, String> params) {
		logger.info("수정 : {}",params);
		
		service.userupdate(params);
		
		return "redirect:/apuserdetail?id="+params.get("id");
	}
	
	//회원 포인트 임의 수정
	@RequestMapping(value="/appointupdate", method = RequestMethod.POST)
	public String appointupdate(Model model,@RequestParam HashMap<String, String> params,RedirectAttributes rArrt) {
		logger.info("포인트 적립 : {}",params);
		
		service.pointupdate(params, rArrt);
		
		return "redirect:/apuserdetail?id="+params.get("id");
	}
	
	
	
	
	
		
		
	
	
	
	
	
	
}
