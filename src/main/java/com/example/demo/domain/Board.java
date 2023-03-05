package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "board_t")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "auth")
    private String auth;

    @Column(name = "category")
    private String category;

    @Lob
    @Column(name = "content")
    private String content;

    @Column(name = "reg_dt")
    private LocalDate regDt;

    @Column(name = "cnt")
    private Integer cnt;

    @Builder
    public Board(String title, String auth, String category, String content, LocalDate regDt, Integer cnt) {
        this.title = title;
        this.auth = auth;
        this.category = category;
        this.content = content;
        this.regDt = regDt;
        this.cnt = cnt;
    }
}
