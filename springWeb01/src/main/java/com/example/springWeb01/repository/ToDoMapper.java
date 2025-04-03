package com.example.springWeb01.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.springWeb01.entity.ToDo;

@Mapper
public interface ToDoMapper {
	/**
	 * �S�Ă̂��邱�Ƃ��擾���܂��B
	 */
	List<ToDo> selectAll();
	
	/**
	 * �w�肳�ꂽID�̑Ή�����A���邱�Ƃ��擾���܂��B
	 */
	ToDo selectById(@Param("id") Integer id);
	
	/**
	 * ���邱�Ƃ�o�^����
	 */
	void insert(ToDo todo);
	
	/**
	 * ���邱�Ƃ��X�V���܂��B
	 */
	void update(ToDo todo);
	
	/**
	 * �w�肳�ꂽID�̂��邱�Ƃ��폜���܂��B
	 */
	void delete(@Param("id") Integer id);
}
