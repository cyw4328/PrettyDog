package com.pretty.dog.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.pretty.dog.dto.DogDTO;

public interface CywAdminDAO {

	/* ArrayList<DogDTO> categoryPage(); */

	int categoryListCount();

	ArrayList<DogDTO> categoryListCall(int pagePerCnt, int offset);

	int cateGoryAdd(String categoryName, String categoryClass);

	int categoryDel(String category_num);

	int AlrimPageListCount(String loginId);

	ArrayList<DogDTO> AlrimPageList(int pagePerCnt, int offset, String of);

	ArrayList<DogDTO> AlarmMem(String loginId);

	int alarmDel(String alarm_num);

	ArrayList<DogDTO> MyBoard(String loginId);

	int MyBoardPageListCount(String loginId);

	ArrayList<DogDTO> MyBoardPageList(int pagePerCnt, int offset, String loginId);

	int boardDel(String community_boardnum, String loginId);

	ArrayList<DogDTO> MyComment(String loginId);

	int CommentPageListCount(String loginId);

	ArrayList<DogDTO> CommentPageList(int pagePerCnt, int offset, String loginId);

	int commentDel(String bcomment_num, String loginId);

	ArrayList<DogDTO> MyLikeShop(String loginId);

	int MyLikeShopListCount(String loginId);

	ArrayList<DogDTO> MyLikeShopList(int pagePerCnt, int offset, String loginId);

	int LikeShopDel(String interestshop_num, String loginId);

	ArrayList<DogDTO> MyPageReserPage(String loginId);

	int MyReserPageListCount(String loginId);

	ArrayList<DogDTO> MyReserPageList(int pagePerCnt, int offset, String loginId);

	int reserDel(String reser_num, String loginId);

	ArrayList<DogDTO> OwnerReserPage(String loginId);

	ArrayList<DogDTO> OwnerReserPageList(int pagePerCnt, int offset, String loginId);

	int OwnerReserPageListCount(String loginId);

	int NoShowChange(String reser_num, String loginId);

	int SuccessChange(String reser_num, String loginId);

	ArrayList<DogDTO> OwnerReserLogPage(String loginId);

	int ReserLogListCount(String loginId);

	ArrayList<DogDTO> ReserLogList(int pagePerCnt, int offset, String loginId);

	HashMap<String, Object> reserData(String reser_num, String loginId);

	int reserLogInsert(HashMap<String, Object> list);

	int reserCancleInsert(HashMap<String, Object> list);

	int OwnerCancleInsert(HashMap<String, Object> list);

	int reserLogNoshow(HashMap<String, Object> list);

	int reserLogSuccess(HashMap<String, Object> list);

	int AlarmInsert(HashMap<String, Object> list);

}
