package com.example.demo.service;

import com.example.demo.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

//    @Modifying
//    @Query("update Board b set b.cnt = b.cnt + 1 where b.id = :id")
//    void boardCntUp(@Param(value = "id") Long id);
}
