package com.example.springWeb01.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.springWeb01.entity.ToDo;

@Mapper
public interface ToDoMapper {
	/**
	 * 全てのすることを取得します。
	 */
	List<ToDo> selectAll();
	
	/**
	 * 指定されたIDの対応する、することを取得します。
	 */
	ToDo selectById(@Param("id") Integer id);
	
	/**
	 * することを登録する
	 */
	void insert(ToDo todo);
	
	/**
	 * することを更新します。
	 */
	void update(ToDo todo);
	
	/**
	 * 指定されたIDのすることを削除します。
	 */
	void delete(@Param("id") Integer id);
}
