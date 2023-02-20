package com.example.demo.service;

import com.example.demo.dao.BoardDao;
import com.example.demo.dto.Board;
import com.example.demo.dto.Paging;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDao dao;

    public void setParamPaging(Board boardDto, Paging pagingDto) {
        pagingDto.setParamsPaging(dao.boardCount(boardDto));
    }

    public ResponseEntity<?> selectBoardList(Board boardDto, Paging pagingDto) {
        setParamPaging(boardDto, pagingDto);
        List<Board> selectBoardList = dao.selectBoardList(pagingDto);
        Map<String, Object> result = new HashMap<>();
        result.put("페이징 정보", pagingDto);
        result.put("조회된 게시물", selectBoardList);
        if (selectBoardList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("게시물이 없습니다.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public ResponseEntity<?> searchBoardByTitle(Board boardDto, Paging pagingDto) {
        setParamPaging(boardDto, pagingDto);
        List<Board> searchBoardByTitle = dao.searchBoardByTitle(boardDto, pagingDto);
        if(searchBoardByTitle.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("게시물이 없습니다.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(searchBoardByTitle);
    }

    public ResponseEntity<?> selectOneBoardByBoardSeq(Integer boardSeq) {
        Board selectOneBoardByBoardSeq = dao.selectOneBoardByBoardSeq(boardSeq);
        if(selectOneBoardByBoardSeq == null) {
            return ResponseEntity.status(HttpStatus.OK).body("존재하지 않는 게시물입니다.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(selectOneBoardByBoardSeq);
    }

    public ResponseEntity<String> insertBoard(Board boardDto) {
        dao.insertBoard(boardDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("게시물이 등록되었습니다.");
    }

    public ResponseEntity<String> deleteBoard(Integer boardSeq) {
        dao.deleteBoard(boardSeq);
        return ResponseEntity.status(HttpStatus.OK).body("게시물이 삭제되었습니다.");
    }

    public ResponseEntity<String> updateBoard(Board boardDto, Integer boardSeq) {
        Board board = dao.selectOneBoardByBoardSeq(boardSeq);
        if(!StringUtils.hasText(boardDto.getTitle())) {
            boardDto.setTitle(board.getTitle());
        }
        if(!StringUtils.hasText(boardDto.getContents())) {
            boardDto.setContents(board.getContents());
        }
        dao.updateBoard(boardDto, boardSeq);
        return ResponseEntity.status(HttpStatus.CREATED).body("게시물이 수정되었습니다.");
    }
}