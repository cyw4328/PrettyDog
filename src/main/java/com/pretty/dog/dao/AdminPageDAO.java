package com.pretty.dog.dao;

import java.util.ArrayList;

import com.pretty.dog.dto.DogDTO;

public interface AdminPageDAO {
	
	//관리자 회원리스트
	int apuserlist3Count(String a, int b1, int c1);

	ArrayList<DogDTO> apuserlist3(int pagePerCnt, int offset, String a, int b1, int c1);
	
	

	DogDTO detail(String id);

	int userupdate(String id, String state, String rank);

	int pointupdate(String id, String CHpoint, String pointstate);

	void adminPointAdd(String id, String cHpoint, String pointstate);
	
	//관리자 매장
	int apshoplist3Count(String a, int b1);

	ArrayList<DogDTO> apshoplist3(int pagePerCnt, int offset, String a, int b1);
	

	DogDTO shopdetail(String shop);

	int shopdetail2(String shop);

	int shopdetail3(String shop);

	int shopmoney(String shop);

	int shopmoney2(String shop);

	int shopmoney3(String shop);

	int shopmoney4(String shop);

	int shopdate(String shop, String calss);
	
	//관리자 포인트
	int appointlist3Count();
	
	ArrayList<DogDTO> appointlist3(int pagePerCnt, int offset);
	
	//관리자 예약
	int apreservelist3Count();

	ArrayList<DogDTO> apreservelist3(int pagePerCnt, int offset);

	/*
	 * int apuserlist30Count(String a, int b1, int c1);
	 * 
	 * ArrayList<DogDTO> apuserlist30(int pagePerCnt, int offset, String a, int b1,
	 * int c1);
	 */
	
	
	//회원 검색
	

	



	

	



	

	

	

}
