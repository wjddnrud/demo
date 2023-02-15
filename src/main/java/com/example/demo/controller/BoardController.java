package com.example.demo.controller;

import com.example.demo.dto.Board;
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
    public ResponseEntity selectBoardAll() { return service.selectBoardAll(); }

    @GetMapping("/{boardSeq}")
    public ResponseEntity selectBoardByBoardSeq(@PathVariable Integer boardSeq) { return service.selectBoardByBoardSeq(boardSeq); }

    @GetMapping("/title")
    public ResponseEntity selectBoardByTitle(@RequestBody Board dto) { return service.selectBoardByTitle(dto);}

    @PostMapping("")
    public ResponseEntity insertBoard(@RequestBody Board dto) { return service.insertBoard(dto); }

    @DeleteMapping("/{boardSeq}")
    public ResponseEntity deleteBoard(@PathVariable Integer boardSeq) { return service.deleteBoard(boardSeq); }

    @PatchMapping("/{boardSeq}")
    public ResponseEntity updateBoard(@PathVariable("boardSeq") Integer boardSeq, @RequestBody Board dto) { return service.updateBoard(dto, boardSeq); }
}
