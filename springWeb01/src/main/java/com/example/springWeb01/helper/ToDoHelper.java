package com.example.springWeb01.helper;

import com.example.springWeb01.entity.ToDo;
import com.example.springWeb01.form.ToDoForm;

public class ToDoHelper {
	/**
	 * ToDo�֕ϊ�
	 */
	public static ToDo convertToDo(ToDoForm form) {
		ToDo todo = new ToDo();
		todo.setId(form.getId());
		todo.setTodo(form.getTodo());
		todo.setDetail(form.getDetail());
		return todo;
	}
	
	/**
	 * ToDoForm�ւ̕ϊ�
	 */
	public static ToDoForm convertToDoFrom(ToDo todo) {
		ToDoForm form = new ToDoForm();
		form.setId(todo.getId());
		form.setTodo(todo.getTodo());
		form.setDetail(todo.getDetail());
		// �X�V��ʐݒ�
		form.setIsNew(false);
		return form;
	}
}
