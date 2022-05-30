package com.capg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capg.entity.LoginInfo;
import com.capg.entity.LoginInfoDetails;
import com.capg.repositiory.LoginRepositiory;

@Service
public class LoginInfoService implements UserDetailsService{

	@Autowired
	private LoginRepositiory loginrepositiory;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginInfo user =loginrepositiory.findIdByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException(username+ " Does't Exits");
		}
		return new LoginInfoDetails(user);
	}

}
