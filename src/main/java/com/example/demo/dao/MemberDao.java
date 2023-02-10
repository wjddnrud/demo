package com.example.demo.dao;

import com.example.demo.dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberDao {

    List<Member> memberList();

    void memberInst(Member dto);

    Member selectOneForName(String name);
}
