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
}
