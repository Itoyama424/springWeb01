package com.example.springWeb01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springWeb01.entity.ToDo;
import com.example.springWeb01.form.ToDoForm;
import com.example.springWeb01.helper.ToDoHelper;
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
	@GetMapping("/form")
	public String newToDo(@ModelAttribute ToDoForm form) {
		// 新規登録画面の設定
		form.setIsNew(true);
		return "todo/form";
	}
	/**
	 * 新規登録を実行します。
	 * @param form
	 * @param attribute
	 * @return
	 */
	@PostMapping("/save")
	public String create(ToDoForm form, RedirectAttributes attribute) {
		// エンティティへ変更
		ToDo todo = ToDoHelper.convertToDo(form);
		// 登録実行
		toDoService.insertToDo(todo);
		// フラッシュメッセージ
		attribute.addFlashAttribute("message", "新しいToDoが作成されました。");
		// PRGパターン
		return "redirect:/todos";
	}
	
	/**
	 * 指定された「id」の修正画面を表示します。
	 * @param id
	 * @param model
	 * @param attribute
	 * @return
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model, RedirectAttributes attribute) {
		// idに対応する「すること」を取得
		ToDo target = toDoService.findByIdToDo(id);
		if(target != null) {
			// 対象データがある場合はFormへの変換
			ToDoForm form = ToDoHelper.convertToDoFrom(target);
			// モデルに格納
			model.addAttribute("toDoForm", form);
			
			return "todo/form";
			
		} else {
			// 対象データがない場合はフラッシュメッセージを設定
			attribute.addFlashAttribute("errorMessage", "対象データがありません。");
			// 一覧画面へリダイレクト
			return "redirect:/todos";
		}
	}
	
	@PostMapping("/update")
	public String update(ToDoForm form, RedirectAttributes attribute) {
		// エンティティへ変更
		ToDo todo = ToDoHelper.convertToDo(form);
		// 更新処理
		toDoService.updateToDo(todo);
		// 対象データがない場合はフラッシュメッセージを設定
		attribute.addFlashAttribute("message", "ToDoが更新されました。");
		// PRGパターン
		return "redirect:/todos";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, RedirectAttributes attributes) {
		// 削除処理
		toDoService.deleteToDo(id);
		// フラッシュメッセージ
		attributes.addFlashAttribute("message", "ToDoが削除されました。");
		// PRGパターン
		return "redirect:/todos";
	}
}
