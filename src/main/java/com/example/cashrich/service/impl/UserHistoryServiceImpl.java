package com.example.cashrich.service.impl;

import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cashrich.constants.UserValidation;
import com.example.cashrich.dto.SignInUserDto;
import com.example.cashrich.entity.UserEntity;
import com.example.cashrich.entity.UserHistory;
import com.example.cashrich.repository.UserHistoryRepository;
import com.example.cashrich.repository.UserRepository;
import com.example.cashrich.service.intf.UserHistoryService;

@Service
public class UserHistoryServiceImpl implements UserHistoryService {

	@Autowired
	private UserHistoryRepository userHistoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String onCheckCoins(SignInUserDto signInUserDto) {
		
		UserEntity userEntity = userRepository.findByName(signInUserDto.getUsername());
		
		if (!Objects.isNull(userEntity)) {
			
			UserHistory userHistory = new UserHistory();
			userHistory.setUserEntity(userEntity);
			userHistory.setSearchTime(new Date());
			userHistoryRepository.save(userHistory);
			return UserValidation.CREATED;
			
		}
		return UserValidation.EMPTY;
	}

}
