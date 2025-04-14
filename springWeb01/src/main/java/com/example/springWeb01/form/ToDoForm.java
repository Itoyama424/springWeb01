package com.example.springWeb01.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * することForm
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoForm {
	/** することid */
	private Integer id;
	/** すること */	
	private String todo;
	/** すること詳細 */	
	private String detail;
	/** 新規判定 */	
	private Boolean isNew;
}
