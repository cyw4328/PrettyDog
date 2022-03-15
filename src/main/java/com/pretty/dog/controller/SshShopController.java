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
	public String sshShopDetail(Model model, @RequestParam String idx) {
		logger.info("sshShopDetail리스트 페이지 이동");
		System.out.println("매장번호" + idx);
		ArrayList<HashMap<String,Object>> sshShopDetail = sshShopListService.sshShopDetail(idx);
		model.addAttribute("sshShopDetail", sshShopDetail);
		return "sshShopDetail";
	}
}



























































































































