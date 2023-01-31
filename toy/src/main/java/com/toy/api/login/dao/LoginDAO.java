package com.toy.api.login.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LoginDAO {
	@Autowired
	private SqlSession sqlSession;
	
	
	@Transactional
	public Map<String, Object> getUser(Map<String, Object> paramMap) throws SQLException {
		return (Map<String, Object>)sqlSession.selectOne("LoginDAO.getUser", paramMap);
	}
	
	@Transactional
	public List<Map<String, Object>> getUserAll() throws SQLException {
		return sqlSession.selectList("LoginDAO.getUserAll");
	}

}
