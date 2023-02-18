package com.example.demo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "board_t")
public class BoardEntity {

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
    public BoardEntity(Long id, String title, String auth, String category, String content) {
        this.id = id;
        this.title = title;
        this.auth = auth;
        this.category = category;
        this.content = content;
    }
}
