package com.pretty.dog.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface SshShopListDAO {

	ArrayList<HashMap<String,Object>> sshShopList();

	ArrayList<HashMap<String, Object>> sshShopDetail(String idx);

	ArrayList<HashMap<String, Object>> sshShopQnaList(String idx);

	ArrayList<HashMap<String, Object>> sshShopQnaIdChk(String memId);

	List<HashMap<String, Object>> qnaComChk(List<String> a);

	void QnaNnswerInsert(String qnaNnswerText, String memId, String qnaDivNum);

	ArrayList<HashMap<String, Object>> sshShopQnaNnswerList();

	void QnaWrite(String qnaText, String memId, String busin_num);

	ArrayList<HashMap<String, Object>> sshShopRevList(String idx);

	void reviewWrite(HashMap<String, Object> reviewWrite);

	void recommendationWrite(int shop_boardnum, String apprai_cont);

	void fileWrite(int shop_boardnum, String oriFileName, String newFileName);

	void baseSaveFile(int shop_boardnum,String sphoto_oriname, String sphoto_newname);

	void deleteSbpNewname(String newFilename);

	void deleteRecommendation(String idx);

	void ReviewDelete(String idx);

	void memberPointUpdate(String memId);

	void pointListInsert(String memId);

	ArrayList<HashMap<String, Object>> revLength(String memId, String idx);

	void reservationUpdate(String reser_num);

	ArrayList<HashMap<String, Object>> sshMyInterestShopList(String memId, String idx);

	ArrayList<HashMap<String, Object>> sshShopDetailTwo(String idx);

	void myShopLikeInsert(String memId, String idx);

	void shopLikeUpdate(String idx);

	void myShopLikeDelete(String memId, String idx);

	void shopLikeDown(String idx);

}
