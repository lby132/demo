package com.example.demo.controller;

import com.example.demo.request.PostCreate;
import com.example.demo.response.PostResponse;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board")
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/getBoardList")
    public List<PostResponse> getBoardList() {
        return boardService.boardList();
    }

    @PostMapping("/boardSave")
    public void boardSave(@RequestBody PostCreate postCreate) {
        boardService.boardSave(postCreate);
    }
}