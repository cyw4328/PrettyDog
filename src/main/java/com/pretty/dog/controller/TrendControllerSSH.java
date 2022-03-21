package com.pretty.dog.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pretty.dog.service.TrendServiceSSH;


@Controller
public class TrendControllerSSH {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired TrendServiceSSH trendServiceSSH;
	
	@RequestMapping(value = "/beautyTrendWrite", method = RequestMethod.POST)
	// MultipartFile 을 배열 형식으로 받는 이유는 writeForm에서 input타입 설정 할때 멀티플 속성을 사용해서 이다
	// @RequestParam 에서 HashMap<String, String> 을 사용한 이유는 writeForm 에서 받아오는 값이 3개 이상이어서 이다.
	public String beautyTrendWrite(Model model, MultipartFile photos, @RequestParam HashMap<String, Object> params) {
		logger.info("글쓰기 요청 : {}", params);
		logger.info("업로드 할 파일 명 : {}", photos.getOriginalFilename());
		return trendServiceSSH.beautyTrendWrite(params, photos);
	}
	
	@RequestMapping(value = "/beautyTrendWriteForm", method = RequestMethod.GET)
	public String beautyTrendWriteForm(Model model, @RequestParam String mem_id) {
		logger.info("트렌드 게시판 등록 페이지 이동 :  "+ mem_id);
		model.addAttribute("mem_id", mem_id);
		return "beautyTrendWriteForm";
	}
	
	@RequestMapping(value = "/idChk", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> idChk(Model model, @RequestParam String memberId) {
		logger.info("아이디 랭크 체크할 값 : " + memberId);
		System.out.println(memberId);
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<HashMap<String, Object>> memberInfo = trendServiceSSH.idChk(memberId);
		map.put("memberInfo", memberInfo);
		return map;
	}
	
	@RequestMapping(value = "/memberRank1", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> memberRank1(Model model, @RequestParam String memberId) {
		logger.info("아이디 랭크 체크할 값 : " + memberId);
		System.out.println(memberId);
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<HashMap<String, Object>> memberRank = trendServiceSSH.memberRank1(memberId);
		System.out.println("memberRank.size()"+memberRank.size());
		if(memberRank.size() == 0) {
			map.put("community_boardnum", 0);
			return map;
		}
		map.put("memberRank", memberRank);
		return map;
	}
	
	@RequestMapping(value = "/beautyTrendList", method = RequestMethod.GET)
	public String beautyTrendList(Model model) {
		logger.info("트렌드 페이지 이동");
		ArrayList<HashMap<String, Object>> beautyTrendList = trendServiceSSH.beautyTrendList();
		System.out.println(beautyTrendList.size());
		model.addAttribute("beautyTrendList", beautyTrendList);
		System.out.println(beautyTrendList);
		return "beautyTrend";
	}
	
	@RequestMapping(value = "/changeKoMap", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> changeKoMap(Model model, @RequestParam String changeKoMap) {
		logger.info("지역검색");
		logger.info("changeKoMap : "+changeKoMap);
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<HashMap<String, Object>> beautyTrendList = trendServiceSSH.changeKoMap(changeKoMap);
		System.out.println(beautyTrendList.size());
		System.out.println(beautyTrendList);
		map.put("beautyTrendList", beautyTrendList);
		return map;
	}
	
	@RequestMapping(value = "/beautyTrendDetail", method = RequestMethod.GET)
	public ModelAndView beautyTrendDetail(Model model, @RequestParam String idx) {
		logger.info("트렌드 상세보기 : "+ idx);
		return trendServiceSSH.beautyTrendDetail(idx);
	}
	
	@RequestMapping(value = "/beautyTrendUpdate", method = RequestMethod.GET)
	public ModelAndView beautyTrendUpdate(Model model, @RequestParam String idx) {
		logger.info("트렌드 게시글 수정 : "+ idx);
		return trendServiceSSH.beautyTrendUpdate(idx);
	}
	
	
	 @RequestMapping(value = "/trendUpdate")
	 public String trendUpdate(Model model, MultipartFile photos, @RequestParam HashMap<String, String> params) {
		 logger.info("수정 요청 : {}", params);
		 logger.info("업로드 할 파일 수 : {}", photos.getOriginalFilename());
		 return trendServiceSSH.trendUpdate(photos, params); 
	 }
	 
	 @RequestMapping(value = "/beautyTrendDelete")
	 public String beautyTrendDelete(@RequestParam String idx, @RequestParam String newFilename) {
		 System.out.println("삭제 요청 번호 : " + idx);
		 System.out.println("삭제 요청 이미지 이름 : " + newFilename);
		 trendServiceSSH.beautyTrendDelete(idx, newFilename);
		 return "redirect:/beautyTrendList";
	 }
	 
	
}






























































































