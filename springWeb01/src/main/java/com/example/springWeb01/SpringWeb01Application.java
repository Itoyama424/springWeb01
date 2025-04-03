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
		System.out.println("全件検索");
		for(ToDo row : mapper.selectAll()) {
			System.out.println(row);
		}
		
		System.out.println("1件検索");
		System.out.println(mapper.selectById(1));
		
		System.out.println("登録確認");
		ToDo todo = new ToDo();
		todo.setTodo("リポジトリのテスト");
		todo.setDetail("DBへの登録確認");
		mapper.insert(todo);
		System.out.println(mapper.selectById(4));
		
		System.out.println("更新確認");
		todo = mapper.selectById(4);
		todo.setTodo("リポジトリのテスト更新");
		todo.setDetail("DBへの登録確認　更新");
		mapper.update(todo);
		System.out.println(mapper.selectById(4));
		
		System.out.println("削除");
		mapper.delete(4);
		for(ToDo row : mapper.selectAll()) {
			System.out.println(row);
		}
		
		
	}
}
