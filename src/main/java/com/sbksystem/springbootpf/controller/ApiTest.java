package com.sbksystem.springbootpf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbksystem.springbootpf.entity.User;
import com.sbksystem.springbootpf.service.UserService;

// RestControllerアノテーション内のclassでオブジェクトをReturnするとHTTPレスポンスとしてJSONが返る
@RestController
@Controller
// classにRequestMappingでpathを指定するとこのクラス内の全てのエンドポイントの最初に指定したパス（今回は/api）が必要になる
@RequestMapping("/api")
public class ApiTest {

	// AutowiredアノテーションでUserServiceをDIしている
	@Autowired
	UserService userService;
	
	// methodにGetMappingでpathを指定するとこのメソッドのエンドポイントを指定できる
	//（今回はclassの/apiとメソッドの/usersを合わせて/api/usersになる）
	@GetMapping("/users")
	public List<User> users() {
		
		// DIしたuserServiceクラスのgetAllメソッドを呼び出す
		List<User> userList = userService.getAll();

		// class自体にRestControllerあのテーションを付与しているので、戻り値のList<User>をそのままReturnするとJSONが返る
		return userList;
	}
}
