package com.smartcontact.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smartcontact.dto.UserDTO;
import com.smartcontact.entities.ContactEntity;
import com.smartcontact.entities.UserEntity;
import com.smartcontact.helper.Message;
import com.smartcontact.repositories.UserRepositories;
import com.smartcontact.dto.ContactDTO;
import com.smartcontact.services.UserService;

@Controller
@RequestMapping(value ="/user")
public class UserController {
	
	@Autowired private UserService userService;

	
@RequestMapping(value = "/index")
public String  dashboard(Model model , Principal principle ) {
	
	return "normal/user_dashboard";
	
}

@ModelAttribute
public void commonData(Model model ,Principal principle) {
	String username = principle.getName();
	System.out.println("Username "+username);
	UserDTO userDTO = userService.getUserDetailsByUserName(username);
	model.addAttribute("userDTO", userDTO);
	
}
@GetMapping(value ="/add_contact")
public String openAddContactForm(Model model) {
	model.addAttribute("contact", new ContactDTO());
	return "normal/add_contact";
	
}


@PostMapping(value ="/process_contact")
public String addContact(@ModelAttribute ContactDTO contactdto  ,@RequestParam("profileImage") MultipartFile file, Principal principle,HttpSession session) {
	System.out.println(contactdto);
	
	String userName = principle.getName();
	boolean value = userService.saveContact(userName,file, contactdto);
	if(value) {
		session.setAttribute("message", new Message("Contact Added sucessfully!! Add more.","success"));
	}else {
		session.setAttribute("message", new Message("something went wrong","danger"));
	}
	return "normal/add_contact";
	
}

}
