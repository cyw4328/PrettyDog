package com.pretty.dog.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pretty.dog.dao.CalendarDao;

@Service
public class CalendarService {

		Logger logger = LoggerFactory.getLogger(this.getClass());
		@Autowired CalendarDao dao;
		
		public HashMap<Object, Object> dateInfo(HashMap<String, Object> data) {
			
			HashMap<Object, Object> dateInfo = dao.dateInfo(data);
			
			return dateInfo;
		}

		public int oneDaySetting(HashMap<String, Object> data) {
			
			return dao.oneDaySetting(data);
		}

		public int holiDay(String holiDayDate) {
			
			return dao.holiDay(holiDayDate);
		}

		public List<HashMap<String, Object>> totalReserEx(HashMap<String, Object> data) {
			
			System.out.println(data);
			
			return dao.totalReserEx(data);
		}

		public int noReserAllDate(List<HashMap<String, Object>> list) {
			
			return dao.noReserAllDate(list);
		}

	
		
}
