package com.pretty.dog.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.pretty.dog.dto.DogDTO;

public interface CommunityDAO {
	
	/*
	ArrayList<DogDTO> freeList();
	*/
	
	ArrayList<DogDTO> categoryList();
	
	ArrayList<DogDTO> freeSearch(HashMap<String, String> params);

	int allCount();

	 ArrayList<DogDTO> listCall(int pagePerCnt, int offset);


	

	
	
}
