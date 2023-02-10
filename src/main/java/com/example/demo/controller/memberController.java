package com.example.demo.controller;

//multiple choices 에러가 발생해서 dto import해줌
import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class memberController {

    @Autowired
    MemberService service;

    @GetMapping
    public List<Member> memberList() {

        return service.memberList();
    }

    @PostMapping
    public String memberInst(@RequestBody Member dto) {

        service.memberInst(dto);

        return dto.getMmName() + "님 회원 가입을 축하드립니다!";
    }

    @GetMapping("/{mmName}")
    public Member memberSelectOne(@PathVariable("mmName") String name) {

        return service.selectOneForName(name);
    }



}
