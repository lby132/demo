package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.exception.PostNotFound;
import com.example.demo.request.PostCreate;
import com.example.demo.request.ReqDetailDto;
import com.example.demo.response.PostResponse;
import com.example.demo.response.ResDetailDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
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

    int count;
    @Transactional
    public ResDetailDto detail(Long id) {
        Board detail = boardRepository.findById(id).orElseThrow(PostNotFound::new);

        ResDetailDto resDetail = ResDetailDto.builder()
                .id(detail.getId())
                .auth(detail.getAuth())
                .title(detail.getTitle())
                .content(detail.getContent())
                .regDate(detail.getRegDt())
                .build();

        detail.setCnt(count++);

        return resDetail;
    }


    @Transactional
    public void update(ReqDetailDto req) {
        Board findBoard = boardRepository.findById(req.getId()).orElseThrow(PostNotFound::new);

        if (!StringUtils.isEmpty(req.getTitle())) findBoard.setTitle(req.getTitle());
        if (!StringUtils.isEmpty(req.getContent())) findBoard.setContent(req.getContent());
    }

    public void delete(Long id) {
        Board findBoard = boardRepository.findById(id).orElseThrow(PostNotFound::new);
        boardRepository.delete(findBoard);
    }
}
