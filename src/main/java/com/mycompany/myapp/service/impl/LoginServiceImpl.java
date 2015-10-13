package com.mycompany.myapp.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mycompany.myapp.dao.LoginDAO;
import com.mycompany.myapp.model.MemberInfo;

public class LoginServiceImpl implements UserDetailsService {

	private LoginDAO loginDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberInfo member = loginDAO.selectMember(username);
		
		if (member == null) {
			throw new UsernameNotFoundException("user: " + username + " not found.");
		}
		
		return member;
	}

	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
}
