package com.example.cashrich.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cashrich.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer>{
	
	UserEntity findByName(String name);

}
