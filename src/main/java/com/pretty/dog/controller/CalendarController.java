package com.pretty.dog.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pretty.dog.service.CalendarService;

@Controller
public class CalendarController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired CalendarService service;
	
	//일반 사용자에게 뿌려줄 캘린더 호출
	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public String calendar(Model model) {
		
		return "calendar";
	}
	
	//달력에 날짜를 클릭하면 해당 날짜의 예약 가능 시간 정보를 보여주는 컨트롤러
	@RequestMapping(value = "/dateInfo", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<Object, Object> dateInfo(Model model, @RequestParam HashMap<String, Object> data) {
		
		HashMap<Object, Object> map = service.dateInfo(data);
		//System.out.println(map.size());

		return map;
		
	}
	
	//업주 회원이 예약 설정을 할 수 있는 페이지 로드
	@RequestMapping(value = "/reservationSettings", method = RequestMethod.GET)
	public String reservationSettings(Model model) {
		
		return "reservationSettings";
	}
	
	
	//업주 회원이 설정한 예약 스케쥴 정보를 등록하는 컨트롤러 (하루)
	@RequestMapping(value = "/reservationSave", method = RequestMethod.POST)
	@ResponseBody
	public int reservationSave(Model model, @RequestParam HashMap<String, Object> data) {
		
		//System.out.println(data.get("busin_num"));
		//System.out.println(data.get("set_date"));
		//System.out.println(data.get("set_time"));
		
		return service.oneDaySetting(data);
	}
	
	
	
	@RequestMapping(value = "/holiDay", method = RequestMethod.POST)
	@ResponseBody
	public int holiDay(Model model, @RequestParam HashMap<String, Object> data) {
		
		//System.out.println(data.get("ChoiceDate"));
		
		String holiDayDate = (String) data.get("ChoiceDate");
	
		return service.holiDay(holiDayDate);
	}
	
	
	
	@RequestMapping(value = "/totalReserEx", method = RequestMethod.POST)
	@ResponseBody
	public List<HashMap<String, Object>> totalReserEx(Model model, @RequestParam HashMap<String, Object> data) {
		
		//System.out.println(data.get("busin_num"));
		
		List<HashMap<String, Object>> totalReserEx = service.totalReserEx(data);
		
		//System.out.println(totalReserEx);
		
		return totalReserEx;
	}
	
	
	
	@RequestMapping(value = "/noReserAllDate", method = RequestMethod.POST)
	@ResponseBody
	public int noReserAllDate(Model model, @RequestParam HashMap<String, Object> data) throws Exception {
		
		//System.out.println(data);
		
		Object str = data.get("totalDay");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		
		String totalDate = str.toString();
		int lastInNo = totalDate.length();
		String[] sendTotalDate = totalDate.substring(1, (lastInNo-1)).split(",");
		String busin_num = (String) data.get("busin_num");
		Object set_time = data.get("set_time");
		
		
		for(int i=0; i<sendTotalDate.length; i++) {
			map.put("busin_num", busin_num);
			map.put("set_date", sendTotalDate[i]);
			map.put("set_time", set_time);
			list.add(i, map);
			map = new HashMap<String, Object>();
		}
		
		System.out.println(list);
		
		
		
		return service.noReserAllDate(list);
	}
	
	
	
	
	

}
