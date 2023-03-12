package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.request.PostCreate;
import com.example.demo.response.PostResponse;
import com.example.demo.response.ResDetailDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Transactional
@Slf4j
@Rollback(value = false)
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @Test
    void boardSaveTest() {
        //given
        LocalDateTime date = LocalDateTime.now();

        PostCreate board = PostCreate.builder()
                .title("title1")
                .category("자유글")
                .content("hi1")
                .cnt(1)
                .regDt(date)
                .build();

        //when
        boardService.boardSave(board);

        //then
//        assertEquals(5L, boardRepository.count());
//        Board post = boardRepository.findAll().get(0);
//        assertEquals("title1", post.getTitle());
//        assertEquals("hi1", post.getContent());

    }

//    @Test
//    void boardListTest() {
//        //given
//        Board board = Board.builder()
//                .title("title1")
//                .auth("student")
//                .category("자유글")
//                .content("hi1")
//                .build();
//
//        boardRepository.save(board);
//
//        //when
//        ResDetailDto response = boardService.detail(board.getId());
//
//        //then
//        assertThat(response).isNotNull();
//        assertEquals(1L, boardRepository.count());
//        assertEquals("title1", response.getTitle());
//        assertEquals("student", response.getAuth());
//        assertEquals("자유글", response.getCategory());
//        assertEquals("hi1", response.getContent());
//    }

    @Test
    void 글상세() throws Exception {
        //given
        Board board = Board.builder()
                .title("title1")
                .auth("student")
                .content("hi1")
                .build();

        boardRepository.save(board);

        //when
        Board findDetail = boardRepository.findById(board.getId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글 입니다."));
        String auth = findDetail.getAuth();
        String title = findDetail.getTitle();
        String content = findDetail.getContent();

        //then
        assertEquals("title1", title);
        assertEquals("student", auth);
        assertEquals("hi1", content);
    }

}