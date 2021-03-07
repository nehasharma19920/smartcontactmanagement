package com.smartcontact.services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.smartcontact.dto.ContactDTO;
import com.smartcontact.dto.UserDTO;
import com.smartcontact.entities.ContactEntity;
import com.smartcontact.entities.UserEntity;
import com.smartcontact.repositories.UserRepositories;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepositories userRepositories;

	@Override
	public UserDTO save(UserDTO userDTO) {

		return UserDTO.of(userRepositories.save(UserEntity.of(userDTO)));

	}

	@Override
	public UserDTO getUserDetailsByUserName(String username) {
		// TODO Auto-generated method stub
		return UserDTO.of(userRepositories.getUserByUserName(username));
	}

	@Override
	public boolean saveContact(String username, MultipartFile file, ContactDTO contactdto) {
		UserEntity userEntity = userRepositories.getUserByUserName(username);
		ContactEntity contactEntity = ContactEntity.of(contactdto);
		contactEntity.setUser(userEntity);
		try {

			if (file.isEmpty()) {
				System.out.println("file is empty");
			} else {

				String fileName = file.getOriginalFilename() + System.currentTimeMillis();
				contactEntity.setImage(fileName);
				File saveFile = new ClassPathResource("static/img").getFile();
				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				System.out.println("File uploaded");
				userEntity.getContactList().add(contactEntity);
				userRepositories.save(userEntity);

			}
		} catch (Exception e) {
			return false;

		}
	
		return true;
	}

}
