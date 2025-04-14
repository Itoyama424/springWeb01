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
	 * ���邱�Ƃ̈ꗗ��\�����܂��B
	 */
	@GetMapping
	public String list(Model model) {
		model.addAttribute("todos", toDoService.findAllTodo());
		return "todo/list";
	}
	
	/**
	 * ���邱�Əڍ׉�ʂ�\�����܂��B
	 * @param id
	 * @param model
	 * @param attribute
	 * @return
	 */
	@GetMapping("/{id}")
	public String detail(@PathVariable Integer id, Model model, RedirectAttributes attribute) {
		// ���邱��ID���炷�邱�Ƃ��擾
		ToDo todo = toDoService.findByIdToDo(id);
		
		if(todo != null) {
			model.addAttribute("todo", todo);
			return "todo/detail";
		} else {
			// �Ώۃf�[�^�Ȃ��̏ꍇ�̓t���b�V�����b�Z�[�W
			attribute.addFlashAttribute("errorMessage", "�Ώۃf�[�^������܂���");
			// ���_�C���N�g(�����T�[�o�[����T�[�o�[�iController����Controller�j�����_�C���N�g
			return "redirect:/todos";
		}
	}
	
	/**
	 * �V�K�o�^��ʂ�\�����܂��B
	 */
//	@GetMapping("/form")
//	public String newToDo() {
//		
//	}
	
	
}
