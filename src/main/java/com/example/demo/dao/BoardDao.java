package com.example.demo.dao;

import com.example.demo.dto.Board;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BoardDao {

    List<Board> boardList();

    int boardInsert(Board dto);

    void boardDelete(Board dto);

    void boardUpdate(Board dto);

    Board boardSelectOne(Board dto);
}
