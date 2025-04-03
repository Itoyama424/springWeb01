package com.example.springWeb01.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springWeb01.entity.ToDo;
import com.example.springWeb01.repository.ToDoMapper;
import com.example.springWeb01.service.ToDoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ToDoServiceImpl implements ToDoService {
	
	private final ToDoMapper toDoMapper;
	
	@Override
	public List<ToDo> findAllTodo() {
		return toDoMapper.selectAll();
	}

	@Override
	public ToDo findByIdToDo(Integer id) {
		return toDoMapper.selectById(id);
	}

	@Override
	public void insertToDo(ToDo todo) {
		toDoMapper.insert(todo);
	}

	@Override
	public void updateToDo(ToDo todo) {
		toDoMapper.update(todo);
	}

	@Override
	public void deleteToDo(Integer id) {
		toDoMapper.delete(id);
	}

}
