package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.exception.PostNotFound;
import com.example.demo.request.PostCreate;
import com.example.demo.response.PostResponse;
import com.example.demo.response.ResDetailDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    int count;
    public void boardSave(PostCreate postCreate) {
        LocalDate date = LocalDate.now();

        Board board = Board.builder()
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .category(postCreate.getCategory())
                .regDt(date)
                .build();

        boardRepository.save(board);
    }

    public ResDetailDto detail(Long id) {
        Board detail = boardRepository.findById(id).orElseThrow(PostNotFound::new);

        ResDetailDto resDetail = ResDetailDto.builder()
                .auth(detail.getAuth())
                .title(detail.getTitle())
                .content(detail.getContent())
                .regDate(detail.getRegDt())
                .build();

        return resDetail;
    }

}
