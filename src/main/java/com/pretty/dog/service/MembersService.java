package com.pretty.dog.service;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pretty.dog.dao.MembersDAO;
import com.pretty.dog.dto.DogDTO;

@Service
public class MembersService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired MembersDAO dao;
	
	public int joinShs(String id, String hashText, String name, String phone, String email) {
		
		return dao.joinShs(id,hashText,name,phone,email);
	}
	
	
	public int ShopjoinShs(String id, String hashText, String name, String phone, String email) {
		
		return dao.ShopjoinShs(id,hashText,name,phone,email);
	}
	
	
	public HashMap<String, Object> ShopjoinShs(HashMap<String, String> params) {
		logger.info("점주 회원가입 요청 서비스 도착!!");
		HashMap<String, Object> map = new HashMap<String, Object>();
		int row = dao.ShopjoinShs(params);
		map.put("success", row);
		
		return map;
	}
	
	
	public HashMap<String, Object> overlayShsid(String id) {
		logger.info("중복체크 서비스 도착!!");
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		String overlayShsid = dao.overlayShsid(id);
		logger.info("중복 아이디 여부 : {}",overlayShsid);		
		boolean overlayid = overlayShsid == null ? false : true;		
		map.put("overlay", overlayid);		
		return map;
	}


	public void ShopInfo(MultipartFile shopPhoto, HashMap<String, String> params, String shopSaup) {
		logger.info("ShopInfo 서비스 도착!!");
		HashMap<String, Object> map = new HashMap<String, Object>();
		int row = dao.ShopInfo(params);
		logger.info("성공{}",row);
		
		try {
			String oriFileName = shopPhoto.getOriginalFilename();
			int index = oriFileName.lastIndexOf(".");
			logger.info("index : {}",index);
			
			if(index>0) {
				String ext = oriFileName.substring(index);
				String newFileName = System.currentTimeMillis()+ext;
				logger.info(oriFileName+" => "+newFileName);
				
				byte[] bytes =shopPhoto.getBytes();
				Path path = Paths.get("C:/dogupload/"+newFileName);
				
				Files.write(path, bytes);
				logger.info(oriFileName+"save OK!!");
				dao.shopPhoto(shopSaup,oriFileName,newFileName);
			}
			Thread.sleep(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public String PassCk(String id, String pw) {
		logger.info("비밀번호체크 서비스 도착{}",id+pw);	
		return dao.PassCk(id,pw);
	}



	public DogDTO MyjungboSujungshs(String id) {
		logger.info("회원정보 서비스 도착");
		
		return dao.MyjungboSujungshs(id);
	}


	public DogDTO MyShopInfoshs(String id) {
		
		return  dao.MyShopInfoshs(id);
	}


	public int DogUp(String id, String dogname, String dogage, String dogweight, String dogchar) {
		
		
		return dao.DogUp(id,dogname,dogage,dogweight,dogchar);

	}


	public ModelAndView Mydogshs(String id) {
		
		ModelAndView mav = new ModelAndView();
		
		ArrayList<DogDTO> list = dao.Mydogshs(id);
		logger.info("size",list.size());
		mav.addObject("size",list.size());
		mav.addObject("list",list);
		
		mav.setViewName("Mydogshs");
		
		return mav;
	}


	public int DogDel(String id, String dogName) {
		
			logger.info("DogDel 서비스 도착");
		
			int delcnt = dao.DogDel(id,dogName);
			logger.info("삭제 성공 수 : {}",delcnt);
		return delcnt;
	}


	public DogDTO MyDogsujungshs(String id, String dogName) {
		logger.info(" 강아지 수정 폼 서비스 : {}",id+"/"+dogName);
		return dao.MyDogsujungshs(id,dogName);
	}


	public int DogSujung(String id, String dogname, String dogage, String dogweight, String dogchar) {
		int row = dao.DogSujung(id,dogname,dogage,dogweight,dogchar);
		
		return row;
	}


	public void memberOut(String id) {
		logger.info("회원탈퇴 서비스 도착 : {}",id );
		int memOutCnt = dao.memberOut(id);
	}


	public HashMap<String, Object> shopSaupCk(String shopSaup) {
		
		logger.info("사업자중복체크 서비스 도착!!");
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		String shopSaupCk = dao.shopSaupCk(shopSaup);
		logger.info("중복 아이디 여부 : {}",shopSaupCk);		
		boolean overlaySaup = shopSaupCk == null ? false : true;		
		map.put("shopSaup", overlaySaup);		
		return map;
	}


	public void userUp(HashMap<String, String> params) {
		String hashText = "";
		String pw = params.get("pw"); 
		
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		hashText = encoder.encode(pw);
		params.put("pw", hashText);

		
		int row = dao.userUp(params);
		logger.info("입력된 건수  : {}",row);
		
	}








	


	






	


	
	

	
}
