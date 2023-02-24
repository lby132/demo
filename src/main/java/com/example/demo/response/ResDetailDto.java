package com.example.demo.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
public class ResDetailDto {
    private Long id;
    private String title;
    private String content;
    private String auth;

    @Builder
    public ResDetailDto(Long id, String title, String content, String auth) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.auth = auth;
    }
}
