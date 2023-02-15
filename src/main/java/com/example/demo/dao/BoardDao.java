package com.example.demo.dao;

import com.example.demo.dto.Board;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BoardDao {

    List<Board> selectBoardAll();

    int insertBoard(Board dto);

    int deleteBoard(Integer boardSeq);

    int updateBoard(Board dto, Integer boardSeq);

    Board selectBoardByBoardSeq(Integer boardSeq);

    List<Board> selectBoardByTitle(Board dto);
}
