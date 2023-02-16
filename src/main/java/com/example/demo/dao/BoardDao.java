package com.example.demo.dao;

import com.example.demo.dto.Board;
import com.example.demo.dto.Paging;
import com.example.demo.vo.Vo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BoardDao {

    List<Board> selectBoardAll();

    int insertBoard(Board dto);

    int deleteBoard(Integer boardSeq);

    int updateBoard(Board dto, Integer boardSeq);

    Board selectBoardByBoardSeq(Integer boardSeq);

//    List<Board> selectBoardByTitle(Board dto);
//
//    List<Board> selectBoardByContents(Board dto);

    List<Board> selectBoardByCategory(Board dto);

    List<Board> selectBoardByCreateDate(Vo vo);

    int boardCount();

    List<Board> selectBoardListByThisPage(Paging paging);
}
