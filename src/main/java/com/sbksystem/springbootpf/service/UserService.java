package com.sbksystem.springbootpf.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbksystem.springbootpf.entity.User;
import com.sbksystem.springbootpf.repository.UserRepository;

// Serviceクラスとしての振舞いを定義するアノテーション。DI対象となる条件の@Componentアノテーションの振舞いを内包している
@Service
public class UserService {

	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAll() {
		
		//DBから取得？
		List<User> userList = userRepository.findAll();
		
		return userList
				.stream()
				.map(user -> new User(
						// パスワードや作成日時、更新日時を除外した例
						// これらの引数に対応したコンストラクタをUserエンティティに作成しておく必要はある
						user.getId(),
						user.getCode(),
						user.getName(),
						user.getDescription(),
						user.getIcon(),
						user.getBirthday(),
						user.getHeader_image(),
						user.getCreated()
					)
				)
				.collect(Collectors.toList());
	}
}
