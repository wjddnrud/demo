package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {

    private Integer boardSeq;
    private String writer;
    private String title;
    private String contents;
    private String createDate;
}
