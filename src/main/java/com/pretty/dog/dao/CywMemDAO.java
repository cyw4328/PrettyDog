package com.pretty.dog.dao;

import java.util.ArrayList;

import com.pretty.dog.dto.DogDTO;

public interface CywMemDAO {

	String login(String idInput);

	ArrayList<DogDTO> idSearch(String name, String email);

	int pwSearch(String userId, String userName, String userPhone, String userEmail);

	int pwChange(String id, String pwInput);

}
