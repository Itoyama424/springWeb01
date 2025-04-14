package com.example.springWeb01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springWeb01.entity.ToDo;
import com.example.springWeb01.service.ToDoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoController {
	
	/** DI */
	private final ToDoService toDoService;
	
	/**
	 * することの一覧を表示します。
	 */
	@GetMapping
	public String list(Model model) {
		model.addAttribute("todos", toDoService.findAllTodo());
		return "todo/list";
	}
	
	/**
	 * すること詳細画面を表示します。
	 * @param id
	 * @param model
	 * @param attribute
	 * @return
	 */
	@GetMapping("/{id}")
	public String detail(@PathVariable Integer id, Model model, RedirectAttributes attribute) {
		// することIDからすることを取得
		ToDo todo = toDoService.findByIdToDo(id);
		
		if(todo != null) {
			model.addAttribute("todo", todo);
			return "todo/detail";
		} else {
			// 対象データなしの場合はフラッシュメッセージ
			attribute.addFlashAttribute("errorMessage", "対象データがありません");
			// リダイレクト(多分サーバーからサーバー（ControllerからController）がリダイレクト
			return "redirect:/todos";
		}
	}
	
	/**
	 * 新規登録画面を表示します。
	 */
//	@GetMapping("/form")
//	public String newToDo() {
//		
//	}
	
	
}
