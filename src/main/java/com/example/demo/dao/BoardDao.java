package com.example.demo.dao;

import com.example.demo.dto.Board;
import com.example.demo.dto.Paging;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BoardDao {

    List<Board> selectBoardList(Paging pagingDto);

    List<Board> searchBoardByTitle(Board boardDto, Paging pagingDto);

    Board selectOneBoardByBoardSeq(Integer boardSeq);

    void insertBoard(Board boardDto);

    void deleteBoard(Integer boardSeq);

    void updateBoard(Board boardDto, Integer boardSeq);

    int boardCount(Board boardDto);
}