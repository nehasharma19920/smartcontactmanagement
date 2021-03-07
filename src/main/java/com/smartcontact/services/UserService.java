package com.smartcontact.services;

import org.springframework.web.multipart.MultipartFile;

import com.smartcontact.dto.ContactDTO;
import com.smartcontact.dto.UserDTO;

public interface UserService {
	
	public UserDTO save(UserDTO userDTO);
	
	public UserDTO getUserDetailsByUserName(String username);

	public boolean saveContact(String userName, MultipartFile file,  ContactDTO contactdto);

}
