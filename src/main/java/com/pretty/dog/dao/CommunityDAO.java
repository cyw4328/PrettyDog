package com.pretty.dog.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.pretty.dog.dto.CommunityDTO;
import com.pretty.dog.dto.DogDTO;

public interface CommunityDAO {
	
	/*
	ArrayList<DogDTO> freeList();
	*/
	
	ArrayList<CommunityDTO> categoryList();
	/*
	ArrayList<CommunityDTO> freeSearch(HashMap<String, String> params);
	*/
	int allCount(int catNum);

	 ArrayList<CommunityDTO> listCall(int pagePerCnt, int offset, int catNum);

	void freeWrite(HashMap<String, Object> freeWrite);

	void fileWrite(int idx, String oriFileName, String newFileName);

	int community_view(String community_boardnum);

	CommunityDTO detail(String community_boardnum);

	ArrayList<CommunityDTO> photoList(String community_boardnum);

	int freeDelete(String community_boardnum);

	int freeUpdate(HashMap<String, String> params);


	

	
	
}
