package com.pretty.dog.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface SshShopListDAO {

	ArrayList<HashMap<String,Object>> sshShopList();

	ArrayList<HashMap<String, Object>> sshShopDetail(String idx);

	ArrayList<HashMap<String, Object>> sshShopQnaList(String idx);

	ArrayList<HashMap<String, Object>> sshShopQnaIdChk(String memId);

}
