package com.example.demo.service;

import com.example.demo.dao.BoardDao;
import com.example.demo.dto.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardDao dao;


    public List<Board> boardList() {

        return dao.selectList();
    }

    public void insert(Board dto) {

        dao.insert(dto);
    }

    public void delete(Integer bdSeq) {

        dao.delete(bdSeq);
    }

    public Board selectOne(Integer bdSeq) {

        return dao.selectOne(bdSeq);
    }

    public void update(Board dto) {

        dao.update(dto);
    }

    public List<Board> selectOneForTitle(String bdTitle, String month) {

        return dao.selectOneForTitle(bdTitle, month);
    }





}
