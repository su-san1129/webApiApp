package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.LoginUser;
import com.example.demo.domain.Weight;
import com.example.demo.form.WeightForm;
import com.example.demo.service.WeightService;


@CrossOrigin
@RestController
@RequestMapping("/api/weight")
public class WeightController {
	
	@Autowired
	private WeightService weightService;
	
	/**
	 * ユーザーIDに紐づいた体重情報を返却.
	 * 
	 * サーバー側でヘッダーの情報から得られたユーザー情報を取得し、クライアント側に返す。
	 * @return
	 */
	@RequestMapping("/getUserData")
	public List<Weight> showWeight() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    LoginUser loginUser = (LoginUser) auth.getPrincipal();
		return weightService.weightListById(loginUser.getUser().getId());
	}
	
	@RequestMapping("/save")
	public void save(@RequestBody WeightForm weightForm){
		System.out.println("posted");
		System.out.println(weightForm);
	}
	
	

}
