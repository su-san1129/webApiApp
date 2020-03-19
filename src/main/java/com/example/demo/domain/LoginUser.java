package com.example.demo.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class LoginUser extends User {
	
	private static final long serialVersionUID = 1L;
	
	private final com.example.demo.domain.User user;
	
	public LoginUser(com.example.demo.domain.User user, Collection<GrantedAuthority> authorityList) {
		super(user.getEmail(), user.getPassword(), authorityList);
		this.user = user;
	}

	public com.example.demo.domain.User getUser() {
		return user;
	}

	

}
