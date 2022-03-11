package com.pretty.dog.service;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pretty.dog.dao.MembersDAO;

@Service
public class MembersService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired MembersDAO dao;
	
	
	public HashMap<String, Object> joinShs(HashMap<String, String> params) {
		logger.info("일반 회원가입 요청 서비스 도착!!");
		HashMap<String, Object> map = new HashMap<String, Object>();
		int row = dao.joinShs(params);
		map.put("success", row);
		
		return map;
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






	


	
	

	
}
