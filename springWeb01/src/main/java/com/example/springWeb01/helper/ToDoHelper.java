package com.example.springWeb01.helper;

import com.example.springWeb01.entity.ToDo;
import com.example.springWeb01.form.ToDoForm;

public class ToDoHelper {
	/**
	 * ToDoへ変換
	 */
	public static ToDo convertToDo(ToDoForm form) {
		ToDo todo = new ToDo();
		todo.setId(form.getId());
		todo.setTodo(form.getTodo());
		todo.setDetail(form.getDetail());
		return todo;
	}
	
	/**
	 * ToDoFormへの変換
	 */
	public static ToDoForm convertToDoFrom(ToDo todo) {
		ToDoForm form = new ToDoForm();
		form.setId(todo.getId());
		form.setTodo(todo.getTodo());
		form.setDetail(todo.getDetail());
		// 更新画面設定
		form.setIsNew(false);
		return form;
	}
}
