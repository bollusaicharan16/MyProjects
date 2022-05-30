package com.capg.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.entity.LoginInfo;


public interface LoginRepositiory extends JpaRepository<LoginInfo, Integer>{
	

	LoginInfo findIdByUsername(String username);
}
