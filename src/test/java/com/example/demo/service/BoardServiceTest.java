package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.request.PostCreate;
import com.example.demo.response.PostResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Transactional
@Rollback(value = false)
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @Test
    void boardSaveTest() {
        //given
        PostCreate board = PostCreate.builder()
                .title("title1")
                .category("study1")
                .content("hi1")
                .build();

        //when
        boardService.boardSave(board);

        //then
        assertEquals(2L, boardRepository.count());
        Board post = boardRepository.findAll().get(0);
        assertEquals("title1", post.getTitle());
        assertEquals("hi1", post.getContent());

    }

    @Test
    void boardListTest() {
        //given
        Board board = Board.builder()
                .title("title1")
                .category("study1")
                .content("hi1")
                .build();

        boardRepository.save(board);

        //when
        PostResponse response = boardService.boardFindOne(board.getId());

        //then
        assertThat(response).isNotNull();
        assertEquals(1L, boardRepository.count());
        assertEquals("title1", response.getTitle());
        assertEquals("study1", response.getCategory());
        assertEquals("hi1", response.getContent());
    }



}