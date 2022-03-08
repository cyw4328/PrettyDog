package com.pretty.dog.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pretty.dog.dao.DogDAO;

@Service
public class DogService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired DogDAO dao;
	
}
