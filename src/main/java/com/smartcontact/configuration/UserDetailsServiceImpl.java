package com.smartcontact.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smartcontact.entities.UserEntity;
import com.smartcontact.repositories.UserRepositories;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	private @Autowired UserRepositories userRepoistory;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		UserEntity userEntity = userRepoistory.getUserByUserName(username);
		if(userEntity == null) {
			throw new UsernameNotFoundException("This username not exist in database");
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(userEntity);
		return customUserDetails;
	}

}
