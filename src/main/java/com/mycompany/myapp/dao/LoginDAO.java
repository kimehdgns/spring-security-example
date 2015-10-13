package com.mycompany.myapp.dao;

import com.mycompany.myapp.model.MemberInfo;

public interface LoginDAO {
	MemberInfo selectMember(String username);
}
