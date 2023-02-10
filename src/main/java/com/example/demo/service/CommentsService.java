package com.example.demo.service;

import com.example.demo.dao.CommentsDao;
import com.example.demo.dto.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    @Autowired
    CommentsDao dao;

    public List<Comments> commentsList() {

        return dao.commentsList();
    }

    public void commentsInst(Comments dto) {

        dao.commentsInst(dto);
    }


}
