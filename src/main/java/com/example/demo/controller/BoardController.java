package com.example.demo.controller;

import com.example.demo.dto.Board;
import com.example.demo.dto.Paging;
import com.example.demo.service.BoardService;
import com.example.demo.vo.Vo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/page/{num}")
    public ResponseEntity<List<Board>> selectBoardListByThisPage(@PathVariable("num") int thisPage, Paging paging) { return service.selectBoardListByThisPage(thisPage, paging); }

    @GetMapping("")
    public ResponseEntity<List<Board>> selectBoardAll() { return service.selectBoardAll(); }

    @GetMapping("/{boardSeq}")
    public ResponseEntity<Board> selectBoardByBoardSeq(@PathVariable Integer boardSeq) { return service.selectBoardByBoardSeq(boardSeq); }

    @GetMapping("/title")
    public ResponseEntity<List<Board>> selectBoardByTitle(@RequestBody Board dto) { return service.selectBoardByCategory(dto); }

    @GetMapping("/contents")
    public ResponseEntity<List<Board>> selectBoardByContents(@RequestBody Board dto) { return service.selectBoardByCategory(dto); }

    @GetMapping("/createDate")
    public ResponseEntity<List<Board>> selectBoardByCreateDate(@RequestBody Vo vo) { return service.selectBoardByCreateDate(vo);}

    @PostMapping("")
    public ResponseEntity<Board> insertBoard(@RequestBody Board dto) { return service.insertBoard(dto); }

    @DeleteMapping("/{boardSeq}")
    public ResponseEntity<Board> deleteBoard(@PathVariable Integer boardSeq) { return service.deleteBoard(boardSeq); }

    @PatchMapping("/{boardSeq}")
    public ResponseEntity<Board> updateBoard(@PathVariable("boardSeq") Integer boardSeq, @RequestBody Board dto) { return service.updateBoard(dto, boardSeq); }
}
