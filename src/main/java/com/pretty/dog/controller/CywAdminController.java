package com.pretty.dog.controller;

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
	
	
	
	
}
