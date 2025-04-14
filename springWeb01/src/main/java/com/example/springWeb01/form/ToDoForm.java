package com.example.springWeb01.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ���邱��Form
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoForm {
	/** ���邱��id */
	private Integer id;
	/** ���邱�� */	
	private String todo;
	/** ���邱�Əڍ� */	
	private String detail;
	/** �V�K���� */	
	private Boolean isNew;
}
