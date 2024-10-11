package com.example.redispractice.cache.board.service;

import com.example.redispractice.cache.board.entity.Board;
import com.example.redispractice.cache.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Cacheable(cacheNames = "getBoards", key = "'board:page:' + #page + ':size' + #size", cacheManager = "boardCacheManage")
    public List<Board> getBoards(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        Page<Board> pageOfBoards = boardRepository.findAllByOrderByCreateAtDesc(pageable);
        return pageOfBoards.getContent();
    }
}
