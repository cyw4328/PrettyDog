package com.pretty.dog.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pretty.dog.dao.CywAdminDAO;
import com.pretty.dog.dto.DogDTO;

@Service
public class CywAdminService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired CywAdminDAO dao;
	
	public ModelAndView categoryPage() {
		ModelAndView mav = new ModelAndView();
		
		/*
		 * ArrayList<DogDTO> list = dao.categoryPage();
		 * 
		 * mav.addObject("list", list);
		 */
		mav.setViewName("cywCateGory");
		
		return mav;
	}

	public HashMap<String, Object> categoryListCall(int currPage, int pagePerCnt) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		//어디서부터 보여줘야 하는가?
		int offset = ((currPage-1) * pagePerCnt-1) >= 0 ? ((currPage-1) * pagePerCnt-1) : 0; 
		logger.info("offset:{}",offset);
		
		int totalCount = dao.categoryListCount(); 
		
		int range = totalCount%pagePerCnt > 0 ?  (totalCount/pagePerCnt+1) : (totalCount/pagePerCnt);
		
		logger.info("총 갯수 : {}",totalCount);
		logger.info("만들수 있는 총 페이지 :{}",range);
		
		map.put("pages", range);
		map.put("list", dao.categoryListCall(pagePerCnt,offset));
		
		return map;
	}

	public ModelAndView cateGoryAdd(String categoryName, String categoryClass, RedirectAttributes rAttr) {
		
		ModelAndView mav = new ModelAndView();
		
		int row = dao.cateGoryAdd(categoryName,categoryClass);
		
		if (row >0) {
			rAttr.addFlashAttribute("msg", "등록이 완료되었습니다.");
			mav.setViewName("redirect:/categoryPage");
		}else {
			rAttr.addFlashAttribute("msg", "등록이 실패했습니다.");
			mav.setViewName("redirect:/categoryPage");
		}
		
		return mav;
	}

	public ModelAndView categoryDel(String category_num, RedirectAttributes rAttr) {
		ModelAndView mav = new ModelAndView();
		
		int row = dao.categoryDel(category_num);
		if (row>0) {
			rAttr.addFlashAttribute("msg1", "삭제에 성공하였습니다.");
			mav.setViewName("redirect:/categoryPage");
		}else {
			rAttr.addFlashAttribute("msg1", "삭제에 실패하였습니다.");
			mav.setViewName("redirect:/categoryPage");
		}
		
		return mav;
	}
	
}
