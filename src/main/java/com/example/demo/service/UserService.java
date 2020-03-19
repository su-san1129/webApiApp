package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	public void userSave() {
		User user = new User();
		user.setId(1);
		user.setEmail("deviationvalue1023@ezweb.ne.jp");
		user.setBirthDay(LocalDate.of(1992, 10, 23));
		user.setWeight(76.0);
		user.setHeight(180.0);
		user.setName("鈴木貴大");
		user.setTargetWeight(70.0);
		user.setPassword(passwordEncoder.encode("password"));
		System.out.println(user);
		userRepository.save(user);
	}

}
