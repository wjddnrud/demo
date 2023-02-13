package com.example.demo.controller;

import com.example.demo.dto.Board;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.type.UnionType;
import java.net.HttpURLConnection;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {


    private final BoardService service;

    @GetMapping("")
    public List<Board> boardList() {
        return service.boardList();
    }

//    @PostMapping("")
//    public ResponseEntity boardInsert(@RequestBody Board dto) {
////        인서트 에러 발생시 예외 처리 ...?
//        service.boardInsert(dto);
//        return new ResponseEntity("게시물이 등록되었습니다.", HttpStatus.OK);
//    }

    @PostMapping("")
    public Board boardInserts(@RequestBody Board dto) {
        dto.setBdCreateDate(String.valueOf(LocalDate.now()));
        service.boardInsert(dto);
        return dto;
    }

//    @PostMapping("")
//    public ResponseEntity boardInserts(@RequestBody Board dto) {
//        Map<String, Object> result = new HashMap<>();
//        int InsertResult = service.boardInsert(dto);
//        System.out.println("insert : " + InsertResult);
//        result.put("contents", dto.getBdContents());
//        result.put("title", dto.getBdTitle());
//        result.put("writer", dto.getBdWriter());
//
////        if(InsertResult != null) {
////            return new ResponseEntity(result + "<br>게시물이 성공적으로 등록되었습니다.</br>", HttpStatus.OK);
////        } else {
////            return new ResponseEntity(result + "<br>게시물이 등록에 문제가 발생하였습니다.</br>", HttpStatus.);
////        }
//        return new ResponseEntity(result + "<br>게시물이 성공적으로 등록되었습니다.</br>", HttpStatus.OK);
//    }

    @DeleteMapping("/{bdSeq}")
    public String boardDelete(@RequestBody Board dto) {
        Board one = service.boardSelectOne(dto);
        service.boardDelete(dto);
        return "게시물이 삭제되었습니다.";
    }

    @PutMapping("")
    public String boardUpdate(@RequestBody Board dto) {
        service.boardUpdate(dto);
        return "success";
    }

//    @GetMapping("/{bdSeq}")
//    public Board boardSelectOne(@PathVariable("bdSeq") Integer seq) {
//        Board boardOne = service.boardSelectOne(seq);
//        System.out.println("boardSelectOne : " + boardOne);
//        return service.boardSelectOne(seq);
//    }

    @GetMapping("/{bdSeq}")
    public ResponseEntity boardSelectOne(@RequestBody Board dto) {
        Board one = service.boardSelectOne(dto);
        if(one == null) {
            return new ResponseEntity("해당 게시물은 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(one, HttpStatus.OK);
    }

//    @RequestMapping("/{bdSeq}")
//    @ResponseBody
//    public Map<String, Object> board(@PathVariable Integer bdSeq) {
//
//        Map<String, Object> result = new HashMap<>();
//        Board one = service.boardSelectOne(bdSeq);
//        result.put("writer", one.getBdWriter());
//        result.put("title", one.getBdTitle());
//        result.put("contents", one.getBdContents());
//        result.put("createDate", one.getBdCreateDate());
//
//        return result;
//    }
}
