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

    public List<Board> selectBoardList() {
        return dao.selectBoardList();
    }

    public int insertBoard(Board dto) {
        return dao.insertBoard(dto);
    }

    public int deleteBoard(Integer boardSeq) {
        return dao.deleteBoard(boardSeq);
    }

    public int updateBoard(Board dto, Integer boardSeq) {
        return dao.updateBoard(dto, boardSeq);
    }

    public Board selectOneBoard(Integer boardSeq) {
        return dao.selectOneBoard(boardSeq);
    }
}
