package com.smartcontact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
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
		return "signup";
		
	}
}
