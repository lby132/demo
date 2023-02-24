package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.exception.PostNotFound;
import com.example.demo.request.PostCreate;
import com.example.demo.response.PostResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<PostResponse> boardList() {
        return boardRepository.findAll().stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    public PostResponse boardFindOne(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(PostNotFound::new);
        Board board1 = boardRepository.findById(boardId).orElseThrow(PostNotFound::new);

        return PostResponse.builder()
                .id(boardId)
                .title(board.getTitle())
                .content(board.getContent())
                .auth(board.getAuth())
                .category(board.getCategory())
                .build();
    }

    int count;
    public void boardSave(PostCreate postCreate) {
        Board board = Board.builder()
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .category(postCreate.getCategory())
                .build();

        boardRepository.save(board);
    }

}
