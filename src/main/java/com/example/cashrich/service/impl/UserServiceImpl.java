package com.example.cashrich.service.impl;

import java.util.Objects;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cashrich.constants.UserValidation;
import com.example.cashrich.dto.SignInUserDto;
import com.example.cashrich.dto.SignUpUserDto;
import com.example.cashrich.entity.UserEntity;
import com.example.cashrich.repository.UserRepository;
import com.example.cashrich.service.intf.UserService;
import com.example.cashrich.util.ValidationHelper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String signIn(SignInUserDto signInUserDto) {
		
		UserEntity userEntity = userRepository.findByName(signInUserDto.getUsername());
		
		if (!Objects.isNull(userEntity)) {
			return signInUserDto.getPassword().equals(userEntity.getPassword()) ? UserValidation.USER_LOGGED_IN : UserValidation.INCORRECT_PASSWORD;
		} else {
			return UserValidation.USER_NOT_FOUND;
		}
		
		
	}

	@Override
	public String signUp(SignUpUserDto signUpUserDto) {
		
		boolean isValid = false;
		
		try {
			isValid = userFieldValidation(signUpUserDto);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		if (isValid) {
			
			UserEntity userEntity = userRepository.findByName(signUpUserDto.getUsername());
			
			if (Objects.isNull(userEntity)) {
				
				try {
					
					UserEntity newUserEntity = new UserEntity();
					newUserEntity.setName(signUpUserDto.getUsername());
					newUserEntity.setPassword(signUpUserDto.getPassword());
					newUserEntity.setBirthDate(signUpUserDto.getDateOfBirth());
					
					userRepository.save(newUserEntity);
					return UserValidation.USER_CREATED;
				} catch (Exception e) {
					return UserValidation.NOT_ABLE_TO_CREATE_USER;
				}
			} else {
				return UserValidation.DUPLICATE_USER;
			}
		}
		
		return UserValidation.EMPTY;
	}

	@Override
	public SignUpUserDto getProfile(SignInUserDto signInUserDto) {
		
		UserEntity userEntity = userRepository.findByName(signInUserDto.getUsername());

		if (!Objects.isNull(userEntity)) {
			return userEntity.convertToDto();
		}

		return null;
		
	}
	
	public boolean userFieldValidation(SignUpUserDto signUpUserDto) throws ValidationException {
		
		if (signUpUserDto.getUsername() == null) {
			throw new ValidationException(UserValidation.USERNAME_REQUIRED);
		}
		
		if (signUpUserDto.getPassword() == null) {
			throw new ValidationException(UserValidation.PASSWORD_REQUIRED);
		}
		
		if (signUpUserDto.getDateOfBirth() == null) {
			throw new ValidationException(UserValidation.DOB_REQUIRED);
		}
		
		if(ValidationHelper.checkMinLengthAndMaxLength(signUpUserDto.getUsername(), 8, 15)) {
			throw new ValidationException(UserValidation.USERNAME_CONSTRAINT);
		}
		
		
		return true;
	}

}
