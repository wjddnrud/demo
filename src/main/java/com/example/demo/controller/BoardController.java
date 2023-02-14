package com.example.demo.controller;

import com.example.demo.dto.Board;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("")
    public ResponseEntity selectBoardList() {

        List<Board> boardlist = service.selectBoardList();

        return new ResponseEntity(boardlist, HttpStatus.OK);
    }

    @GetMapping("/{boardSeq}")
    public ResponseEntity selectOneBoard(@PathVariable Integer boardSeq) {
        Board oneBoard = service.selectOneBoard(boardSeq);
        if(oneBoard != null) {
            return new ResponseEntity(oneBoard, HttpStatus.OK);
        }
        return new ResponseEntity("존재하지 않는 게시물입니다.", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("")
    public ResponseEntity insertBoard(@RequestBody Board dto) {
        dto.setCreateDate(String.valueOf(LocalDateTime.now()));
        int insertCheck = service.insertBoard(dto);
        if(insertCheck != 0) {
            return new ResponseEntity(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>("게시물 등록에 실패했습니다.", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{boardSeq}")
    public ResponseEntity deleteBoard(@PathVariable Integer boardSeq) {
        Board deletedData = service.selectOneBoard(boardSeq);
        int deleteCheck = service.deleteBoard(boardSeq);
        if(deleteCheck != 0) {
            return new ResponseEntity(deletedData, HttpStatus.OK);
        }
        return new ResponseEntity("존재하지 않는 게시물입니다.", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{boardSeq}")
    public ResponseEntity updateBoard(@PathVariable Integer boardSeq, @RequestBody Board dto) {
        int updateCheck = service.updateBoard(dto, boardSeq);
        Board updatedData = service.selectOneBoard(boardSeq);
        if(updateCheck != 0) {
            return new ResponseEntity(updatedData, HttpStatus.OK);
        }
        return new ResponseEntity("존재하지 않는 게시물입니다.", HttpStatus.BAD_REQUEST);
    }

//    @PatchMapping("/{boardSeq}")
//    public ResponseEntity updateBoard(@PathVariable Integer boardSeq, @Valid @RequestBody Board dto) {
//
//        System.out.println("RequestBody에서 받아온 값 : " + dto.getClass());
////        원래 데이터 불러와서 거기에 새 데이터 덮어서 업데이트해주기
//        Board one = service.selectOneBoard(boardSeq);
//        System.out.println("RequestBody에서 받아온 값 : " + dto.getClass());
//
//
//
//        System.out.println(one.getWriter());
//        System.out.println(one.getTitle());
//        System.out.println(one.getContents());
//        System.out.println(one.getCreateDate());
//
//        int updateCheck = service.updateBoard(one, boardSeq);
//        Board updatedData = service.selectOneBoard(boardSeq);
//        if(updateCheck != 0) {
//            return new ResponseEntity(updatedData, HttpStatus.OK);
//        }
//        return new ResponseEntity("존재하지 않는 게시물입니다.", HttpStatus.BAD_REQUEST);
//    }
}
