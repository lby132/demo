package com.example.demo.controller;

import com.example.demo.request.PostCreate;
import com.example.demo.request.ReqDetailDto;
import com.example.demo.response.PostResponse;
import com.example.demo.response.ResDetailDto;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @GetMapping("/getBoardContent")
    public ResDetailDto getDetail(Long id) {
        return boardService.detail(id);
    }

    @PostMapping("/boardSave")
    public void boardSave(@RequestBody PostCreate postCreate) {
        boardService.boardSave(postCreate);
    }
}
