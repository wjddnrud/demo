package com.example.demo.service;

import com.example.demo.dao.BoardDao;
import com.example.demo.dto.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDao dao;

    public List<Board> boardList() {
        return dao.boardList();
    }

    public int boardInsert(Board dto) {
        return dao.boardInsert(dto);
    }

    public void boardDelete(Board dto) {
        dao.boardDelete(dto);
    }

    public void boardUpdate(Board dto) {
        dao.boardUpdate(dto);
    }

    public Board boardSelectOne(Board dto) {
        return dao.boardSelectOne(dto);
    }
}
