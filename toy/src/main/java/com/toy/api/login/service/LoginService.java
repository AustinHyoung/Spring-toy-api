package com.toy.api.login.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface LoginService {
	
	public Map<String, Object> getUser(Map<String, Object> ParamMap) throws SQLException;
	
	public List<Map<String, Object>> getUserAll() throws SQLException;
}
