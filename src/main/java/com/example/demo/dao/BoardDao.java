package com.example.demo.dao;

import com.example.demo.dto.Board;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface BoardDao {

    List<Board> selectList();

    void insert(Board dto);

    void delete(Integer bdSeq);

    Board selectOne(Integer bdSeq);

    void update(Board dto);

    List<Board> selectOneForTitle(String bdTitle, String month);



}
