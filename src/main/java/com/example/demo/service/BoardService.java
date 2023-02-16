package com.example.demo.service;

import com.example.demo.dao.BoardDao;
import com.example.demo.dto.Board;
import com.example.demo.dto.Paging;
import com.example.demo.vo.Vo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDao dao;

    public ResponseEntity<List<Board>> selectBoardListByThisPage(int thisPage, Paging paging) {
        paging.setParamsPaging(dao.boardCount(), thisPage);
        List<Board> selectBoardListByThisPage = dao.selectBoardListByThisPage(paging);
        return ResponseEntity.ok().body(selectBoardListByThisPage);
    }

    public ResponseEntity<List<Board>> selectBoardAll() {
        List<Board> boardList = dao.selectBoardAll();
        if(boardList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(boardList);
    }

    public ResponseEntity<Board> selectBoardByBoardSeq(Integer boardSeq) {
        Board board = dao.selectBoardByBoardSeq(boardSeq);
        if(board != null) {
            return ResponseEntity.ok().body(board);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Board> insertBoard(Board dto) {
        dto.setCreateDate(String.valueOf(LocalDateTime.now()));
        int insertCheck = dao.insertBoard(dto);
        if(insertCheck != 0) {
            return ResponseEntity.ok().body(dto);
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<Board> deleteBoard(Integer boardSeq) {
        Board deletedData = dao.selectBoardByBoardSeq(boardSeq);
        int deleteCheck = dao.deleteBoard(boardSeq);
        if(deleteCheck != 0) {
            return ResponseEntity.ok().body(deletedData);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Board> updateBoard(Board dto, Integer boardSeq) {
        Board board = dao.selectBoardByBoardSeq(boardSeq);
        if(board == null) {
            return ResponseEntity.notFound().build();
        }
        if(ObjectUtils.isEmpty(dto.getTitle())) {
            dto.setTitle(board.getTitle());
        }
        if(ObjectUtils.isEmpty(dto.getContents())) {
            dto.setContents(board.getContents());
        }
        int updateCheck = dao.updateBoard(dto, boardSeq);
        Board updatedData = dao.selectBoardByBoardSeq(boardSeq);
        if(updateCheck != 0) {
            return ResponseEntity.ok().body(updatedData);
        }
        return ResponseEntity.badRequest().build();
    }

//    public ResponseEntity<List<Board>> selectBoardByTitle(Board dto) {
//        List<Board> selectBoardByTitle = dao.selectBoardByTitle(dto);
//        return ResponseEntity.ok().body(selectBoardByTitle);
//    }
//
//    public ResponseEntity<List<Board>> selectBoardByContents(Board dto) {
//        List<Board> selectBoardByContents = dao.selectBoardByContents(dto);
//        return ResponseEntity.ok().body(selectBoardByContents);
//    }

    public ResponseEntity<List<Board>> selectBoardByCategory(Board dto) {
        List<Board> selectBoardByCategory = dao.selectBoardByCategory(dto);
        return ResponseEntity.ok().body(selectBoardByCategory);
    }

    public ResponseEntity<List<Board>> selectBoardByCreateDate(Vo vo) {
        System.out.println("시작일 : " + vo.getSearchEndDate());
        System.out.println("종료일 : " + vo.getSearchEndDate());
        List<Board> selectBoardByCreateDate = dao.selectBoardByCreateDate(vo);
        return ResponseEntity.ok().body(selectBoardByCreateDate);
    }

}
