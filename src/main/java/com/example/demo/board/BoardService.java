package com.example.demo.board;

import com.example.demo.dao.BoardDao;
import com.example.demo.dto.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardDao dao;


    public List<Board> boardList() {
        return dao.selectList();
    }

    public void insert() {
        dao.insert();
    }

    public String delete() {

        return dao.delete();
    }

    public String selectOne() {

        return dao.selectOne();
    }






}
