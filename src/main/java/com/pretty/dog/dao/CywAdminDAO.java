package com.pretty.dog.dao;

import java.util.ArrayList;

import com.pretty.dog.dto.DogDTO;

public interface CywAdminDAO {

	/* ArrayList<DogDTO> categoryPage(); */

	int categoryListCount();

	ArrayList<DogDTO> categoryListCall(int pagePerCnt, int offset);

	int cateGoryAdd(String categoryName, String categoryClass);

	int categoryDel(String category_num);

}
