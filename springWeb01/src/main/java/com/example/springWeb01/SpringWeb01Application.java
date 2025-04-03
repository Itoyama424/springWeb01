package com.example.springWeb01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springWeb01.entity.ToDo;
import com.example.springWeb01.repository.ToDoMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
public class SpringWeb01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringWeb01Application.class, args)
		.getBean(SpringWeb01Application.class).exec();;
	}
	
	private final ToDoMapper mapper;
	
	public void exec() {
		System.out.println("�S������");
		for(ToDo row : mapper.selectAll()) {
			System.out.println(row);
		}
		
		System.out.println("1������");
		System.out.println(mapper.selectById(1));
		
		System.out.println("�o�^�m�F");
		ToDo todo = new ToDo();
		todo.setTodo("���|�W�g���̃e�X�g");
		todo.setDetail("DB�ւ̓o�^�m�F");
		mapper.insert(todo);
		System.out.println(mapper.selectById(4));
		
		System.out.println("�X�V�m�F");
		todo = mapper.selectById(4);
		todo.setTodo("���|�W�g���̃e�X�g�X�V");
		todo.setDetail("DB�ւ̓o�^�m�F�@�X�V");
		mapper.update(todo);
		System.out.println(mapper.selectById(4));
		
		System.out.println("�폜");
		mapper.delete(4);
		for(ToDo row : mapper.selectAll()) {
			System.out.println(row);
		}
		
		
	}
}
