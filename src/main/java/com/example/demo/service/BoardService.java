package com.example.demo.service;

import com.example.demo.dao.BoardDao;
import com.example.demo.dto.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDao dao;

    public ResponseEntity<?> selectBoardAll() {
        List<Board> boardlist = dao.selectBoardAll();
        if(boardlist.isEmpty()) {
            return new ResponseEntity<String>("게시물이 없습니다.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(boardlist, HttpStatus.OK);
    }

    public ResponseEntity<?> selectBoardByBoardSeq(Integer boardSeq) {
        Board board = dao.selectBoardByBoardSeq(boardSeq);
        if(board != null) {
            return new ResponseEntity<Board>(board, HttpStatus.OK);
        }
        return new ResponseEntity<String>("존재하지 않는 게시물입니다.", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> insertBoard(Board dto) {
        dto.setCreateDate(String.valueOf(LocalDateTime.now()));
        int insertCheck = dao.insertBoard(dto);
        if(insertCheck != 0) {
            return new ResponseEntity<Board>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<String>("게시물 등록에 실패했습니다.", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> deleteBoard(Integer boardSeq) {
        Board deletedData = dao.selectBoardByBoardSeq(boardSeq);
        int deleteCheck = dao.deleteBoard(boardSeq);
        if(deleteCheck != 0) {
            return new ResponseEntity<Board>(deletedData, HttpStatus.OK);
        }
        return new ResponseEntity<String>("존재하지 않는 게시물입니다.", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> updateBoard(Board dto, Integer boardSeq) {
        Board board = dao.selectBoardByBoardSeq(boardSeq);
        if(board == null) {
            return new ResponseEntity<String>("해당 게시물이 없습니다.", HttpStatus.NOT_FOUND);
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
            return new ResponseEntity<Board>(updatedData, HttpStatus.OK);
        }
        return new ResponseEntity<String>("게시물 수정에 문제가 발생했습니다.", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity selectBoardByTitle(Board dto) {
        System.out.println(dto.getTitle());

        List<Board> selectBoardByTitle = dao.selectBoardByTitle(dto);

        return new ResponseEntity(selectBoardByTitle, HttpStatus.OK);
    }
}
