package com.example.cashrich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cashrich.dto.SignInUserDto;
import com.example.cashrich.dto.SignUpUserDto;
import com.example.cashrich.service.intf.UserService;

@RequestMapping("/user")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@PutMapping("/signIn")
	public String signIn(@RequestBody SignInUserDto signInUserDto) {
		return userService.signIn(signInUserDto);
	}
	
	@PostMapping("/signUp")
	public String signUp(@RequestBody SignUpUserDto signUpUserDto) {
		return userService.signUp(signUpUserDto);
	}
	
	@PutMapping
	public SignUpUserDto getProfile(@RequestBody SignInUserDto signInUserDto) {
		return userService.getProfile(signInUserDto);
	}
}
