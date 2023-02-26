package com.sbksystem.springbootpf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sbksystem.springbootpf.entity.Tweet;
import com.sbksystem.springbootpf.entity.User;
import com.sbksystem.springbootpf.service.TweetService;
import com.sbksystem.springbootpf.service.UserService;


// Controllerアノテーションを付与するとreturnした文字列に応じてsrc/main/resources/templates内に配置したファイルがHTTPレスポンスとして返る
@Controller
public class WebTest {
	
	@Autowired
	UserService UserService;
	TweetService TweetService;

	// エンドポイントの指定（今回は/hoge）
	@GetMapping("/hoge")
	public String hoge() {
		// Controllerアノテーションが付与されたclass内なのでsrc/main/resources/templates内のhoge.htmlがHTTPレスポンスとして返される
		return "hoge.html";
	}
	
	@GetMapping("/home")
	public String username(Model model) {
		List<User>userList = UserService.getAll();
		model.addAttribute("message",userList);
		return "home.html";
	}
	@GetMapping("/home")
	public String tweets(Model model) {
		List<Tweet>tweets = TweetService.getAll();
		model.addAttribute("tweets",tweets);
		return "home.html";
	}
}

