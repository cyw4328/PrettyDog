package com.pretty.dog.dao;

import java.util.ArrayList;

import com.pretty.dog.dto.DogDTO;

public interface PointManagementDAO {

	int pointInsert(String point, String loginId);

	void memPointAdd(String point, String loginId);

	ArrayList<DogDTO> memPointSelect(String loginId);

	int allCountMemPointList(String loginId);

	ArrayList<DogDTO> memPointList(int pagePerCnt, int offset, String loginId);
	
	

}
