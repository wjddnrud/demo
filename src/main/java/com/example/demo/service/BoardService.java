package com.example.demo.service;

import com.example.demo.dao.BoardDao;
import com.example.demo.dto.Board;
import com.example.demo.dto.Paging;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDao dao;

    public void setParamPaging(Board dto, Paging paging) {
        paging.setParamsPaging(dao.boardCount(dto));
    }

    public ResponseEntity<?> selectBoardList(Board dto, Paging paging) {
        setParamPaging(dto, paging);
        List<Board> selectBoardList = dao.selectBoardList(paging);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("페이징 관련 정보", paging);
        resultMap.put("조회된 게시글 리스트", selectBoardList);
        if (selectBoardList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("게시물이 없습니다.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(resultMap);
    }

    public ResponseEntity<?> searchBoardByTitle(Board dto, Paging paging) {
        if(dto.getTitle() == null) {
            return ResponseEntity.status(HttpStatus.OK).body("검색할 글 제목을 입력해주세요.");
        }
        setParamPaging(dto, paging);
        List<Board> searchBoardByTitle = dao.searchBoardByTitle(dto, paging);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("페이징 관련 정보", paging);
        resultMap.put("조회된 게시글 리스트", searchBoardByTitle);
        if(searchBoardByTitle.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("게시물이 없습니다.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(resultMap);
    }

    public ResponseEntity<?> selectOneBoardByBoardSeq(Integer boardSeq) {
        Board selectOneBoardByBoardSeq = dao.selectOneBoardByBoardSeq(boardSeq);
        if(selectOneBoardByBoardSeq == null) {
            return ResponseEntity.status(HttpStatus.OK).body("존재하지 않는 게시물입니다.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(selectOneBoardByBoardSeq);
    }

    public ResponseEntity<?> insertBoard(Board dto) {
        dto.setCreateDate(String.valueOf(LocalDateTime.now()));
        int insertCheck = dao.insertBoard(dto);
        if(insertCheck != 1) {
            return ResponseEntity.status(HttpStatus.OK).body("게시물 등록에 실패하였습니다.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    public ResponseEntity<?> deleteBoard(Integer boardSeq) {
        Board deletedData = dao.selectOneBoardByBoardSeq(boardSeq);
        int deleteCheck = dao.deleteBoard(boardSeq);
        if(deleteCheck != 1) {
            return ResponseEntity.status(HttpStatus.OK).body("존재하지 않는 게시물입니다.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(deletedData);
    }

    public ResponseEntity<?> updateBoard(Board dto, Integer boardSeq) {
        Board board = dao.selectOneBoardByBoardSeq(boardSeq);
        if(board == null) {
            return ResponseEntity.status(HttpStatus.OK).body("존재하지 않는 게시물입니다.");
        }
        if(ObjectUtils.isEmpty(dto.getTitle())) {
            dto.setTitle(board.getTitle());
        }
        if(ObjectUtils.isEmpty(dto.getContents())){
            dto.setContents(board.getContents());
        }
        int updateCheck = dao.updateBoard(dto, boardSeq);
        Board updatedData = dao.selectOneBoardByBoardSeq(boardSeq);
        if(updateCheck != 1) {
            return ResponseEntity.status(HttpStatus.OK).body("게시물 수정에 실패하였습니다.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedData);
    }
}