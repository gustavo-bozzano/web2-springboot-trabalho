package com.web2.web2springboottrabalho.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.web2.web2springboottrabalho.models.User;
import com.web2.web2springboottrabalho.models.UserDto;
import com.web2.web2springboottrabalho.repository.UserRepository;

public class UserController {
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional(rollbackFor = Exception.class)
	public String saveDto(UserDto userDto) {

		userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

		return userRepository.save(new User(userDto)).getUsername();
	}
}
