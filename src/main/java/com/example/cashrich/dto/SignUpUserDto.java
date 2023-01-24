package com.example.cashrich.dto;

import java.util.Date;

import com.example.cashrich.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SignUpUserDto {

	private String username;
	
	private String password;
	
	private Date dateOfBirth;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public SignUpUserDto() {
		super();
	}

	public UserEntity convertToEntity() {
		
		UserEntity userEntity = new UserEntity();
		userEntity.setName(this.username);
		userEntity.setPassword(password);
		userEntity.setBirthDate(this.dateOfBirth);
		return userEntity;
	}

}
