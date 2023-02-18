package com.example.demo.service;

import com.example.demo.entity.BoardEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    void boardSaveTest() throws Exception {
        //given
//        new BoardEntity(1L, "title", "student", "study", "hi im Siri");
        BoardEntity board = BoardEntity.builder()
                .id(1L)
                .title("title")
                .auth("student")
                .category("study")
                .content("hi")
                .build();

        //when
        boardService.boardSave(board);
        BoardEntity save = boardService.boardFindOne(board.getId());

        //then
        assertThat(board.getId()).isEqualTo(save.getId());
    }


}