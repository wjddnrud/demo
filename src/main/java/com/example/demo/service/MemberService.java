package com.example.demo.service;

import com.example.demo.dao.MemberDao;
import com.example.demo.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberDao dao;

    public List<Member> memberList() {

        return dao.memberList();
    }

    public void memberInst(Member dto) {

        dao.memberInst(dto);
    }

    public Member selectOneForName(String name) {

        return dao.selectOneForName(name);
    }


}
