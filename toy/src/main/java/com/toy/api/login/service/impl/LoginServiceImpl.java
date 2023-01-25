package com.toy.api.login.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.api.login.dao.LoginDAO;
import com.toy.api.login.service.LoginService;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDAO dao;
	
	@Override
	public List<Map<String, Object>> getUser() throws SQLException {
		return dao.getUser();
	}
	
}
