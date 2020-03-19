package com.example.demo.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {
	
	/** ID */
	private Integer id;
	/** 名前 */
	private String name;
	/** メールアドレス */
	private String email;
	/** パスワード */
	private String password;
	/** 身長 */
	private Double height;
	/** 体重 */
	private Double weight;
	/** 誕生日 */
	private LocalDate birthDay;
	/** 目標体重 */
	private Double targetWeight;
	

}
