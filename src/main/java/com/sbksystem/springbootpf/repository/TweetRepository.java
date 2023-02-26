package com.sbksystem.springbootpf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbksystem.springbootpf.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

}