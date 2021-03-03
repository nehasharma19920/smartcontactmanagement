package com.smartcontact.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartcontact.dto.UserDTO;
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


}
