package com.smartcontact.services;



import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.smartcontact.dto.ContactDTO;

public interface ContactService {
	
	public Page<ContactDTO> findContactListByUserId(String userName, Integer Page);
	
	public ContactDTO findContactDetail(Long cid);

	public void deleteContactById(Long cId, String userName);
	
	public boolean  updateContact(ContactDTO contactDTO,MultipartFile file, String  userName);

}
