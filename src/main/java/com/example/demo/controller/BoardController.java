package com.example.demo.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boardList")
public class BoardController {

private BoardService BoardService;

//    @GetMapping("/getBoard")
//    public ResponseEntity<String, HttpStatus> getBoardList() {
//
//    }
}
