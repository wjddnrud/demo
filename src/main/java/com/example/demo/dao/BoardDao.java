package com.example.demo.dao;

import com.example.demo.dto.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {

    List<Board> selectList();

    void insert();

    String delete();

    String selectOne();



}
