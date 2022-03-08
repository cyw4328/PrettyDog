package com.pretty.dog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pretty.dog.service.DogService;


@Controller
public class HomeController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired DogService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("메인페이지");
		

		return "Main";
	}
	
}
