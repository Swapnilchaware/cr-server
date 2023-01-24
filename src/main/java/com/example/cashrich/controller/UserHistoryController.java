package com.example.cashrich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cashrich.dto.SignInUserDto;
import com.example.cashrich.service.intf.UserHistoryService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserHistoryController {
	
	@Autowired
	private UserHistoryService userHistoryService;
	
	@PutMapping("/checkCoin")
	public String onCheckCoin(@RequestBody SignInUserDto signInUserDto) {
		return userHistoryService.onCheckCoins(signInUserDto);
	}
}
