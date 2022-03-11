package com.pretty.dog.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.pretty.dog.dto.DogDTO;

public interface ShopListDAO {

	/* ArrayList<DogDTO> addService(); */

	/* ArrayList<DogDTO> shopList(); */

	ArrayList<DogDTO> shopSerch(HashMap<String, Object> params);

	int LikeCheck(String busin_num, String mem_id);

	void deleteLike(String busin_num, String loginId);

	void CancelBLike(String busin_num);

	void insertLike(String busin_num, String loginId);

	void updateBLike(String busin_num);

	ArrayList<String> addservice();

}
