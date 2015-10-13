package com.mycompany.myapp.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mycompany.myapp.dao.LoginDAO;
import com.mycompany.myapp.model.MemberInfo;

public class LoginDAOImpl implements LoginDAO {

	private SqlSession sqlSession;
	
	@Override
	public MemberInfo selectMember(String username) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("username", username);
		
		return sqlSession.selectOne("ns_member.select_member_by_user_name", paramMap);
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
