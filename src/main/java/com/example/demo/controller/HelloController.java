package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/jsp")
    public String hello() {
        return "hello";
        // 자동으로 hello.jsp 파일을 찾아서 웹에서 보여준다.
    }

}
