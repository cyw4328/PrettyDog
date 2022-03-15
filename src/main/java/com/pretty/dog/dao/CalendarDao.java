package com.pretty.dog.dao;

import java.util.HashMap;

public interface CalendarDao {

	HashMap<Object, Object> dateInfo(HashMap<String, Object> data);

	int oneDaySetting(HashMap<String, Object> data);

	int holiDay(String holiDayDate);

}
