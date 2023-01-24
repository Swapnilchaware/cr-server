package com.example.cashrich.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.cashrich.dto.SignUpUserDto;

@Entity
@Table(name = "user_tbl")
public class UserEntity {

	@Id
	@GeneratedValue()
	private int id;

	private String name;

	private String password;

	private Date birthDate;

	@OneToMany
	private List<UserHistory> userHistory;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<UserHistory> getUserHistory() {
		return userHistory;
	}

	public void setUserHistory(List<UserHistory> userHistory) {
		this.userHistory = userHistory;
	}

	public UserEntity() {
		super();
	}

	public SignUpUserDto convertToDto() {

		SignUpUserDto signUpUserDto = new SignUpUserDto();
		signUpUserDto.setUsername(this.name);
		signUpUserDto.setPassword(this.password);
		signUpUserDto.setDateOfBirth(this.birthDate);
		return signUpUserDto;

	}

}
