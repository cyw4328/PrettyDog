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

	
	// 마이페이지 ==--------------------------------------------------------
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

	// -----------------------------------------------------------------
	
	int SingoHangmokListCount();

	ArrayList<DogDTO> SingoHangmokList(int pagePerCnt, int offset);

	int SingoHangmokAdd(String singoSub);

	int HangmokReUse(String decO_num);

	int HangmokDel(String decO_num);

	int SingoNoCheckListCount();

	ArrayList<DogDTO> SingoNoCheckList(int pagePerCnt, int offset);

	int SingoProcess(String decl_num);

	int decAdminInsert(String decl_num, String loginId);

	int SingoProcessListCount();

	ArrayList<DogDTO> SingoProcessList(int pagePerCnt, int offset);

	int ServiceHangmokListCount();

	ArrayList<DogDTO> ServiceHangmokList(int pagePerCnt, int offset);

	int UseServiceChange(String add_num);

	int NoUseServiceChange(String add_num);

	int ServiceHangmokAdd(String serviceDog, String serviceSub);

	int reserDelMemPointAdd(String loginId, String reser_money);

	int reserDelMemPointTable(String loginId, String reser_money);

	int reserDelOwnerPointDel(String reser_money, String busin_num);

	int reserDelOwnerPointTable(String reser_money, String busin_num);

	int NoShopNoPoint(String busin_num, String reser_num, String reser_money);

	int NoShowPointAdd(String busin_num, String reser_money);

	int UseSuccessNoPoint(String busin_num, String reser_num, String reser_money);

	int UseSuccessPointAdd(String busin_num, String reser_money);

}
