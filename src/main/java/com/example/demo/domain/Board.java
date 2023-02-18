package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

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

    @Column(name = "content")
    private String content;

    @Column(name = "cnt")
    private Integer cnt;

    @Builder
    public Board(Long id, String title, String auth, String category, String content) {
        this.id = id;
        this.title = title;
        this.auth = auth;
        this.category = category;
        this.content = content;
    }
}
