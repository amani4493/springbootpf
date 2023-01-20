package com.sbksystem.springbootpf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbksystem.springbootpf.entity.User;

//Repositoryクラスとしての振舞いを定義するアノテーション。DI対象となる条件の@Componentアノテーションの振舞いを内包している
public interface UserRepository extends JpaRepository<User, Long> {

}
