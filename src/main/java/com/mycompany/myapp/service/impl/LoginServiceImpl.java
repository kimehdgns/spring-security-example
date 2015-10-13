package com.mycompany.myapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.dao.LoginDAO;
import com.mycompany.myapp.model.MemberInfo;

@Service
public class LoginServiceImpl implements UserDetailsService {

	@Autowired
	private LoginDAO loginDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberInfo member = loginDAO.selectMember(username);
		
		if (member == null) {
			throw new UsernameNotFoundException("user: " + username + " not found.");
		}
		
		return member;
	}

}
