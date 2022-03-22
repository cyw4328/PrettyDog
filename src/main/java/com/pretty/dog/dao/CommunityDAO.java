package com.pretty.dog.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.pretty.dog.dto.CommunityDTO;

public interface CommunityDAO {
	
	/*
	ArrayList<DogDTO> freeList();
	*/
	
	ArrayList<CommunityDTO> categoryList();
	/*
	ArrayList<CommunityDTO> freeSearch(HashMap<String, String> params);
	*/
	int allCount(int catNum);

	 ArrayList<CommunityDTO> listCall(HashMap<String, Object> sendMap);

	int freeWrite(HashMap<String, Object> freeWrite);

	int community_view(String community_boardnum);

	CommunityDTO freeDetail(String community_boardnum);
	
	ArrayList<CommunityDTO> photoList(String community_boardnum);

	int freeDelete(String community_boardnum);

	int freeUpdate(HashMap<String, String> params);
	
	ArrayList<CommunityDTO> commentList(String community_boardnum);
	
	void free_commentDelete(int bcn);
	
	int boardNumOfdelCom(int bcn);
	
	void free_commentWrite(CommunityDTO dto);
	
	void saveFile(int community_boardnum, String oriFileName, String newFileName);
		
	ArrayList<CommunityDTO> declaOp();
		
	ArrayList<CommunityDTO> declalist();
	
	void DeclaSend_post(HashMap<String, Object> params);
	
	CommunityDTO commentDetail(String bcomment_num);
	
	
	ArrayList<CommunityDTO> declalistC();
	
	void DeclaSend_comment(HashMap<String, Object> params);
	
	
	
	
	
	
	


	

	
	
}
