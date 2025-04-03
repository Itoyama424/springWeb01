package com.example.springWeb01.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {
    /** ���邱��ID */
    private Integer id;
    /** ���邱�� */
    private String todo;
    /** ���邱�Əڍ� */
    private String detail;
    /** �쐬���� */
    private LocalDateTime createdAt;
    /** �X�V���� */
    private LocalDateTime updatedAt;
}
