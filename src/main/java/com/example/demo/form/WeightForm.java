package com.example.demo.form;

import java.sql.Date;

import lombok.Data;

@Data
public class WeightForm {

	/** ID */
	private Integer id;
	/** ���[�U�[ID */
	private Integer userId;
	/** �̏d */
	private Double weight;
	/** �̎��b�� */
	private Double bodyFatParcentage;
	/** �쐬�� */
	private Date createdAt;
	/** �X�V�� */
	private Date updatedAt;
	

}
