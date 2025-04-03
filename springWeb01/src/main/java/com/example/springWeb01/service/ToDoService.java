package com.example.springWeb01.service;

import java.util.List;

import com.example.springWeb01.entity.ToDo;

/**
 * ToDoService
 */
public interface ToDoService {
	
	List<ToDo> findAllTodo();
	
	ToDo findByIdToDo(Integer id);
	
	void insertToDo(ToDo todo);
	
	void updateToDo(ToDo todo);
	
	void deleteToDo(Integer id);
}
