package com.sbksystem.springbootpf.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbksystem.springbootpf.entity.Tweet;
import com.sbksystem.springbootpf.repository.TweetRepository;

@Service
public class TweetService {
	
	@Autowired
	TweetRepository tweetRepository;
	
	public List<Tweet> getAll() {
		
		//DBから取得
		List<Tweet> tweets = tweetRepository.findAll();
		
		return tweets
				.stream()
				.map(tweet -> new Tweet(
						tweet.getId(),
						tweet.getUser_id(),
						tweet.getBody(),
						tweet.getParent_id(),
						tweet.getCreated_at(),
						tweet.getUpdated_at()
						)
					)
				 	.collect(Collectors.toList());
	}

}
