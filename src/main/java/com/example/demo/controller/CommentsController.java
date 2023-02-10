package com.example.demo.controller;

import com.example.demo.dto.Comments;
import com.example.demo.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    CommentsService service;

    @GetMapping
    public List<Comments> commentsList() {

        return service.commentsList();
    }

    @PostMapping
    public String commentsInst(Comments dto) {

        service.commentsInst(dto);

        return dto.getCm_mmSeq() + "님이" + dto.getCm_bdSeq() + "번 게시물에 댓글 작성을 했습니다.";
    }


}
