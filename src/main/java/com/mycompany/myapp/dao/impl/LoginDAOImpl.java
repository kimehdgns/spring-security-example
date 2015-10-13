package com.mycompany.myapp.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.dao.LoginDAO;
import com.mycompany.myapp.model.MemberInfo;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MemberInfo selectMember(String username) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("username", username);
		
		return sqlSession.selectOne("ns_member.select_member_by_user_name", paramMap);
	}

}
