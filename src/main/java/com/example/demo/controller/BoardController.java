package com.example.demo.controller;

import com.example.demo.dto.Board;
import com.example.demo.dto.Paging;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping(value="")
    public ResponseEntity selectBoardList(Board boardDto, Paging pagingDto) { return service.selectBoardList(boardDto, pagingDto); }

    @GetMapping(value="/search")
    public ResponseEntity searchBoardByTitle(Board boardDto, Paging pagingDto) { return service.searchBoardByTitle(boardDto, pagingDto); }

    @GetMapping(value="/{boardSeq}")
    public ResponseEntity<?> selectOneBoardByBoardSeq(@PathVariable("boardSeq") Integer boardSeq) { return service.selectOneBoardByBoardSeq(boardSeq); }

    @PostMapping(value="")
    public ResponseEntity<String> insertBoard(@Valid @RequestBody Board boardDto) { return service.insertBoard(boardDto); }

    @DeleteMapping(value="/{boardSeq}")
    public ResponseEntity<String> deleteBoard(@PathVariable("boardSeq") Integer boardSeq) { return service.deleteBoard(boardSeq); }

    @PatchMapping(value="/{boardSeq}")
    public ResponseEntity<String> updateBoard(@RequestBody Board boardDto, @PathVariable("boardSeq") Integer boardSeq) { return service.updateBoard(boardDto, boardSeq); }
}