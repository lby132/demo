package com.example.demo.response;

import com.example.demo.domain.Board;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class PostResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String auth;
    private final String category;
    private final Integer cnt;
    private final LocalDate regDt;


    public PostResponse(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.auth = board.getAuth();
        this.category = board.getCategory();
        this.cnt = board.getCnt();
        this.regDt = board.getRegDt();
    }

    @Builder

    public PostResponse(Long id, String title, String content, String auth, String category, Integer cnt, LocalDate regDt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.auth = auth;
        this.category = category;
        this.cnt = cnt;
        this.regDt = regDt;
    }
}
