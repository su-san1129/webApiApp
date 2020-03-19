package com.example.demo.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Weight {
	
	/** ID */
	private Integer id;
	/** ユーザーID */
	private Integer userId;
	/** 体重 */
	private Double weight;
	/** 体脂肪率 */
	private Double bodyFatPercentage;
	/** 作成日 */
	private LocalDate createdAt;
	/** 更新日 */
	private LocalDate updatedAt;
	
	public double calcBMI(double height, double weight) {
		double BMI = weight / (height* height);
		return BMI;
	}

}
