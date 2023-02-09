package com.example.demo.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class TestController {

    @GetMapping(value = "/test")
    public Board test() {
        return new Board(1L, "test");
    }

    @Getter
    @RequiredArgsConstructor
    public static class Board {
        private final Long boardIdx;
        private final String subject;
    }

}
