package com.smartcontact.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartcontact.entities.User;
import com.smartcontact.repositories.UserRepositories;
@Service
public class UserServiceImpl implements UserService {
	@Autowired UserRepositories userRepositories;

	
	@Override
	public void save(User user) {
		userRepositories.save(user);
		
	}

}
