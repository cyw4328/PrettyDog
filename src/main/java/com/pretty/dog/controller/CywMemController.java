package com.pretty.dog.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pretty.dog.service.CywMemService;

@Controller
public class CywMemController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired CywMemService service;
	
	@PostMapping(value = "/login")
	public ModelAndView login(@RequestParam String idInput,@RequestParam String pwInput,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		


		if (service.login(idInput,pwInput)) {
			mav.addObject("msg", "로그인이 성공했습니다!");
			mav.setViewName("cywShopList");
			session.setAttribute("loginId", idInput);
		}else {
			mav.addObject("msg", "로그인 정보를 확인해 주세요.");
			mav.setViewName("cywLogin");
			
		}
		
		return mav;
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/idSearchPage")
	public String idSearchPage(Model model,HttpSession session) {
		logger.info("아이디찾기페이지");

		return "cywIDSearch";
	}

	@ResponseBody
	@RequestMapping(value = "/idSearch", method = RequestMethod.POST)
	public HashMap<String, Object> idSearch (@RequestParam String name,@RequestParam String email, HttpSession session) {
					
		return service.idSearch(name,email);
	}
	@RequestMapping(value = "/pwSearchPage")
	public String pwSearchPage(Model model,HttpSession session) {
		logger.info("비밀번호찾기페이지");

		return "cywPwSearch";
	}
	
	@RequestMapping(value = "/PwS")  
	public ModelAndView PwS(@RequestParam String userId,@RequestParam String userName,@RequestParam String userPhone,@RequestParam String userEmail) {
		logger.info("비밀번호찾기");

		return service.pwSearch(userId,userName,userPhone,userEmail);
	}
	
	@RequestMapping(value = "/PwChange")  
	public ModelAndView PwChange(@RequestParam String Id,@RequestParam String pwInput,@RequestParam String pwcheck) {
		logger.info("비밀번호바꾸기");

		return service.pwChange(Id,pwInput,pwcheck);
	}
	
	
}
