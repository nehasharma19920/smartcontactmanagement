package com.smartcontact.services;



import org.springframework.web.multipart.MultipartFile;

import com.smartcontact.dto.ContactDTO;
import com.smartcontact.dto.UserDTO;
import com.smartcontact.entities.UserEntity;

public interface UserService {
	
	public UserDTO save(UserDTO userDTO);
	
	public UserDTO getUserDetailsByUserName(String username);

	public boolean saveContact(String userName, MultipartFile file,  ContactDTO contactdto);
	public boolean  update(UserDTO userDTO,MultipartFile file);

	public boolean deleteUser(String name);


}
