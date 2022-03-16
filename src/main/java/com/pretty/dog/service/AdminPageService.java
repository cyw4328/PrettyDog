package com.pretty.dog.service;


import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pretty.dog.dao.AdminPageDAO;
import com.pretty.dog.dao.DogDAO;
import com.pretty.dog.dto.DogDTO;

@Service
public class AdminPageService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired AdminPageDAO dao;
	
	public ArrayList<DogDTO> userlist() {
		
		ArrayList<DogDTO> userlist = null;
		userlist = dao.userlist();
		logger.info("size : {}",userlist.size());
		return userlist;
	}

	public DogDTO detail(String id) {
		
		return dao.detail(id);
	}

	public void userupdate(HashMap<String, String> params) {
		
		String id = params.get("id");
		String state = params.get("state");
		String rank = params.get("rank");
		
		logger.info(id+"/"+state+"/"+rank);
		
		int row = dao.userupdate(id,state,rank);
		logger.info("수정 성공 여부 : "+row);
	}

	public void pointupdate(HashMap<String, String> params, RedirectAttributes rArrt) {
		
		
		String id = params.get("id");
		String CHpoint = params.get("CHpoint");
		String pointstate = params.get("pointstate");
		
		logger.info(id+"/"+CHpoint+"/"+pointstate);
		int row = dao.pointupdate(id,CHpoint,pointstate);
		if (row > 0) {
			dao.adminPointAdd(id,CHpoint,pointstate);
		}
		rArrt.addFlashAttribute("success", row);
		

		logger.info("수정 성공 여부 : "+row);
		
		
		
	}

	

	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
}
