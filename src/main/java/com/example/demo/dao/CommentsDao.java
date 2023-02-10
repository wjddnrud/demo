package com.example.demo.dao;

import com.example.demo.dto.Comments;
import org.apache.ibatis.annotations.Mapper;

import javax.xml.stream.events.Comment;
import java.util.List;

@Mapper
public interface CommentsDao {

    List<Comments> commentsList();

    void commentsInst(Comments dto);


}
