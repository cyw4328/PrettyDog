package com.pretty.dog.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pretty.dog.dao.HomeDAO;
import com.pretty.dog.dao.DogDAO;
import com.pretty.dog.dto.DogDTO;

@Service
public class HomeService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired HomeDAO homeDao;
	
	
	public List<HashMap<String, Object>> idRankChk(HashMap<String, Object> loginId) {
		
		return homeDao.idRankChk(loginId);
	}
	
	

	
	
	
	
	
	
	
	
}
