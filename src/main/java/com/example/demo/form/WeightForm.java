package com.example.demo.form;

import java.sql.Date;

import lombok.Data;

@Data
public class WeightForm {

	/** ID */
	private Integer id;
	/** ユーザーID */
	private Integer userId;
	/** 体重 */
	private Double weight;
	/** 体脂肪率 */
	private Double bodyFatParcentage;
	/** 作成日 */
	private Date createdAt;
	/** 更新日 */
	private Date updatedAt;
	

}
