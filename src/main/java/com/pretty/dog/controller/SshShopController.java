package com.pretty.dog.controller;

import java.util.ArrayList;
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

import com.pretty.dog.service.SshShopListService;

@Controller
public class SshShopController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired SshShopListService sshShopListService;
	
	@RequestMapping(value = "/sshShopList", method = RequestMethod.GET)
	public String sshShopList(Model model) {
		logger.info("shop리스트 페이지 이동");
		ArrayList<HashMap<String,Object>> sshShopList = sshShopListService.sshShopList();
		System.out.println("sshShopList.size()" + sshShopList.size());
		model.addAttribute("sshShopList", sshShopList);
		return "sshShopList";
	}
	
	@RequestMapping(value = "/sshShopDetail", method = RequestMethod.GET)
	public String sshShopDetail(Model model, @RequestParam String idx, @RequestParam String memId) {
		logger.info("sshShopDetail리스트 페이지 이동");
		System.out.println("매장번호" + idx);
		System.out.println("로그인한 아이디"+memId);
		ArrayList<HashMap<String,Object>> sshShopDetail = sshShopListService.sshShopDetail(idx);
		ArrayList<HashMap<String,Object>> sshShopQnaList = sshShopListService.sshShopQnaList(idx);
		ArrayList<HashMap<String,Object>> sshShopQnaIdChk = sshShopListService.sshShopQnaIdChk(memId);
		System.out.println("sshShopQnaIdChk 결과값 : " +  sshShopQnaIdChk.size() );
		model.addAttribute("sshShopDetail", sshShopDetail);
		model.addAttribute("sshShopQnaList", sshShopQnaList);
		model.addAttribute("memId", memId);
		model.addAttribute("sshShopQnaIdChk", sshShopQnaIdChk);
		return "sshShopDetail";
	}
	
	@RequestMapping(value = "/qnaComChk", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> qnaComChk(Model model, @RequestParam HashMap<String, Object> a) {
		System.out.println("여기로 오냐고");
		System.out.println(a.size());
		return null;
	}
}



























































































































