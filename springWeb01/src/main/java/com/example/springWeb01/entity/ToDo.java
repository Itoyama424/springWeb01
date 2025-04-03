package com.example.springWeb01.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {
    /** ‚·‚é‚±‚ÆID */
    private Integer id;
    /** ‚·‚é‚±‚Æ */
    private String todo;
    /** ‚·‚é‚±‚ÆÚ× */
    private String detail;
    /** ì¬“ú */
    private LocalDateTime createdAt;
    /** XV“ú */
    private LocalDateTime updatedAt;
}
