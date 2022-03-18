package com.pretty.dog.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface CalendarDao {

	HashMap<Object, Object> dateInfo(HashMap<String, Object> data);

	int oneDaySetting(HashMap<String, Object> data);

	int holiDay(String holiDayDate);

	List<HashMap<String, Object>> totalReserEx(HashMap<String, Object> data);

	int noReserAllDate(List<HashMap<String, Object>> list);

	void delDate(List<HashMap<String,Object>> list);



}
