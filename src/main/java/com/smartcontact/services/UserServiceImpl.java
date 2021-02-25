package com.smartcontact.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartcontact.dto.UserDTO;
import com.smartcontact.entities.UserEntity;
import com.smartcontact.repositories.UserRepositories;
@Service
public class UserServiceImpl implements UserService {
	@Autowired UserRepositories userRepositories;

	
	@Override
	public UserDTO save(UserDTO userDTO) {
		
		return UserDTO.of(userRepositories.save(UserEntity.of(userDTO)));
		
	}

}
