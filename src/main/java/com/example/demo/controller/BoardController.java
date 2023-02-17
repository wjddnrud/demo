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

    @GetMapping("")
    public ResponseEntity selectBoardList(Board dto, Paging paging) { return service.selectBoardList(dto, paging); }

    @GetMapping("/search")
    public ResponseEntity searchBoardByTitle(Board dto, Paging paging) { return service.searchBoardByTitle(dto, paging); }

    @GetMapping("/{boardSeq}")
    public ResponseEntity selectOneBoardByBoardSeq(@PathVariable("boardSeq") Integer boardSeq) { return service.selectOneBoardByBoardSeq(boardSeq); }

    @PostMapping("")
    public ResponseEntity insertBoard(@Valid @RequestBody Board dto) { return service.insertBoard(dto); }

    @DeleteMapping("/{boardSeq}")
    public ResponseEntity deleteBoard(@PathVariable Integer boardSeq) { return service.deleteBoard(boardSeq); }

    @PatchMapping("/{boardSeq}")
    public ResponseEntity updateBoard(@RequestBody Board dto, @PathVariable("boardSeq") Integer boardSeq) { return service.updateBoard(dto, boardSeq); }
}