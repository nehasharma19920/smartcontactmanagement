package com.smartcontact.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smartcontact.entities.Contact;
import com.smartcontact.entities.User;
import com.smartcontact.services.UserService;

@Controller
@RequestMapping(value = "/user")

public class UserController {
	
	@Autowired private UserService userService;
	
	@ResponseBody
	@GetMapping("/test")
	public String test() {
		User user = new User();
		user.setEmail("neha@gmail.com");
		user.setName("Neha");
		Contact contact = new Contact();
		ArrayList<Contact> contactList = new ArrayList<Contact>();
		contact.setName("Mandeep Singh");
		contact.setPhoneNumber("9971131194");
		user.setContactList(contactList);
		userService.save(user);
		return "test";
		
	}

}
