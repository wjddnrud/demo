package com.example.demo.board;

import com.example.demo.dto.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
//각 함수별로 @ResponseBody를 사용해주던것을 @RestController 하나로 전체가 같은 기능을 함
@RequestMapping("/board")
//@RequestMapping(value="")
// 두가지 형태로 사용되지만 동작은 같다.

public class BoardController {

    @Autowired
    BoardService service;

    @GetMapping("/list")
    public List<Board> boardList(Model model) {

        List<Board> boardList = service.boardList();
//        model.addAttribute("boardList", boardList);

        return boardList;

    }

    @PostMapping("/write")
    public void boardInst() {

        service.insert();
    }

    @DeleteMapping("/delete")
    public String boardDel() {
        return service.delete();
    }

    @GetMapping("/view")
    public String boardView() {

        return service.selectOne();
    }




}
