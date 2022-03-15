package com.pretty.dog.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pretty.dog.dao.CywMemDAO;
import com.pretty.dog.dto.DogDTO;

@Service
public class CywMemService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired CywMemDAO dao;
	
	public boolean login(String idInput, String pwInput) {
		
		boolean success = false;
		//1.
		String enc_pw = dao.login(idInput);
		
		if (enc_pw != null) {
			//2.
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			success = encoder.matches(pwInput, enc_pw);			
		}
		
		return success;
	}

	public HashMap<String, Object> idSearch(String name, String email) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		ArrayList<DogDTO> list = dao.idSearch(name,email);
		
		map.put("list", list);
		
		return map;
	}

	public ModelAndView pwSearch(String userId, String userName, String userPhone, String userEmail) {
		ModelAndView mav = new ModelAndView();
		int success = dao.pwSearch(userId,userName,userPhone,userEmail); 
		
		logger.info("success:{}",success);
		
		if (success > 0) {
			mav.addObject("loginId", userId);
			mav.setViewName("cywPwChange");
		}else {
			mav.addObject("msg", "일치하는 정보가 없습니다.");
			mav.setViewName("cywPwSearch");
		}
		
		return mav;
	}

	public ModelAndView pwChange(String id, String pwInput, String pwcheck) {
		ModelAndView mav = new ModelAndView();
		
		int row = dao.pwChange(id,pwInput);
		
		logger.info("row:{}",row);
		if (row >0) {
			mav.addObject("msg1", "비밀번호 재설정이 되었습니다.");
			mav.setViewName("cywLogin");
		}else {
			mav.addObject("loginId", id);
			mav.setViewName("cywPwChange");
		}
		
		return mav;
	}
	
}
