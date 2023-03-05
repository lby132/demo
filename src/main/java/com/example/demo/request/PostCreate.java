package com.example.demo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class PostCreate {

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    @NotBlank(message = "카테고리를 선택해주세요.")
    private String category;

    private LocalDateTime regDt;

    private Integer cnt;

    @Builder
    public PostCreate(String title, String content, String category, LocalDateTime regDt, Integer cnt) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.regDt = regDt;
        this.cnt = cnt;
    }
}
