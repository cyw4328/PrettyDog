package com.pretty.dog.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pretty.dog.dao.ShopListDAO;
import com.pretty.dog.dto.DogDTO;

@Service
public class ShopListService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired ShopListDAO dao;
	
	
	public static final String SELECT_AREA_SCOPE = "서울특별시,경기도,인천광역시,대전광역시,광주광역시,대구광역시,울산광역시,부산광역시,강원도,충청북도,충청남도,전라북도,전라남도,경상북도,경상남도,제주도";
	public static final String SELECT_DOG_SCOPE = "소형견,중형견,대형견";
	
	
	/*
	 * public HashMap<String, Object> addService() { HashMap<String, Object> map =
	 * new HashMap<String, Object>();
	 * 
	 * ArrayList<DogDTO> list = dao.addService(); logger.info("service:{}",list);
	 * 
	 * map.put("list", list);
	 * 
	 * return map; }
	 */

//	public ModelAndView shopList() {
//		
//		ModelAndView mav = new ModelAndView();
//		
//		ArrayList<DogDTO> list = dao.shopList();
//		logger.info("서비스 :{}",list);
//		logger.info("서비스사이즈 :{}",list.size());
//		mav.addObject("size", list.size());
//		mav.addObject("shopList", list);
//		/* JiBin Start */
//		mav.addObject("selectAreaScope",SELECT_AREA_SCOPE);
//		mav.addObject("selectDogScope",SELECT_DOG_SCOPE);
//		/* JiBin End */
//		mav.setViewName("ShopList");
//		
//		
//		return mav;	
//	}

	public ModelAndView shopSerch(HashMap<String, Object> params) {
		logger.info("params:{}",params);
		ModelAndView mav = new ModelAndView();
		
		ArrayList<DogDTO> list = dao.shopSerch(params);
		mav.addObject("shopList", list);
		logger.info("서비스사이즈 :{}",list.size());
		ArrayList<String> addservice = dao.addservice();

		mav.addObject("selectAreaScope",SELECT_AREA_SCOPE);
		mav.addObject("selectDogScope",SELECT_DOG_SCOPE);
		mav.addObject("selectServiceScope", addservice);
		mav.addObject("params", params);

		/* mav.addObject("msg", "선택한 조건에 따른 검색결과입니다."); */
		mav.setViewName("cywShopList");
		
		return mav;
	}


	public int LikeCheck(String busin_num, String mem_id) {
		
		return dao.LikeCheck(busin_num, mem_id);
	}

	public void deleteLike(String busin_num, String loginId) {
		dao.deleteLike(busin_num, loginId);
	}

	public void CancelBLike(String busin_num) {
		dao.CancelBLike(busin_num);
	}

	public void insertLike(String busin_num, String loginId) {
		dao.insertLike(busin_num, loginId);
		
	}

	public void updateBLike(String busin_num) {
		dao.updateBLike(busin_num);
		
	}


	
	
}
