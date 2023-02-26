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

//Entityとして使う
@Entity

@Data

//Entityの対象となるDBのテーブル名を指定できる
@Table(name = "tweets")
public class Tweet {
	
	public Tweet() {
		
	}
	
	public Tweet(
			Long id,
			Long user_id,
			String body,
			Date parent_id,
			Date created_at,
			Date updated_at
	) {
		this.id =id;
		this.user_id = user_id;
		this.body = body;
		this.parent_id = parent_id;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;
	
	@Column(nullable=false)
	@JsonProperty("user_id")
	private Long user_id;
	
	@Column(nullable=false)
	@JsonProperty("body")
	private String body;
	
	@Column(nullable=false)
	@JsonProperty("parent_id")
	private Date parent_id;
	
	@Column(nullable=false)
	@JsonProperty("created_at")
	private Date created_at;
	
	@Column(nullable=false)
	@JsonProperty("updated_at")
	private Date updated_at;
	
}