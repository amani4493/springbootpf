package com.sbksystem.springbootpf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Controllerアノテーションを付与するとreturnした文字列に応じてsrc/main/resources/templates内に配置したファイルがHTTPレスポンスとして返る
@Controller
public class WebTest {

	// エンドポイントの指定（今回は/hoge）
	@GetMapping("/hoge")
	public String hoge() {
		// Controllerアノテーションが付与されたclass内なのでsrc/main/resources/templates内のhoge.htmlがHTTPレスポンスとして返される
		return "hoge.html";
	}
	
	@GetMapping("/home")
	public String fuga() {
		return "home.html";
	}
}
