package com.example.cashrich.service.intf;

import com.example.cashrich.dto.SignInUserDto;
import com.example.cashrich.dto.SignUpUserDto;

public interface UserService {
	
	String signIn(SignInUserDto signInUserDto);
	
	String signUp(SignUpUserDto signUpUserDto);
	
	SignUpUserDto getProfile(SignInUserDto signInUserDto);
}
