package com.pretty.dog.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.pretty.dog.dto.CommunityDTO;

public interface CommunityDAO {
	
	
	
	ArrayList<CommunityDTO> categoryList();// 카테고리 출력
	
	int allCount(int catNum);

	 ArrayList<CommunityDTO> listCall(HashMap<String, Object> sendMap);//리스트 출력

	int freeWrite(HashMap<String, Object> freeWrite);//게시물 작성

	int community_view(String community_boardnum);//조회수 갱신

	CommunityDTO freeDetail(String community_boardnum);//상세보기
	
	ArrayList<CommunityDTO> photoList(String community_boardnum);//상세보기 이미지 출력

	int freeDelete(String community_boardnum);//게시물삭제

	int freeUpdate(HashMap<String, String> params);//게시물 수정
	
	void free_imgDelete(String newFileName);//기존 이미지 삭제
	
	ArrayList<CommunityDTO> commentList(String community_boardnum);//댓글목록 출력
	
	void free_commentDelete(int bcn);//댓글삭제
	
	int boardNumOfdelCom(int bcn);//댓글번호 찾기
	
	void free_commentWrite(CommunityDTO dto);//삭제 위한 댓글 번호 찾아오기
	
	void saveFile(int community_boardnum, String oriFileName, String newFileName);//사진파일 저장
		
	ArrayList<CommunityDTO> declaOp();//신고사항 출력
		
	ArrayList<CommunityDTO> declalist();//신고 정보 출력(게시글)
	
	void DeclaSend_post(HashMap<String, Object> params);//게시글 신고
	
	CommunityDTO commentDetail(String bcomment_num);//댓글신고 위한 댓글 상세정보 출력
	
	
	ArrayList<CommunityDTO> declalistC();//신고정보(댓글)
	
	void DeclaSend_comment(HashMap<String, Object> params);//댓글 신고
	
	
	
	
	
	
	
	
	
	


	

	
	
}
