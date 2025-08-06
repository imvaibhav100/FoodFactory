package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
	@GetMapping("/product/orderSuccess")
	public String orderSuccess(Model model) {
		return "Order_success";
	}

}
