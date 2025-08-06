package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.User;
import com.example.demo.services.UserServices;

@Controller
public class UserController {
	@Autowired
	private UserServices services;

	@PostMapping("/addingUser")
	public String addUser(@ModelAttribute User user) {
		System.out.println(user);
		this.services.addUser(user);
		return "redirect:/admin/services";
	}

	@GetMapping("/updatingUser/{id}")
	public String updateUser(@ModelAttribute User user, @PathVariable("id") int id) {
		this.services.updateUser(user, id);
		return "redirect:/admin/services";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		this.services.deleteUser(id);
		return "redirect:/admin/services";
	}

	// Show registration form
	@GetMapping("/register")
	public String showRegistrationForm(org.springframework.ui.Model model) {
		model.addAttribute("userRegistration", new com.example.demo.entities.User());
		return "register";
	}

	// Handle registration form submission
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("userRegistration") com.example.demo.entities.User user, org.springframework.ui.Model model) {
		// Check if user already exists
		if (services.getUserByEmail(user.getUemail()) != null) {
			model.addAttribute("error", "Email already registered!");
			return "register";
		}
		services.addUser(user);
		return "redirect:/login";
	}

}