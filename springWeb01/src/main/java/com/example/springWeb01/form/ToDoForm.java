package com.example.springWeb01.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Ç∑ÇÈÇ±Ç∆Form
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoForm {
	/** Ç∑ÇÈÇ±Ç∆id */
	private Integer id;
	/** Ç∑ÇÈÇ±Ç∆ */	
	private String todo;
	/** Ç∑ÇÈÇ±Ç∆è⁄ç◊ */	
	private String detail;
	/** êVãKîªíË */	
	private Boolean isNew;
}
