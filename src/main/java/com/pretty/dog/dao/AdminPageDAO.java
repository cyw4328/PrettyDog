package com.pretty.dog.dao;

import java.util.ArrayList;

import com.pretty.dog.dto.DogDTO;

public interface AdminPageDAO {

	ArrayList<DogDTO> userlist();

	DogDTO detail(String id);

	int userupdate(String id, String state, String rank);

	int pointupdate(String id, String CHpoint, String pointstate);

	void adminPointAdd(String id, String cHpoint, String pointstate);

	

}
