package com.example.demo.service;

import com.example.demo.entity.BoardEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardEntity> boardList() {
        return boardRepository.findAll();
    }

    public BoardEntity boardFindOne(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(() -> new NullPointerException());
    }

    int count;

    public void boardSave(BoardEntity board) throws Exception {
        try {
            count++;
            board.setCnt(count);
            boardRepository.save(board);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
