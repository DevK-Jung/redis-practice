package com.example.redispractice.cache.board.repository;

import com.example.redispractice.cache.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Page<Board> findAllByOrderByCreateAtDesc(Pageable pageable);
}
