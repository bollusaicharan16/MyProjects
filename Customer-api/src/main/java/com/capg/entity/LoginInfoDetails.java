package com.capg.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginInfoDetails implements UserDetails{


	private static final long serialVersionUID = 1L;
	
	@Autowired
	private LoginInfo logininfo;
	
	

	public LoginInfoDetails(LoginInfo logininfo) {
		super();
		this.logininfo = logininfo;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities= new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(logininfo.getRole()));
		return authorities;

	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return logininfo.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return logininfo.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
