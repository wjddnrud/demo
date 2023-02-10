package com.example.demo.controller;

import com.example.demo.dto.Board;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//각 함수별로 @ResponseBody를 사용해주던것을 @RestController 하나로 전체가 같은 기능을 함
@RequestMapping("/boards")
//여러 게시물들의 집합(Collection)이므로 복수형으로 boards 사용
//@RequestMapping(value="")
//@RequestMapping
// 두가지 형태로 사용되지만 동작은 같다.

public class BoardController {

    @Autowired
    BoardService service;

    @GetMapping
    public List<Board> boardList() {

        List<Board> boardList = service.boardList();

        return boardList;

    }

    @PostMapping
//    http 메서드 중 하나인 POST 메서드를 사용하기 때문에 /insert or /write 같은 의미를 추가하지 않아야한다.
    public String boardInst(@RequestBody Board dto) {

        service.insert(dto);

        return dto.getBdSeq() + "번째 게시물 등록되었습니다.";
    }

    @DeleteMapping("/{bdSeq}")
    public String boardDel(@PathVariable Integer bdSeq) {

        service.delete(bdSeq);

        return "게시물이 삭제되었습니다.";
    }

    @GetMapping("/{bdSeq}")
//    복수형태의 Collection인 boards 다음으로 몇 번 게시물인지 표현하는 Document로 board_seq 사용
//    rest api uri부분에 실제 값을 입력해서 요청을 보내려면 위와같이 {}를 사용하여 안에 입력해줄 값의 객체명을 넣어준다.
//    아래에 보면 @RequestBody로 된 Board dto 파라미터로 Board안의 객체들과 맵핑 되겠지만
//    가독성과 정확한 명시를 위해 @PathVariable 어노테이션을 사용해주면 좋다.
    public Board boardView(@PathVariable("bdSeq") Integer seq) {

        System.out.println(seq);

        return service.selectOne(seq);
    }

    @PutMapping
    public String boardUpdt(@RequestBody Board dto) {

        service.update(dto);

//        다시 그 seq를 가지고 업데이트된 정보 불러와서 return에 보여주기

        return dto.getBdSeq() + "번째 게시물의 전체 리소스(PUT)가 수정되었습니다.";
    }


//    @GetMapping("/title/{bdTitle}")
//    public List<Board> selectOneFor(@PathVariable("bdTitle") String title) {
//
//        System.out.println(title);
//
//        return service.selectOneForTitle(title);
//    }

    @GetMapping("/title/{bdTitle}/createMonth/{month}")
    public List<Board> selectOneFor(@PathVariable("bdTitle") String title, @PathVariable("month") String month) {

        System.out.println(title);
        System.out.println(month);

        return service.selectOneForTitle(title, month);
    }




}
