package com.pretty.dog.dao;

import java.util.HashMap;

import com.pretty.dog.dto.DogDTO;

public interface MembersDAO {

	int joinShs(HashMap<String, String> params);

	String overlayShsid(String id);

	int ShopjoinShs(HashMap<String, String> params);

	int ShopInfo(HashMap<String, String> params);

	int shopPhoto(String shopSaup, String oriFileName, String newFileName);

	String PassCk(String id, String pw);

	DogDTO memberDe(String id);

}
