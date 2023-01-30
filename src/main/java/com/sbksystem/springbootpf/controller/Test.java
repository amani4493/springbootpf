package com.sbksystem.springbootpf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sbksystem.springbootpf.entity.User;
import com.sbksystem.springbootpf.service.UserService;

@Controller
public class Test {
	
	@Autowired
	UserService UserService;
	
	@GetMapping("/test")
	public String helloworld(Model model) {
		List<User> userList = UserService.getAll();
		model.addAttribute("message",userList);
		return "/test";
	}
}