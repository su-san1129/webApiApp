package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.LoginUser;
import com.example.demo.service.UserService;

@CrossOrigin()
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public ResponseEntity<Object> login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    LoginUser loginUser = (LoginUser) auth.getPrincipal();
        HttpStatus status = HttpStatus.OK;

        return new ResponseEntity<>(loginUser.getUser(), status);
	}
	
	@RequestMapping("/testInsert")
	public String testInsert() {
		// userService.userSave();
		return "insert finish";
	}
}
