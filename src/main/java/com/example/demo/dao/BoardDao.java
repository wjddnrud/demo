package com.example.demo.dao;

import com.example.demo.dto.Board;
import com.example.demo.dto.Paging;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BoardDao {

    List<Board> selectBoardList(Paging paging);

    List<Board> searchBoardByTitle(Board dto, Paging paging);

    Board selectOneBoardByBoardSeq(Integer boardSeq);

    int insertBoard(Board dto);

    int deleteBoard(Integer boardSeq);

    int updateBoard(Board dto, Integer boardSeq);

    int boardCount(Board dto);
}