package com.smartcontact.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartcontact.dto.UserDTO;
import com.smartcontact.entities.UserEntity;
import com.smartcontact.helper.Message;
import com.smartcontact.services.UserService;



@Controller
public class HomeController {
	
	private @Autowired BCryptPasswordEncoder passwordEncoder;
	
	@Autowired UserService userservice;
	@RequestMapping(value = "/")
	public String home(Model model) {
		model.addAttribute("tittle", "This is dynamic controller");
		return "home";
		
	}
	@RequestMapping(value = "/about")
	public String about() {
		return "about";
		
	}

	@RequestMapping(value = "/signup")
	public String singUp(Model model) {
		model.addAttribute("tittle", "Registration");
		model.addAttribute("user", new UserDTO());
		return "signup";
		
	}
	
	@RequestMapping(value = "/signup",method= RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user")UserDTO user ,BindingResult result1  , @RequestParam(value = "agreement",defaultValue = "false") 
	boolean agreement ,Model model , HttpSession session) {
		System.out.println("Agreement "+agreement);
		System.out.println("User "+user);
		try {
		if(!agreement) {
			System.out.println("you have not agreed the term and condition");
			model.addAttribute("user",user);
			throw new Exception("you have not agreed the term and condition");
			
		}
		if(result1.hasErrors()) {
			model.addAttribute("user", user);
		    System.out.println("Error"+result1.toString());
			return "signup";
		}
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		UserDTO result = userservice.save(user);
		session.setAttribute("message", new Message("Successfully Register ", "alert-success"));
		model.addAttribute("user", result);
		}catch(Exception e){
			model.addAttribute("user" , user);
			session.setAttribute("message", new Message("Something went wrong "+e.getMessage(), "alert-danger"));
			
			
		}
		return "signup";
		
	}
	
	@RequestMapping(value = "/signin")
	public String customLogin(Model model) {
	
		return "login";
		
	}
}
