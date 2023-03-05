package com.example.demo.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ResDetailDto {
    private Long id;
    private String title;
    private String content;
    private String auth;
    private LocalDate regDate;
    private String category;

    @Builder
    public ResDetailDto(Long id, String title, String content, String auth, LocalDate regDate, String category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.auth = auth;
        this.regDate = regDate;
        this.category = category;
    }
}
