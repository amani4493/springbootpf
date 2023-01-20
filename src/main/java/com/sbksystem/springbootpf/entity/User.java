package com.sbksystem.springbootpf.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//Entityクラスとしての振舞いを定義するアノテーション。DI対象となる条件の@Componentアノテーションの振舞いを内包している
@Entity

//Lombokの機能。このアノテーションを付与するとクラス変数にgetter/setterでアクセスできるようになる
@Data

//Spring Data JPAの機能。このアノテーションを付与するとEntityの対象となるDB上のテーブル名を指定できる
@Table(name = "users")
public class User {
	
	// Spring Data JPAを利用する場合にはEntityに引数を取らないデフォルトコンストラクタが必須
	// 今回の場合は@AutowiredによるDI。UserRepository経由でUserServiceにDIされている。
	public User() {
	}
	
	public User(
			Long id,
			String code,
			String name,
			String description,
			String icon,
			Date birthday,
			String header_image,
			Date created
	) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.icon = icon;
		this.birthday = birthday;
		this.header_image = header_image;
		this.created = created;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("id")
	private long id;
	
	@Column(nullable=false)
	@JsonProperty("code")
	private String code;
	
	@Column(nullable = false)
	@JsonProperty("password")
	private String password;
	
	@Column(nullable = false)
	@JsonProperty("name")
	private String name;
	
	@Column(nullable = true)
	@JsonProperty("description")
	private String description;

	@Column(nullable = true)
	@JsonProperty("icon")
	private String icon;

	@Column(nullable = true)
	@JsonProperty("birthday")
	private Date birthday;

	@Column(nullable = true)
	@JsonProperty("header_image")
	private String header_image;

	@Column(nullable = true)
	@JsonProperty("created")
	private Date created;

	@Column(nullable = false)
	@JsonProperty("created_at")
	private Date created_at;

	@Column(nullable = false)
	@JsonProperty("updated_at")
	private Date updated_at;

}
